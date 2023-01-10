package com.example.masai.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masai.demo.exception.StudentException;
import com.example.masai.demo.model.Student;
import com.example.masai.demo.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Student getStudentByRoll(Integer roll) {
		// TODO Auto-generated method stub
		return studentDao.findById(roll)
				.orElseThrow(() -> new StudentException("Student not found with roll no" + roll));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studList = new ArrayList<>();
		studList = studentDao.findAll();
		if (studList.size() > 0) {
			return studList;
		} else
			throw new StudentException("No record found");
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) {
		Student StudentData = studentDao.findById(roll)
				.orElseThrow(() -> new StudentException("Student not found with id" + roll));
		studentDao.delete(StudentData);
		return StudentData;
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> studData = studentDao.findById(student.getRoll());
		if (studData.isPresent()) {
			Student existingStudent = studData.get();
			return studentDao.save(existingStudent);
		} else
			throw new StudentException("Invalid student detail...");
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) {
		Optional<Student> opt = studentDao.findById(roll);
		if (opt.isPresent()) {
			Student existStudent = opt.get();
			existStudent.setMarks(existStudent.getMarks() + graceMarks);
			return studentDao.save(existStudent);
		} else
			throw new StudentException("Student not found with roll" + roll);
	}

}
