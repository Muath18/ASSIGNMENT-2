/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.ArrayList;

public class Course {
    private Department dept;
    private String title; // title of the course (e.g. “Intro to programming”);
    private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
    private int number; // course number, e.g. 1200, 2710, 2800, etc.
    ArrayList<Student> classList = new ArrayList<Student>(); // contains all students registered in this course
    public Department getDept() {
        return this.dept;
    }
    public String getCode() {
        return this.code;
    }
    public int getNumber(){
        return this.number;
    }
    public Course(String code, int number, Department dept, String title) {
        // also initialize the classList;
        this.code=code;
        this.number=number;
        this.dept=dept;
        this.title=title;
    }
    public String toString() {
        // return a string representation of the course with the course code,
        // name, and number of people registered in the course in the following
        // format:
        // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
        String str;
        str=code+" "+number+" "+title+", "+"Enrollment = "+classList.size();
        return str;
 }

}
