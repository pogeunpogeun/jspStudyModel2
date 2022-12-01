package _test.employee.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _common.Util;
import _test.employee.model.dao.EmployeeDAO;
import _test.employee.model.dto.EmployeeDTO;

@WebServlet("/employee_servlet/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProc(request, response);
	}
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		Util util = new Util();
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		
		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		
		request.setAttribute("path", path);
		
		String forwardPage = "/WEB-INF/_test/employee";
				
		if (imsiUriFileName.equals("list.do")) {
			EmployeeDAO dao = new EmployeeDAO();
			ArrayList<EmployeeDTO> list = dao.getSelectAll();
			
			request.setAttribute("list", list);
			forwardPage += "/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}
		if (imsiUriFileName.equals("chuga.do")) {
			EmployeeDAO dao = new EmployeeDAO();
			ArrayList<EmployeeDTO> list = dao.getSelectAll();
			
			request.setAttribute("list", list);
			
			forwardPage += "/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}
		if (imsiUriFileName.equals("view.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setSabun(sabun);
			
			EmployeeDAO dao = new EmployeeDAO();
			EmployeeDTO dto = dao.getSelectOne(arguDto);
			
			request.setAttribute("dto", dto);
			
			forwardPage += "/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}
		if (imsiUriFileName.equals("sujung.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setSabun(sabun);
			
			EmployeeDAO dao = new EmployeeDAO();
			EmployeeDTO dto = dao.getSelectOne(arguDto);
			
			request.setAttribute("dto", dto);
			
			forwardPage += "/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}
		if (imsiUriFileName.equals("sakje.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setSabun(sabun);
			
			EmployeeDAO dao = new EmployeeDAO();
			EmployeeDTO dto = dao.getSelectOne(arguDto);
			
			request.setAttribute("dto", dto);
			
			forwardPage += "/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		}
		if (imsiUriFileName.equals("chugaProc.do")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String hireDate_ = request.getParameter("hireDate");
			String email = request.getParameter("email");
			String salary_ = request.getParameter("salary");
			String buseoNo_ = request.getParameter("buseoNo");
			
			Date hireDate = Date.valueOf(hireDate_);
			int salary = util.getNumberCheck(salary_, 0);
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setName(name);
			arguDto.setPhone(phone);
			arguDto.setHireDate(hireDate);
			arguDto.setEmail(email);
			arguDto.setSalary(salary);
			arguDto.setBuseoNo(buseoNo);
			
			EmployeeDAO dao = new EmployeeDAO();
			int result = dao.setInsert(arguDto);
			
			if(result > 0) {
				response.sendRedirect(path + "/employee_servlet/list.do");
			} else {
				response.sendRedirect(path + "/employee_servlet/chuga.do");
			}
		}
		if (imsiUriFileName.equals("sujungProc.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			String phone = request.getParameter("phone");
			String hireDate_ = request.getParameter("hireDate");
			String email = request.getParameter("email");
			String salary_ = request.getParameter("salary");
			String buseoNo_ = request.getParameter("buseoNo");
			
			Date hireDate = Date.valueOf(hireDate_);
			int salary = util.getNumberCheck(salary_, 0);
			int buseoNo = util.getNumberCheck(buseoNo_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setSabun(sabun);
			arguDto.setPhone(phone);
			arguDto.setHireDate(hireDate);
			arguDto.setEmail(email);
			arguDto.setSalary(salary);
			arguDto.setBuseoNo(buseoNo);
			
			EmployeeDAO dao = new EmployeeDAO();
			int result = dao.setUpdate(arguDto);
			
			if(result > 0) {
				response.sendRedirect(path + "/employee_servlet/view.do?sabun=" + sabun);
			} else {
				response.sendRedirect(path + "/employee_servlet/sujung.do?sabun=" + sabun);
			}
		}
		if (imsiUriFileName.equals("sakjeProc.do")) {
			String sabun_ = request.getParameter("sabun");
			int sabun = util.getNumberCheck(sabun_, 0);
			
			EmployeeDTO arguDto = new EmployeeDTO();
			arguDto.setSabun(sabun);
			
			EmployeeDAO dao = new EmployeeDAO();
			int result = dao.setDelete(arguDto);
			
			if(result > 0) {
				response.sendRedirect(path + "/employee_servlet/list.do");
			} else {
				response.sendRedirect(path + "/employee_servlet/sakje.do?sabun=" + sabun);
			}
		}
	}

}
