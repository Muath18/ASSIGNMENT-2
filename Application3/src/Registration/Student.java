/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.ArrayList;


public class Student {

    private String id;
    private String name;
    private ArrayList<Course> courses=new ArrayList<Course>(); // contains all courses the student is registered in
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
    // constructor
    public Student(String id, String name) {
        // initialize name and id. Also initialize the ArrayList
        this.id=id;
        this.name=name;
    }

    public void registerFor(Course course) {
         
         int flag=0;
         for (Course c : courses) {
           if(c.getCode().equalsIgnoreCase(course.getCode()) && c.getNumber()==course.getNumber() ){
               flag=1;
           }
        }
        if (flag==0){
            courses.add(course);
            course.classList.add(this);
            course.getDept().courseList.add(course);
            course.getDept().registerList.add(this);
        }
    }
    
    public String toString() {
        // return a string representation of a student using the following format:
        // 100234546 John McDonald
        // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
        String str;
        str=id+" "+name;
        /*for (Course c : courses) {
           str=str+c.getCode()+" "+c.getNumber();
        }*/
        return str;
    }

    boolean isRegisteredInCourse(Course course) {
        int flag=0;
         for (Course c : courses) {
           if(c.getCode().equalsIgnoreCase(course.getCode()) && c.getNumber()==course.getNumber() ){
               flag=1;
           }
        }
        if (flag==0){
            return false;
        }
        else{
            return true;
        }
    }
}    

