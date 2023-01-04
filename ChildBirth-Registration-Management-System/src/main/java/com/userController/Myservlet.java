package com.userController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userDao.UserDao;
import com.userModel.User;


@WebServlet("/")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		switch(path)
		{
		case"/edit":selectUserById(request,response);
		break;
		case "/add": NewUser(request,response);
		break;
		case "/insert":insertUser(request,response);
		break;
		case "/delete":deleteUser(request,response);
		break;
		case "/update":updateUser(request,response);
		break;
		default:list(request,response);
		break;
		} 
	}
	

	


	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String fathername = request.getParameter("fathername");
		String mothername = request.getParameter("mothername");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		User u = new User(id, name, fathername, mothername,dob,gender,city);
		UserDao.updateUser(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void selectUserById(HttpServletRequest request, HttpServletResponse response) 
	{
		
		int id=Integer.parseInt(request.getParameter("id"));
		User u=UserDao.selectUserById(id);
		request.setAttribute("list", u);
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
	{
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
	{
		String name= request.getParameter("name");
		String fathername =request.getParameter("fathername");
		String mothername = request.getParameter("mothername");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		
		
		User u = new User(name,fathername,mothername,dob,gender,city);
		UserDao.insert(u);
		try {
			response.sendRedirect("list");   // redirect to default page
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	private void NewUser(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try 
		{
			rd.forward(request,response);
		} 
		catch (ServletException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
	{
		//Display
		//we all Back-end data in userlist.jsp so we will use ArrayList here
		ArrayList<User> al=UserDao.display();
		//Add data into the request object
		request.setAttribute("display", al);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try 
		{
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
