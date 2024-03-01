package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
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
		Student dbStudent=studentDao.updateStudent(id, student);
		if(dbStudent!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Data updated successfully");
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Sorry id is not present");
		}
		
	}
	
	
}
