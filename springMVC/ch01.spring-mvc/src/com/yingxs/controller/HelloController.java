package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView hello(){
		System.out.println("ִ����hello����");
		//�����ݱ��浽ModelAndView���൱�ڱ��浽request�����
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "yingxs");
		
		//��������·��
		mv.setViewName("/WEB-INF/jsp/success.jsp");
		return mv;
	}
}
