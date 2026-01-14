package in.ui.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ui.main.entities.Students;
import in.ui.main.services.StudentServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentControllers {
	
	@Autowired
	private StudentServices stdService;
	
	@GetMapping("/regPage")
	public String openregPage(Model model) {
		model.addAttribute("std", new Students());
		return "Register";
	}
	
	@PostMapping("/regForm")
	public String submitregForm(@ModelAttribute("std") Students std , Model model) {
		
		boolean status=stdService.registerstudent(std);
		if(status) {
			model.addAttribute("successmsg", "Student registered successfully");
			return "Register";
		}else {
			model.addAttribute("errormsg", "Student not registered due to some error");
			return "Register";
		}
		
	}
	
	@GetMapping("/loginPage")
	public String openloginPage(Model model) {
		model.addAttribute("std", new Students());
		return "Login";
	}
	
	@PostMapping("/loginForm")
	public String submitloginform(@ModelAttribute("std") Students std,Model model) {
		Students loginstd=stdService.loginstudent(std.getEmail(), std.getPassword());
		if(loginstd != null) {
			model.addAttribute("modelname", loginstd.getName());
			return "profile";
			
		}else {
			model.addAttribute("errormsg", "Student not login due to some error");
			return "Login";
			
		}
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/loginPage";
	}

}
