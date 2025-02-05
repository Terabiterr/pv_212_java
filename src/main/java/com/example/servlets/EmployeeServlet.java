package com.example.servlets;

import com.example.dao.EmployeeDAO;
import com.example.models.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "": listEmployee(req, resp); break;
            case "/employee": listEmployee(req, resp); break;
        }
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.selectAllEmployees();
        req.setAttribute("listEmployees", employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
