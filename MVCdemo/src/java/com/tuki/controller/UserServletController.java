/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.controller;

import com.tuki.core.User;
import com.tuki.dao.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pro
 */
@WebServlet("/UserServletController")
public class UserServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static UserDAO userDao = new UserDAO();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            invalidateUserSession(request, response);

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user = userDao.findUser(email, password);
            if (user == null) {
                request.setAttribute("msg", "Sai tài khoản hoặc mật khẩu ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("MaterialsStoreControllerServlet");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void invalidateUserSession(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, SQLException {
        //hủy tất cả section
        HttpSession session = request.getSession();
        //session.setAttribute("user",null);
        session.invalidate();
        request.setAttribute("msg", "Đăng xuất thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
