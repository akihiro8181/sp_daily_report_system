package com.example.demo.controllers.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Controller
public class EmployeeIndexController {
	
	@Autowired
	EmployeeRepository emp;
	
	@RequestMapping(value="/employee/index" , method=RequestMethod.GET)
	public ModelAndView index(@ModelAttribute Employee employee,ModelAndView mav) {
		mav.setViewName("views/employee/employeeindex");
		Iterable<Employee> list = emp.findAll();
        mav.addObject("data", list);
        return mav;
	}
}