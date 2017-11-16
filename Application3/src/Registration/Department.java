/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.ArrayList;

public class Department {
    private String name; // the name of school “Dept of Computing and Info Science”
    private String id; // short name for courses “SOFE”, “ELEE”, “STAT”, etc
    public ArrayList<Course> courseList=new ArrayList<Course>(); // all courses offered by the department
    public ArrayList<Student> registerList=new ArrayList<Student>(); // all students taking courses in the department.
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
    public Department(String name, String id) {
        // also initialize the arraylists
        this.name=name;
        this.id=id;
    }
    public String toString() {
        // returns a string representation of department name, number
        // of courses offered and number of students registered in the
        // department. Use the format:
        // ECSE: 53 courses, 460 students
        String str;
        str=name+": "+courseList.size()+" courses, "+registerList.size()+" students";
        return str;
    }

    public void offerCourse(Course c) {
        courseList.add(c);
    }

    void printCoursesOffered() {
        for (Course c : courseList) {
            System.out.println(c.toString());
        }
    }

    void printStudentsByName() {
        for (Course c : courseList) {
            for (Student s : c.classList) {
                System.out.println(s.toString());
            }
        }
    }

    boolean isStudentRegistered(Student student) {
        int flag=0;

         for (Course c : courseList) {
            for (Student s : c.classList) {
                if(s.getId().equalsIgnoreCase(student.getId())){
                    flag=1;
                }
            }
        }
        if (flag==0){
            return false;
        }
        else{
            return true;
        }
         
    }
    
    ArrayList<Student> studentsRegisteredInCourse(int code){
        ArrayList<Student> studentList=new ArrayList<Student>();
        for (Course c : courseList) {
            if (c.getNumber()==code){
                for (Student s : c.classList) {
                    
                studentList.add(s);
            }
             
            }
        }
        return studentList;
    }
    
    void printStudentsRegisteredInCourse(int i) {
        
        ArrayList<Student> newstudentList =studentsRegisteredInCourse(i);
         for (Student c : newstudentList) {
            
             System.out.println(c.getId()+" "+c.getName());
            }
        
    }

    String largestCourse() {
        int largest=0;
 
        for (Course c : courseList) {
                if(largest<c.classList.size()){
                    largest=c.classList.size();
                    return c.toString();
                }
            
        }
        return courseList.get(0).toString();
        
    }
}

