package com.Controller;


import java.util.HashMap;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Answer;
import com.Entity.User;
import com.Service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// 0 1 2
@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController 
{
	@Autowired
	LoginService service;
		
	static HttpSession httpsession;
	
	//{"username":"x","password":"y"}
	
	@RequestMapping("validate")
	public ResponseEntity<Boolean> validate(@RequestBody User user,HttpServletRequest request)
	{
		
		httpsession=request.getSession();
		
		boolean answer=service.validate(user);
		
		if(answer)
		{
			
			httpsession.setAttribute("score",0);
			
			
			HashMap<Integer,Answer> map=new HashMap<>();
			
			httpsession.setAttribute("submittedDetails",map);
			
			
			httpsession.setAttribute("questionIndex",0);
			
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
		
	}
	
	
	
	@RequestMapping("add/{no1}/{no2}")
	int add(@PathVariable int no1,@PathVariable int no2)
	{
		return no1+no2;
	}
	
	

	
	
	
	
	
	
	
}

