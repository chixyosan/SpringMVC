package com.zefeng.ssh.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zefeng.ssh.entity.Person;
import com.zefeng.ssh.service.PersonService;


//RBAC角色权限认证
@Controller
@RequestMapping(value = "/person")//RequestMapping用来处理请求地址映射，value指请求的实际地址
public class PersonController {
	
	@Autowired private PersonService personService;
	
	@RequestMapping("/manager_login")
	public String login() {
		return "manager_login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String userName,String password) {
		if(Objects.equals(userName,"admin") && Objects.equals(password, "admin")) {
			return "redirectmain";
		}
		return "redirectlogin";
	}
	
	@RequestMapping("/main")
	public String Main(Model model) {
		model.addAttribute("persons", this.personService.getPersons());
		return "main";
	}
	
	@RequestMapping("/addPrompt")
	public String addPrompt() {
		return "addPerson";
	}
	
	@RequestMapping("/updatePrompt")
	public String updatePrompt(Model model,String id) {
		model.addAttribute("person", this.personService.getPersonById(id));
		return "updatePerson";
	}
	
	@RequestMapping(value = "/getPersons") //RequestMapping用于类上，表示类中所有响应请求的方法都是以该地址作为父路径
	@ResponseBody
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@RequestMapping(value = "/getPersonById")
	@ResponseBody
	public Person getPersonById(String id) {
		return personService.getPersonById(id);
	}
	
	@RequestMapping(value = "/addPerson")
	public String addPerson(Person person) {
		personService.addPerson(person);
		return "redirectmain";
	}

	@RequestMapping(value = "/updatePerson")
	public String updatePerson(Person person) {
		personService.updatePerson(person);
		return "redirectmain";
	}

	@RequestMapping(value = "/deletePersonById")
	public String deletePersonById(String id) {
		personService.deletePersonById(id);
		return "redirectmain";
	}
}
