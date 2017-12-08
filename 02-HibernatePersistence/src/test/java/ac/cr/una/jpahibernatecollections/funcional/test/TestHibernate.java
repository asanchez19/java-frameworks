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
package ac.cr.una.jpahibernatecollections.funcional.test;

import ac.cr.una.jpahibernatecollections.HibernateUtil;
import ac.cr.una.jpahibernatecollections.model.Department;
import ac.cr.una.jpahibernatecollections.model.Employee;
import org.hibernate.Session;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 *
 * @author mguzmana
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate {

    private static Session session;
    private static long idEmployee;

    public TestHibernate() {
    }

    // Inicia la configuración del Hibernate
    @Before
    public void setUp() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Despues de todos los test, se cierra la sesion y el Hibernate se cierra
    @AfterClass
    public static void tearDown() {
        session.close();
        HibernateUtil.shutdown();
    }

    @Test
    public void test1Save() {

        // begin a transaction
        session.beginTransaction();

        //creating a department object
        Department department = new Department();
        department.setDeptName("developement");

        // save department object
        session.save(department);
        System.out.println("Department saved, id:  " + department.getId());

        //creating an employee object
        Employee employee = new Employee();
        employee.setFirstName("Mike Guzman");
        employee.setSalary(50000);
        //  set department of employee
        employee.setDepartment(department);

        // save employee object
        session.save(employee);

        // guarda el ultimo id del objeto en la BD
        idEmployee = employee.getId();

        System.out.println("Employee saved, id:  " + employee.getId());

        // commit transaction
        session.getTransaction().commit();

        assertTrue(idEmployee > 0);

    }

    @Test
    public void test2Fetch() {
        Employee employee = (Employee) session.get(Employee.class, idEmployee);

        if (employee != null) {
            System.out.println(employee.toString());
        }

        assertNotNull(employee);
    }

    @Test
    public void test3Update() {

        Employee employee = (Employee) session.get(Employee.class, idEmployee);

        System.out.println("\nOld Employee...");
        System.out.println(employee.toString());

        session.getTransaction().begin();
        /* Line 9 */ employee.setFirstName("Juan");
        /* Line 10 */ session.update(employee);
        session.getTransaction().commit();

        System.out.println("\nEmployee after Update...");
        System.out.println(employee.toString());

        assertEquals(employee.getFirstName(), "Juan");
    }

    @Test
    public void test4Delete() {
        Employee employee = null;

        session.getTransaction().begin();
        employee = (Employee) session.get(Employee.class, idEmployee);
        session.delete(employee);
        session.getTransaction().commit();

        employee = (Employee) session.get(Employee.class, idEmployee);

        assertNull(employee);
    }

}
