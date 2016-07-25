package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.beans.Student;
import com.service.StudentService;
@Controller
@RequestMapping("/secure")
public class StudentController {
	@Autowired
    private StudentService service;
	@RequestMapping(value="/home")
	public String homePage() {
 		return "home";
 	}    
	@RequestMapping(value="/studentDetail")
	public String studentDetail(Model model) {
		model.addAttribute("student", new Student());
 		return "student";
 	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String success(@ModelAttribute("student") Student student, ModelMap model) {
		String stdName = service.getStudentName(student.getStdId());
		model.addAttribute("stdName", stdName);
		return "output";
	}
} 