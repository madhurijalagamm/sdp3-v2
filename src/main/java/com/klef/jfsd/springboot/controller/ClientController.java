package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ComplaintService;
import com.klef.jfsd.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ComplaintService complaintservice;
	
	@Autowired
	private AdminService adminservice;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@PostMapping("checkuserlogin")
	public ModelAndView checkuserlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = userservice.checkuserlogin(email, password);
		
		if(u!=null) {
			mv.setViewName("home");
			
			HttpSession session = request.getSession();
			session.setAttribute("id", u.getId());
			session.setAttribute("name", u.getFname());
			
			long ccount = adminservice.complaintcount();
			mv.addObject("ccount", ccount);
			
		}
		else {
			mv.addObject("message", "Login Failed");
			mv.setViewName("login");
		}
		
		return mv;
		
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin a = adminservice.checkadminlogin(username, password);
		
		if(a!=null) {
			mv.setViewName("adminhome");
			
			long ccount = adminservice.complaintcount();
			mv.addObject("ccount", ccount);
			long ucount = adminservice.userscount();
			mv.addObject("ucount", ucount);
			
		}
		else {
			mv.setViewName("adminlogin");
			mv.addObject("message", "Login Failed");
		}
		
		return mv;
		
	}
	
	@PostMapping("userreg")
	public ModelAndView insertuser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {
			
			User u = new User();
			u.setFname( request.getParameter("fname") );
			u.setLname( request.getParameter("lname") );
			u.setGender( request.getParameter("gender") );
			u.setDob( request.getParameter("dob") );
			u.setEmail( request.getParameter("email") );
			u.setPassword( request.getParameter("password") );
			u.setUsertype( request.getParameter("usertype") );
			
			userservice.adduser(u);
			
			mv.setViewName("adminhome");
			
		} 
		catch (Exception e) {
			mv.setViewName("adduser");
		}
		
		return mv;
	}
	
	@PostMapping("addcomplaint")
	public ModelAndView addcomplaint(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		
		try {
			
			HttpSession session = request.getSession();
			int id = (int)session.getAttribute("id");
			
			Complaint c = new Complaint();
			c.setUserid(id);
			c.setDept(request.getParameter("dept"));
			c.setParent(request.getParameter("parent"));
			c.setSection(request.getParameter("section"));
			c.setCategory(request.getParameter("category"));
			c.setIssue(request.getParameter("issue"));
			c.setStatus(true);
			
			complaintservice.addcomplaint(c);
			
			mv.addObject("ccount", adminservice.complaintcount());
			mv.setViewName("home");
			
			
		} 
		catch (Exception e) {
			mv.setViewName("addcomplaint");
		}
		
		return mv;
	}
	
	@GetMapping("userlogout")
	public ModelAndView userlogout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "Logout Successful");
		return mv;
	}
	
	@GetMapping("home")
	public ModelAndView home(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
	    String name = (String)session.getAttribute("name");
	    
		long ccount = adminservice.complaintcount();
		
		mv.addObject("name", name);
		mv.addObject("ccount", ccount);
		
		return mv;
		
	}
	
	@GetMapping("adminhome")
	public ModelAndView adminhome() {
		
		ModelAndView mv = new ModelAndView();
		
		long ccount = adminservice.complaintcount();
		mv.addObject("ccount", ccount);
		long ucount = adminservice.userscount();
		mv.addObject("ucount", ucount);
		
		return mv;
		
	}
	
	@GetMapping("viewcomplaints")
	public ModelAndView viewcomplaints() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewcomplaints");
		
		List<Complaint> clist = adminservice.viewcomplaints();
		
		System.out.println(clist);
		mv.addObject("clist", clist);
		
		return mv;
		
	}
	
	@GetMapping("viewallusers")
	public ModelAndView viewallusers() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallusers");
		
		List<User> ulist = adminservice.viewallusers();
		mv.addObject("ulist", ulist);
		
		return mv;
		
	}
	
}
