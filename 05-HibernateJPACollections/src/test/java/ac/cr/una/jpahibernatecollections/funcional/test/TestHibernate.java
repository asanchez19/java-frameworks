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
import ac.cr.una.jpahibernatecollections.model.Employee;
import org.hibernate.Session;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
    public void test2Save() {

        Employee employee = new Employee();
        employee.setName("yogesh");

        List<String> emails = new ArrayList<String>();
        emails.add("emailaddress1@provider1.com");
        emails.add("emailaddress2@provider2.com");
        emails.add("emailaddress3@provider3.com");
        employee.setEmails(emails);

        // begin a transaction
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

        // guarda el ultimo id del objeto en la BD
        idEmployee = employee.getId();

        assertTrue(idEmployee > 0);

    }

    @Test
    public void test3Fetch() {
        Employee employee = (Employee) session.get(Employee.class, idEmployee);

        if (employee != null) {
            System.out.println(employee.toString());
        }

        assertNotNull(employee);
    }

}
