/*
 * Copyright (C) 2017 mguzmana
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
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.StudentDAO;
import ac.cr.una.backend.dao.StudentDAOHibernateImpl;
import ac.cr.una.backend.model.Student;
import ac.cr.una.backend.service.StudentService;
import ac.cr.una.backend.service.StudentServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mguzmana
 */
@Path("students")
public class StudentWebservice {

    private StudentDAO studentDAO;
    private StudentService studentService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentWebservice() {
    }

    /**
     * Retrieves All the Students
     *
     * @return Student
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        List<Student> studentList = null;
        studentDAO = new StudentDAOHibernateImpl();
        studentService = new StudentServiceImpl(studentDAO);

        studentList = studentService.findAll();

        return studentList;
    }

    /**
     * Retrieves only one student
     *
     * @param id
     * @return Student
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudents(@PathParam("id") int id) {
        Student student = null;
        studentDAO = new StudentDAOHibernateImpl();
        studentService = new StudentServiceImpl(studentDAO);

        student = studentService.findById(id);

        return student;
    }

    /**
     * Create a new Student
     *
     * @param student
     * @return student
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student createStudent(Student student) {

        studentDAO = new StudentDAOHibernateImpl();
        studentService = new StudentServiceImpl(studentDAO);

        student = studentService.save(student);

        return student;
    }

    /**
     * Delete a new Student
     *
     * @param id
     * @return student
     */
    @DELETE
    @Path("/{id}")
    public boolean deleteStudent(@PathParam("id") int id) {
        boolean result;
        studentDAO = new StudentDAOHibernateImpl();
        studentService = new StudentServiceImpl(studentDAO);

        result = studentService.delete(id);

        return result;
    }

    /**
     * Update a Student
     *
     * @param student
     * @return student
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student) {

        studentDAO = new StudentDAOHibernateImpl();
        studentService = new StudentServiceImpl(studentDAO);

        student = studentService.update(student);

        return student;
    }

}
