package com.nishant.springboot.hibernate.service;

import java.util.List;

import com.nishant.springboot.hibernate.pojo.Person;

public interface UserService{

	public List<Person> getAll();
	public Person getByID(Integer id);
	public Person add(Person person);
}
