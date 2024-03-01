package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class SaveServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String emailId=req.getParameter("email");
		long phone_no=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String qualification=req.getParameter("qualification");
		String comments=req.getParameter("comments");
		
		Student student=new Student();
		student.setName(name);
		student.setEmailId(emailId);
		student.setPhone_no(phone_no);
		student.setAddress(address);
		student.setQualification(qualification);
		student.setComments(comments);
		
		StudentDao studentDao=new StudentDao();
		studentDao.saveStudent(student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("save.html");
		dispatcher.forward(req, res);
		}
}
