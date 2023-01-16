package com.oguztasgin.service;

import java.util.List;

import com.oguztasgin.entity.ContactPerson;
import com.oguztasgin.entity.Student;
import com.oguztasgin.repository.StudentRepository;

public class StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentService() {
		studentRepository = new StudentRepository();
	}

	public List<Student> getAll() {
		List<Student> list = null;
		try {
			list = studentRepository.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void save(Student student) {
		try {
			studentRepository.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
	}

	public void update(String id, String name, String lastname, String email, String cinsiyet, ContactPerson contactPerson) {
		Student student = new Student(Integer.parseInt(id), name, lastname, email, cinsiyet, contactPerson);
		try {
			studentRepository.update(student);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error");
		}
		
	}

	public void delete(String id) {
		try {
			studentRepository.delete(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public List<Student> getByName(String name) {
		List<Student> list = null;
		try {
			list = studentRepository.getByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Student> getByLastName(String lastName){
		List<Student> list = null;
		try {
			list = studentRepository.getByLastName(lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Student> getByEmail(String email){
		List<Student> list = null;
		try {
			list = studentRepository.getByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Student getById(String id) {
		Student student = null;
		try {
			student = studentRepository.getById(Integer.valueOf(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
