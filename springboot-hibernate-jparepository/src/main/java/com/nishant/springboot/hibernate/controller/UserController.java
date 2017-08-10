package com.nishant.springboot.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.springboot.hibernate.pojo.Person;
import com.nishant.springboot.hibernate.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Person> getAll(){
		return userService.getAll();
	}
	@RequestMapping(value="/byid/{id}",method=RequestMethod.GET)
	public Person getByID(@PathVariable Integer id){
		return userService.getByID(id);
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Person add(@RequestBody Person person){
		return userService.add(person);
	}

}
