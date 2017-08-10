package com.nishant.springboot.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nishant.springboot.hibernate.entity.User;
import com.nishant.springboot.hibernate.pojo.Person;
import com.nishant.springboot.hibernate.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Person> getAll() {
		List<User> lst=userRepository.findAll();
		List<Person> pl=new ArrayList<>();
		for(User u:lst) {
			Person p=new Person();
			p.setId(u.getUserid());
			p.setName(u.getUsername());
			p.setComapnyname(u.getUsercompanyname());
			pl.add(p);
		}
		return pl;
	}

	@Override
	public Person getByID(Integer id) {
		User u=userRepository.findOne(id);
		Person p=new Person();
		p.setId(u.getUserid());
		p.setName(u.getUsername());
		p.setComapnyname(u.getUsercompanyname());
		return p;
	}

	@Override
	public Person add(Person person) {
		User u=new User();
		//u.setUserid(person.getId());
		u.setUsername(person.getName());
		u.setUsercompanyname(person.getComapnyname());
		userRepository.save(u);
		return person;
	}

}
