package camt.se234.lab11.dao;

import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao_B_Impl implements StudentDao {
    List<Student> students;
    public StudentDao_B_Impl(){
        students = new ArrayList<>();
        students.add(new Student("112","A","temp",4.0));
        students.add(new Student("113","James","Taylor",4.0));
        students.add(new Student("114","Andrew","Dope",4.0));
        students.add(new Student("115","Mark","Xiao",4.0));
        students.add(new Student("116","Kevin","Space",4.0));
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }
}
