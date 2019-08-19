package com.security.demo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping
public class MailDirecter {

	@Autowired
	private JavaMailSender javamail;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/getdata/{id}")
	public Object sas()
	{
		ObjectNode objectNode = mapper.createObjectNode();

			objectNode.put("id", "3");
			objectNode.put("email", "abc@dwdwa");
			objectNode.put("name", "xyz");
		

		return objectNode;
	}
	
	@GetMapping("/login")
	public String bcc()
	{
		return "login.jsp";
	}
	
	@GetMapping
	public ModelAndView abc()
	{
		ModelAndView modelandview = new ModelAndView("register.jsp");
		return modelandview;
	}
	
	
	@PostMapping("/mail")
	public ModelAndView xyz(@RequestParam String id)
	{
		User u = userservice.findById(Integer.parseInt(id));
		
		
		System.out.println(u.getEmail());
		
		ModelAndView modelandview = new ModelAndView("out.jsp");
		modelandview.addObject("email", u.getEmail());
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(u.getEmail());
        mailMessage.setSubject("Complete Registration!");
        //mailMessage.setFrom("prasathth.bm.mail@gmail.com");
        mailMessage.setText("http://localhost:8888/"+u.getEmail());
        javamail.send(mailMessage);
        
        return modelandview;
	}
	
	@GetMapping("/{id}")
	public ModelAndView sdf(@PathVariable("id") String id)
	{
		ModelAndView j = new ModelAndView("acti.jsp");
		j.addObject("email",id);
		User a = userservice.findByEmail(id);
		
		a.setActivate(true);
		//System.out.println(a);
		Date q = new Date();
		a.setDate(q);
		
		User u = userservice.save(a);
		System.out.println(u);
		if(u != null)
			return j;
		else
			return null;
		
		//return j;
	}
}
