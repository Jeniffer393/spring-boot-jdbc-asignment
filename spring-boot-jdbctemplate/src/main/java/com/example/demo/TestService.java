package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TestService {
	@Autowired 
	UserDao userDao;
	
	int getCountOfUsers()  {
		return userDao.getCountOfUsers();
	}
	String getUserName(int id) {
		return userDao.getUserName(id);
	}
    
	String addStudent(Student student) {
		if(userDao.addStudent(student)==1) {
			return "student added sucessfullly";
		}
		else {
			return "we are not able to add student details";
		}
	
		
	}
	Student updateStudent(Student student,int id) {
		
	return userDao.updateStudent(student,id);
	
		
	 }
     
	 String deleteStudent(int id) {
		 if(userDao.deleteStudent(id)==1) {
			 return "deleted sucessfully";
			 
		 }
		 else {
			 return "not deleted sucessfully";
		 }
	 }
	 
	java.util.List<Student> getAllStudents(){
		return userDao.getAllStudents();
		 
	 }}
