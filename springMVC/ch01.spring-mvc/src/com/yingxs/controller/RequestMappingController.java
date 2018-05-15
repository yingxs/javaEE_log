package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("requestMapping")
public class RequestMappingController {
	/*
	 * value����
	 */
	@RequestMapping("/test1")
	public ModelAndView test1(){
		System.out.println("RequestMappingController��test1().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
	/*
	 * method����
	 */
	@RequestMapping(value="/test2" ,method=RequestMethod.POST)
	public ModelAndView test2(){
		System.out.println("RequestMappingController��test2().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
	/*
	 * params����
	 */
	@RequestMapping(value="/test3" ,method=RequestMethod.GET,params={"name"})
	public ModelAndView test3(){
		//��name�����޷�����
		System.out.println("RequestMappingController��test3().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
}
