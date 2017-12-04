package com.nisum.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.beans.Emp;

@Controller
public class EmpController {
	List<Emp> list=new ArrayList<Emp>();
	int count=1;
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform","command",new Emp());
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		//write code to save emp object
		list.add(new Emp(count++,emp.getName(),emp.getSalary(),emp.getDesignation()));
		System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
		
		//return new ModelAndView("empform","command",emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		//write the code to get all employees from DAO
		//writing manual code for easy understanding
		
		
		return new ModelAndView("viewemp","list",list);
	}
}
