package com.zefeng.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zefeng.ssh.dao.PersonDAO;
import com.zefeng.ssh.entity.Person;

@Service
public class PersonService {
	
	@Autowired private PersonDAO personDAO;
	
	public List<Person> getPersons(){
		return personDAO.getPersons();
	}
	
	public Person getPersonById(String id) {
		return personDAO.getPersonById(id);
	}
	
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}

	public void deletePersonById(String id) {
		personDAO.deletePersonById(id);
	}
}
