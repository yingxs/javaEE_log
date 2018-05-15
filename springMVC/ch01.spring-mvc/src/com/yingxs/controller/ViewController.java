package com.yingxs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	/**
	 * 1.��������������void
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request,HttpServletResponse response ,HttpSession session) throws ServletException, IOException{
		System.out.println("ViewController��test1()...");
		
		//ת��
//		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		//�ض���
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	/**
	 * ��������������ModelAndView
	 */
	@RequestMapping("/test2")
	public ModelAndView test2(){
		ModelAndView mv = new ModelAndView();
		//�����������ͼ����������ô��viewName�����߼�������ܣ������������·��
		mv.setViewName("success");
		return mv;
	}
	
	/**
	 * ��������������ModelAndView�����߼���ͼ���ƴ��빹�캯��
	 */
	@RequestMapping("/test3")
	public ModelAndView test3(){
		//���߼���ͼ���Ʒ���ModelAndView���캯����
		ModelAndView mv = new ModelAndView("success");
		//�����������ͼ����������ô��viewName�����߼�������ܣ������������·��
		//mv.setViewName("success");
		mv.addObject("name", "SpringMVX");
		return mv;
	}
	
	/**
	 * ���������������ַ���(ת��)
	 */
	@RequestMapping("/test4")
	public String test4(Model model){
		System.out.println("ViewController��test4()����");
		model.addAttribute("name", "Spring model");
		
		//������ͼ�߼�����
		return "success";
	}
	
	/**
	 * ���������������ַ���(�ض���)
	 */
	@RequestMapping("/test5")
	public String test5(){
		System.out.println("ViewController��test5()����");
		
		return "redirect:/index.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
