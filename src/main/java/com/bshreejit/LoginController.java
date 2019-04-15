package com.bshreejit;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bshreejit.service.LoginService;


@Controller
public class LoginController{
	
	@RequestMapping("/login")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{				
		//TO sent the value to display.jsp
		ModelAndView mv=new ModelAndView();
		
		//To receive the value from index.jsp
		String uname =(request.getParameter("username"));
		String pass =(request.getParameter("password"));
				
				
		//To call LoginService
//		LoginService as= new LoginService();
		
		
		if(new LoginService().check(uname, pass))
		{
			mv.setViewName("display.jsp");
		}
		else
		{
			mv.setViewName("index.jsp");
		}
		return mv;
		//Since ModelAndView object is being returned public MOdelAndView
	}
}
