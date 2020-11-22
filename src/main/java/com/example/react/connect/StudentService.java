package com.example.react.connect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student student) {
		studentRepository.save(conevertToStudent(student));
	}

	private StudentDto conevertToStudent(Student student) {
		StudentDto studentDto =new StudentDto();
		studentDto.setAddress(student.getAddress());
		studentDto.setLocation(student.getLocation());
		studentDto.setName(student.getName());
		studentDto.setSalary(student.getSalary());
		return studentDto;
	}

	public List<StudentDto> getAllStudents() {
		return (List<StudentDto>) studentRepository.findAll();
	}

}
