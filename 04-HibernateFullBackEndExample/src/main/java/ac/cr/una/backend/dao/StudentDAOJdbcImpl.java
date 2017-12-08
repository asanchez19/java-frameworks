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
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mguzmana
 */
public class StudentDAOJdbcImpl implements StudentDAO {

    private Connection dbConnection = null;
    private Statement statement = null;

    public StudentDAOJdbcImpl() throws SQLException {
        dbConnection = JdbcUtil.getDBConnection();
        statement = (Statement) dbConnection.createStatement();
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        String selectTableSQL = "SELECT ID, NAME, COURSE, RATING from STUDENT "
                + "WHERE ID=" + id;

        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            if (rs != null) {
                student = new Student();
                while (rs.next()) {

                    student.setId(rs.getInt("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setCourse(rs.getString("COURSE"));
                    student.setRating(rs.getString("RATING"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return student;

    }

    @Override
    public Student save(Student student) {
        String insertTableSQL = "INSERT INTO STUDENT"
                + "(NAME, COURSE, RATING) " + "VALUES"
                + "('" + student.getName() + "','"
                + student.getCourse() + "','" + student.getRating() + "')";

        try {
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return student;

    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = null;
        String selectTableSQL = "SELECT ID, NAME, COURSE, RATING from STUDENT";

        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            if (rs != null) {
                studentList = new ArrayList<>();
                while (rs.next()) {
                    Student student = new Student();

                    student.setId(rs.getInt("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setCourse(rs.getString("COURSE"));
                    student.setRating(rs.getString("RATING"));

                    studentList.add(student);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return studentList;

    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student update(Student student) {
        String updateTableSQL = "UPDATE STUDENT"
                + "(NAME, COURSE, RATING) " + "VALUES"
                + "('" + student.getName() + "','"
                + student.getCourse() + "','" + student.getRating() + "') WHERE (id ='" + student.getId() + "'";

        try {
            // execute insert SQL stetement
            statement.executeUpdate(updateTableSQL);

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return student;
    }

}
