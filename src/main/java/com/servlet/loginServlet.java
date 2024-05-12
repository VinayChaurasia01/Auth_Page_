package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entities.User;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO(DBConnect.getConnection());
		User user = dao.getLogin(email, password);
		
		if(user!= null) {
			/*
			 * PrintWriter out = response.getWriter(); out.print("Login sucessfully");
			 */
			HttpSession session = request.getSession();
			session.setAttribute("user-ob", user);
			response.sendRedirect("home.jsp");
			
		}else {
			/*
			 * PrintWriter out = response.getWriter();
			 * out.print("Invalid email and password");
			 */
			
			HttpSession session = request.getSession();
			session.setAttribute("error", "invalid email and password");
			response.sendRedirect("login.jsp");
		}
	}
}
