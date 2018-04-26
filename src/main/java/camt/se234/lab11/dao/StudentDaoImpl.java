package camt.se234.lab11.dao;

import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    List<Student> students;
    public StudentDaoImpl(){
        students = new ArrayList<>();
        students.add(new Student("123","A","temp",2.33));
        students.add(new Student("124","B","team",3.00));
        students.add(new Student("125","C","teemo",2.5));

    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }
}
