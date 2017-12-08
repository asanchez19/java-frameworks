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
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Empleado;
import ac.cr.una.backend.model.EmpleadoEmail;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mguzmana
 */
public class EmpleadoDAOJdbcImpl implements EmpleadoDAO {

    final String SQL_INSERT_EMPLEADO = "INSERT INTO empleado"
            + "(NOMBRE, SALARIO) VALUES"
            + "(?,?)";

    final String SQL_INSERT_EMPLEADO_EMAIL = "INSERT INTO email"
            + "(ID_EMPLEADO, EMAIL, TIPO) VALUES"
            + "(?,?,?)";

    private Connection dbConnection = null;
    private Statement statement = null;

    public EmpleadoDAOJdbcImpl() throws SQLException {
        dbConnection = JdbcUtil.getDBConnection();
        statement = (Statement) dbConnection.createStatement();
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {

        int lastInsertedId = 0;

        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(SQL_INSERT_EMPLEADO,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setFloat(2, empleado.getSalario());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getInt(1);

            }

            empleado.setIdEmpleado(lastInsertedId);

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return empleado;
    }

    @Override
    public EmpleadoEmail saveEmpleadoEmail(EmpleadoEmail empleadoEmail) {
        int lastInsertedId = 0;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbConnection.prepareStatement(SQL_INSERT_EMPLEADO,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, empleadoEmail.getEmpleado().getNombre());
            preparedStatement.setFloat(2, empleadoEmail.getEmpleado().getSalario());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getInt(1);

            }

            preparedStatement = dbConnection.prepareStatement(SQL_INSERT_EMPLEADO_EMAIL,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, lastInsertedId);
            preparedStatement.setString(2, empleadoEmail.getEmail());
            preparedStatement.setString(3, empleadoEmail.getTipo());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return empleadoEmail;
    }

}
