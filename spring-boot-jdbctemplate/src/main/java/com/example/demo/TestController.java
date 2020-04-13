package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class TestController {
	
	
	@Autowired 
	TestService service;
	@RequestMapping("/count")
	Integer countOfUsers() {
		return service.getCountOfUsers();
		
	}
	
	@RequestMapping("/users/{id}")
	String getUserName(@PathVariable Integer id) {
		return service.getUserName(id);
		
	}
	@org.springframework.web.bind.annotation.PostMapping("/users")
	  String addStudent(@org.springframework.web.bind.annotation.RequestBody Student student) {
		  return service.addStudent(student);
	  }
	
	@PutMapping("/users/update/{id}")
	Student updateStudent(@RequestBody Student user,@PathVariable int  id) {
		Student student=service.updateStudent(user, id);
		
		return student;
	}
	
	@DeleteMapping("delete/{id}")
	String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	@GetMapping("/getAllStudent")
	public java.util.List<Student> getAllStudent(){
		return service.getAllStudents();
		
	}
	  
	

}
