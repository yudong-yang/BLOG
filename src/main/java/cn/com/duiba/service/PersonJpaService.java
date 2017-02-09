package cn.com.duiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Person;
import cn.com.duiba.repository.PersonRepository;

@Service
public class PersonJpaService {

	@Autowired
	private PersonRepository userRepository;
	
	public Person getByid(final int id) {
		return userRepository.findOne(id);
	}
	
	public List<String> findUserName() {
		return userRepository.findname();
	}
	
	public void save(Person user) {
		userRepository.save(user);
	}

	public List<Person> findAllUsers() {
		return userRepository.findAll();
	}
	
	public Page<Person> GetUsersPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public void deleteByid(int id) {
		userRepository.delete(id);
	}
}
