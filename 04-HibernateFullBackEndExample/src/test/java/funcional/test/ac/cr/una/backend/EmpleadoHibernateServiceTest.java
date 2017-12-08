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
package funcional.test.ac.cr.una.backend;

import ac.cr.una.backend.dao.EmpleadoDAO;
import ac.cr.una.backend.dao.EmpleadoDAOHibernateImpl;
import ac.cr.una.backend.model.Empleado;
import ac.cr.una.backend.model.EmpleadoEmail;
import ac.cr.una.backend.service.EmpleadoService;
import ac.cr.una.backend.service.EmpleadoServiceImpl;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mguzmana
 */
public class EmpleadoHibernateServiceTest {

    private EmpleadoDAO empleadoDAO;
    private EmpleadoService empleadoService;
    private Empleado empleado = null;

    public EmpleadoHibernateServiceTest() {
    }

    @Test
    public void testHibernateSaveEmpleado() {
        empleadoDAO = new EmpleadoDAOHibernateImpl();
        empleadoService = new EmpleadoServiceImpl(empleadoDAO);

        empleado = new Empleado();

        empleado.setNombre("Mike");
        empleado.setSalario(1000);

        empleado = empleadoService.saveEmpleado(empleado);
        assertNotNull(empleado.getIdEmpleado());
    }

    @Test
    public void testHibernateSaveEmpleadoEmail() {
        empleadoDAO = new EmpleadoDAOHibernateImpl();
        empleadoService = new EmpleadoServiceImpl(empleadoDAO);

        empleado = new Empleado();
        EmpleadoEmail empleadoEmail = new EmpleadoEmail();

        empleado.setNombre("Mike Email");
        empleado.setSalario(1000);

        empleadoEmail.setEmail("mike_email@mike.com");
        empleadoEmail.setEmpleado(empleado);
        empleadoEmail.setTipo("personal");

        empleadoEmail = empleadoService.saveEmpleadoEmail(empleadoEmail);
        assertNotNull(empleadoEmail.getIdEmail());
    }

    @After
    public void deleteAll() {
        empleadoDAO = new EmpleadoDAOHibernateImpl();
        empleadoService = new EmpleadoServiceImpl(empleadoDAO);
    }
}
