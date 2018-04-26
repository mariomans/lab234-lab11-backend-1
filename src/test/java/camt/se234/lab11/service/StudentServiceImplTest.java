package camt.se234.lab11.service;

import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.dao.StudentDaoImpl;
import camt.se234.lab11.dao.StudentDao_B_Impl;
import camt.se234.lab11.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    StudentDao studentDao;
    StudentServiceImpl studentService;

    @Before
    public void setup() {
        studentDao = mock(StudentDao.class);
        studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
    }

    @Test
    public void testFindById() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.findStudentById("123"), is(new Student("123", "A", "temp", 2.33)));
        assertThat(studentService.findStudentById("124"), is(new Student("124", "B", "team", 3.00)));
        assertThat(studentService.findStudentById("125"), is(new Student("125", "C", "teemo", 2.5)));
    }


    @Test
    public void testGetAverageGpa() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.getAverageGpa(), is(2.61));
        StudentDao_B_Impl studentDao_B = new StudentDao_B_Impl();
        studentService.setStudentDao(studentDao_B);
        assertThat(studentService.getAverageGpa(), is(4.0));

    }

    @Test
    public void testFindByPartOfId() {
        StudentDao studentDao = mock(StudentDao.class);
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123", "A", "temp", 2.33));
        mockStudents.add(new Student("124", "B", "temp", 2.33));
        mockStudents.add(new Student("223", "C", "temp", 2.46));
        mockStudents.add(new Student("224", "D", "temp", 2.88));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentByPartOfId("22"),
                hasItem(new Student("223", "C", "temp", 2.46)));
        assertThat(studentService.findStudentByPartOfId("22"),
                hasItems(new Student("223", "C", "temp", 2.46),
                        new Student("224", "D", "temp", 2.88)));

        assertThat(studentService.findStudentByPartOfId("24"),
                hasItem(new Student("224", "D", "temp", 2.88)));


        assertThat(studentService.findStudentByPartOfId("2"),
                hasItems(new Student("124", "B", "temp", 2.33),
                        new Student("224", "D", "temp", 2.88)));

    }

    @Test
    public void testWithMock() {
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123", "A", "temp", 2.33));
        mockStudents.add(new Student("124", "A", "temp", 2.33));
        mockStudents.add(new Student("223", "A", "temp", 2.46));
        mockStudents.add(new Student("224", "A", "temp", 2.88));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("123"), is(new Student("123", "A", "temp", 2.33)));
        assertThat(studentService.getAverageGpa(), is(2.5));

    }

    @Test
    public void testWinMock1() {
        List<Student> mockStudents3 = new ArrayList<>();
        mockStudents3.add(new Student("225", "A", "temp", 3.44));
        mockStudents3.add(new Student("226", "A", "temp", 3.45));
        mockStudents3.add(new Student("227", "A", "temp", 3.21));
        mockStudents3.add(new Student("228", "A", "temp", 2.98));
        when(studentDao.findAll()).thenReturn(mockStudents3);
        assertThat(studentService.findStudentById("225"), is(new Student("225", "A", "temp", 3.44)));
        assertThat(studentService.getAverageGpa(), is(3.2700000000000005));


    }

    @Test
    public void testWinMock2() {
        List<Student> mockStudents2 = new ArrayList<>();
        ;
        mockStudents2.add(new Student("235", "A", "temp", 2.45));
        mockStudents2.add(new Student("236", "A", "temp", 3.45));
        mockStudents2.add(new Student("237", "A", "temp", 2.46));
        mockStudents2.add(new Student("238", "A", "temp", 2.90));
        when(studentDao.findAll()).thenReturn(mockStudents2);
        assertThat(studentService.findStudentById("238"), is(new Student("238", "A", "temp", 2.90)));
        assertThat(studentService.getAverageGpa(), is(2.815));


    }

    @Test(expected = NoDataException.class)
    public void testNoDataException() {
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123", "A", "temp", 2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("55"), nullValue());
    }
}