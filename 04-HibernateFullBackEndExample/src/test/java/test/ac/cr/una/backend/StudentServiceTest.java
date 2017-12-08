/*
 * Copyright (C) 2016 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
package test.ac.cr.una.backend;

import ac.cr.una.backend.dao.StudentDAO;
import ac.cr.una.backend.dao.StudentDAOHibernateImpl;
import ac.cr.una.backend.dao.StudentDAOJdbcImpl;
import ac.cr.una.backend.model.Student;
import ac.cr.una.backend.service.StudentService;
import ac.cr.una.backend.service.StudentServiceImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author mguzmana
 */
public class StudentServiceTest {

    private StudentDAO studentDAO;
    private StudentService studentService;

    public StudentServiceTest() {
    }

    @Test
    public void testFindById() {
        studentDAO = mock(StudentDAOHibernateImpl.class);
        studentService = new StudentServiceImpl(studentDAO);

        Student student = new Student();
        student.setName("Mike");
        student.setCourse("Progra III");
        student.setRating("A+");

        when(studentService.findById(1)).thenReturn(student);

        assertThat(student.getName(), is("Mike"));
    }

    @Test
    public void testFindByIdJdbc() {
        studentDAO = mock(StudentDAOJdbcImpl.class);
        studentService = new StudentServiceImpl(studentDAO);

        Student student = new Student();
        student.setName("Mike");
        student.setCourse("Progra III");
        student.setRating("A+");

        when(studentService.findById(1)).thenReturn(student);

        assertThat(student.getName(), is("Mike"));
    }

    @Test
    public void testSave() {
        studentDAO = mock(StudentDAOHibernateImpl.class);
        studentService = new StudentServiceImpl(studentDAO);

        Student student = new Student();
        student.setName("Mike");
        student.setCourse("Progra III");
        student.setRating("A+");

        when(studentDAO.save(any(Student.class)))
                .thenAnswer(new Answer<Student>() {
                    @Override
                    public Student answer(InvocationOnMock invocation) throws Throwable {
                        Student student = (Student) invocation.getArguments()[0];
                        student.setId(1);
                        return student;
                    }
                });

        assertNotNull(student.getId());

        student = studentService.save(student);

        assertNotNull(student.getId());
        assertTrue(student.getId() > 0);
    }

    @Test
    public void testSaveJdbc() {
        studentDAO = mock(StudentDAOJdbcImpl.class);
        studentService = new StudentServiceImpl(studentDAO);

        Student student = new Student();
        student.setName("Mike");
        student.setCourse("Progra III");
        student.setRating("A+");

        when(studentDAO.save(any(Student.class)))
                .thenAnswer(new Answer<Student>() {
                    @Override
                    public Student answer(InvocationOnMock invocation) throws Throwable {
                        Student student = (Student) invocation.getArguments()[0];
                        student.setId(1);
                        return student;
                    }
                });

        assertNotNull(student.getId());

        student = studentService.save(student);

        assertNotNull(student.getId());
        assertTrue(student.getId() > 0);
    }

}
