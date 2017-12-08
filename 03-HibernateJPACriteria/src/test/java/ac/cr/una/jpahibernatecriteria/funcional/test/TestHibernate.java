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
package ac.cr.una.jpahibernatecriteria.funcional.test;

import ac.cr.una.jpahibernatecriteria.HibernateUtil;
import ac.cr.una.jpahibernatecriteria.model.Department;
import ac.cr.una.jpahibernatecriteria.model.Employee;
import org.hibernate.Session;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author mguzmana
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate {

    private static Session session;
    private static long idEmployee1;
    private static long idEmployee2;
    private static long idEmployee3;

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
    public void test1CleanTable() {
        List<Employee> employees = null;
        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);

        //Use criteria to query with session to fetch all contacts
        employees = session.createQuery(criteria).getResultList();

        session.getTransaction().begin();
        for (Employee employee : employees) {
            session.delete(employee);
        }
        session.getTransaction().commit();

        //Use criteria to query with session to fetch all contacts
        employees = session.createQuery(criteria).getResultList();

        assertTrue(employees.size() == 0);
    }

    @Test
    public void test2CreateSaveObjects() {

        // begin a transaction
        session.beginTransaction();

        //creating a department object
        Department department = new Department();
        department.setDeptName("developement");

        // save department object
        session.save(department);
        System.out.println("Department saved, id:  " + department.getId());

        //creating an employee object
        Employee employee1 = new Employee();
        employee1.setFirstName("Mike Guzman");
        employee1.setSalary(50000);
        //  set department of employee
        employee1.setDepartment(department);

        // save employee object
        session.save(employee1);

        // guarda el ultimo id del objeto en la BD
        idEmployee1 = employee1.getId();

        //creating an employee object
        Employee employee2 = new Employee();
        employee2.setFirstName("Gonzalo Guzman");
        employee2.setSalary(60000);
        //  set department of employee
        employee2.setDepartment(department);

        // save employee object
        session.save(employee2);

        // guarda el ultimo id del objeto en la BD
        idEmployee2 = employee2.getId();

        //creating an employee object
        Employee employee3 = new Employee();
        employee3.setFirstName("Maria Sánchez");
        employee3.setSalary(70000);
        //  set department of employee
        employee3.setDepartment(department);

        // save employee object
        session.save(employee3);

        // guarda el ultimo id del objeto en la BD
        idEmployee3 = employee3.getId();


        // commit transaction
        session.getTransaction().commit();

        assertTrue(idEmployee1 > 0);
        assertTrue(idEmployee2 > 0);
        assertTrue(idEmployee3 > 0);

    }

    @Test
    public void test3CriteriaAll() {

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);

        //Use criteria to query with session to fetch all contacts
        List<Employee> employees = session.createQuery(criteria).getResultList();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        assertTrue(employees.size() == 3);
    }

    @Test
    public void test4CriteriaWhere() {

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("salary"), 60000));

        //Use criteria to query with session to fetch all contacts
        List<Employee> employees = session.createQuery(criteria).getResultList();

        for (Employee employee : employees) {
            assertTrue(employee.getId() == idEmployee2);
        }
    }

    @Test
    public void test5CriteriaLimit() {

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);

        //Use criteria to query with session to fetch all contacts
        List<Employee> employees = session.createQuery(criteria)
                .setFirstResult(1) // represent LIMIT 1,* in MySQL
                .setMaxResults(2)// represent LIMIT *,2 in MySQL
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        assertTrue(employees.size() == 2);
    }

    @Test
    public void test6CriteriaOrder() {

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.orderBy(builder.desc(employeeRoot.get("salary")));

        //Use criteria to query with session to fetch all contacts
        List<Employee> employees = session.createQuery(criteria).getResultList();

        assertTrue(employees.get(0).getId() == idEmployee3);
    }


    @Test
    public void test6Delete() {
        Employee employee1 = null;
        Employee employee2 = null;
        Employee employee3 = null;

        session.getTransaction().begin();
        employee1 = (Employee) session.get(Employee.class, idEmployee1);
        session.delete(employee1);
        session.getTransaction().commit();

        session.getTransaction().begin();
        employee2 = (Employee) session.get(Employee.class, idEmployee2);
        session.delete(employee2);
        session.getTransaction().commit();

        session.getTransaction().begin();
        employee3 = (Employee) session.get(Employee.class, idEmployee3);
        session.delete(employee3);
        session.getTransaction().commit();

        employee1 = (Employee) session.get(Employee.class, idEmployee1);
        employee2 = (Employee) session.get(Employee.class, idEmployee2);
        employee3 = (Employee) session.get(Employee.class, idEmployee3);

        assertNull(employee1);
        assertNull(employee2);
        assertNull(employee3);
    }

}
