package com.yingxs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.fasterxml.jackson.annotation.JsonView;
import com.yingxs.dto.User;
import com.yingxs.dto.UserQuueryCondition;
import com.yingxs.security.app.social.AppSignUpUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private ProviderSignInUtils providerSignInUtils;
	
	
	@Autowired
	private AppSignUpUtils  appSignUpUtils;

	@GetMapping("/springTest")
	public void test() {
	   Map<String,Object> bean = SpringUtils.getBean(UsersConnectionRepository.class);
	   System.out.println(bean.size());
	    for (String key :bean.keySet()) {
			System.out.println(key+" : "+bean.get(key));
		}
	}
	
	@PostMapping("/regist")
	public void regist(User user,HttpServletRequest request) {
		
		// 不管是注册用户哈是绑定用户，都会拿到一个用户的唯一标识
		String userId = user.getUsername();
//		providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
		appSignUpUtils.doPostSignUp(new ServletWebRequest(request),userId);
	}
	
	
	
	
	
	@GetMapping("/me")
	public Object getCurrentuser(@AuthenticationPrincipal  UserDetails user) {
		return user;
	}
	
	
	
	@PostMapping
	public User create(@Valid @RequestBody User user,BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> {
				FieldError fieldError = (FieldError)error;
				String message = fieldError.getField() + error.getDefaultMessage();
				System.out.println(message);
			});
		}
		
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	
	
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user,BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> {
//				FieldError fieldError = (FieldError)error;
//				String message = fieldError.getField() + error.getDefaultMessage();
//				System.out.println(message);
				System.out.println(error.getDefaultMessage());
			});
		}
		
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	
	
	@GetMapping 
	@JsonView(User.UserSimpleView.class)
	@ApiOperation("用户查询服务")
	public List<User> query(UserQuueryCondition condition,@PageableDefault(page = 2,size=17,sort = "usernmae,asc") Pageable pageable ){
		List<User> users = new ArrayList<User>();
		
		System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));
		System.out.println( pageable.getPageSize() );
		System.out.println( pageable.getPageNumber() );
		System.out.println( pageable.getSort() );
		
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		 
		return users;
		
	}
	
	
	@DeleteMapping("/{id:\\d+}")
	public void delete( @PathVariable("id") String id) {
		System.out.println(id);
	}
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@ApiParam("用户id")  @PathVariable("id") String id) {
		System.out.println(111111);
		
//		throw new RuntimeException("user not exist");
		
		System.out.println("进入getInfo服务");
		User user = new User();
		user.setUsername("tom");
		return user;
	}
	
	
	
	
	

}
