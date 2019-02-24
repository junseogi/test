package com.javalec.testmvc2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value = "view")
	public String view() {
		
		return "view";		
	}
	
	@RequestMapping(value = "contents/contentsView")
	public String contents(Model model) {
		
		model.addAttribute("id", "12345");
		
		return "contents/contentsView";
	}
	
	@RequestMapping(value = "mv")
	public ModelAndView send() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", "12345");
		mv.setViewName("mv");
		
		return mv;
	}
	
	@RequestMapping(value = "board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping(value = "board/confirmId2")
	public String confirmId2(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping(value = "member")
	public String member(Member memberArg) {
		
		
		return "member";
	}
	
}
