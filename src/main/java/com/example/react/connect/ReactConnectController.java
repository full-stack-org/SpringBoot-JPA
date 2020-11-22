package com.example.react.connect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/student/v1")
public class ReactConnectController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAllStudents")
	@ResponseBody
	public List<Student> getAllStudents() {
		List<StudentDto> studentDtoList = studentService.getAllStudents();
		List<Student> studentsList = convertData(studentDtoList);
		return studentsList;
	}
	
	@PostMapping("/addStudent")
	@ResponseBody
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added successfully";
	}

	private List<Student> convertData(List<StudentDto> studentDtoList) {
		List<Student> studentsList = new ArrayList<>();
		for (StudentDto studentDto : studentDtoList) {
			Student student = new Student();
			student.setStudentId(studentDto.getStudentId());
			student.setAddress(studentDto.getAddress());
			student.setLocation(studentDto.getLocation());
			student.setName(studentDto.getName());
			student.setSalary(studentDto.getSalary());
			studentsList.add(student);
		}
		return studentsList;
	}

}
