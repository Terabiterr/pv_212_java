package com.example.dao;

import com.example.config.DatabaseMySql;
import com.example.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees VALUES(?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE id = ?";
    private static final String SELECT_EMPLOYEE_BY_NAME = "SELECT * FROM employees WHERE name = ?";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET name = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employees";
    public void insertEmployee(Employee employee) {
        try(Connection connection = DatabaseMySql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Optional<Employee> selectEmployeeById(int id) {
        Employee employee = null;
        try(Connection connection = DatabaseMySql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String position = resultSet.getString("position");
                employee = new Employee(id, name, email, position);
            }
            return Optional.ofNullable(employee);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = DatabaseMySql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String position = resultSet.getString("position");
                employees.add(new Employee(id, name, email, position));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }
}
