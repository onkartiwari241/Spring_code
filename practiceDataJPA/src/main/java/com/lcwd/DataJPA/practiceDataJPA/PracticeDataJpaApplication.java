package com.lcwd.DataJPA.practiceDataJPA;

import com.lcwd.DataJPA.practiceDataJPA.models.StudentEntity;
import com.lcwd.DataJPA.practiceDataJPA.repo.StudentRepo;
import com.lcwd.DataJPA.practiceDataJPA.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.List;


@SpringBootApplication
public class PracticeDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeDataJpaApplication.class, args);

	}

	private Logger logger = LoggerFactory.getLogger(PracticeDataJpaApplication.class);

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {

//		insert Student data
		StudentEntity studentEntity = new StudentEntity();

		studentEntity.setId(104);
		studentEntity.setName("Arpit Singh");
		studentEntity.setAddress("Ayodhya");
		studentEntity.setCompany("Engagebay");

		StudentEntity studentEntity1 = studentService.saveStudent(studentEntity);
		System.out.println(studentEntity1);

//		Select Student by Id
//		StudentEntity student = studentService.getStudent(104);
//
//		System.out.println("Student_Id : "+student.getId());
//		System.out.println("Student_Name : "+student.getName());
//		System.out.println("Student_Address : "+student.getAddress());
//		System.out.println("Student_Company : "+student.getCompany());

//		Select All Students
//		List<StudentEntity> allStudent = studentService.getAllStudent();
//		Iterator<StudentEntity> itr =allStudent.iterator();
//
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}

		// Update student by id
//		StudentEntity studentEntity = new StudentEntity();
//
//		studentEntity.setName("Arpit Singh");
//		studentEntity.setAddress("Lucknow");
//		studentEntity.setCompany("Engagebay Hyderaabd");
//
//		StudentEntity updatedStudent = studentService.updateStudent(studentEntity, 104);
//
//		System.out.println("Student_Id : "+updatedStudent.getId());
//		System.out.println("Student_Name : "+updatedStudent.getName());
//		System.out.println("Student_Address : "+updatedStudent.getAddress());
//		System.out.println("Student_Company : "+updatedStudent.getCompany());

		// delete student by id

//		StudentEntity studentEntity = studentService.deleteStudent(104);
//		System.out.println(studentEntity);
	}
}
