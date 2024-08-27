package com.khuedev.cruddemo;

import com.khuedev.cruddemo.dao.StudentDao;
import com.khuedev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//System.out.println("Hello World!!!");
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudent(studentDao);
			//queryForStudentByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		int numrowDelete = studentDao.deleteAll();
		System.out.println("Number of student: " + numrowDelete);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		Student student = studentDao.findById(1);
		student.setLastName("Tran");
		studentDao.updateStudent(student);
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentByLastName(StudentDao studentDao) {
		List<Student> studentList = studentDao.findStudentByLastName("Ngo");
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDao studentDao) {
		List<Student> studentList = studentDao.findAll();
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {
		System.out.println("Creating new student object ..... ");
		Student student = new Student("Khue","Dao","khueDao@gmail.com");
		System.out.println("Saving the student .....");
		studentDao.save(student);
		int theId = student.getId();
		System.out.println("Saved student. Generated id: " + theId);
		System.out.println("Retrieve student with id: " + theId);
		Student theStudent = studentDao.findById(theId);
		System.out.println("Found the student: " + theStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		System.out.println("Creating new student object ..... ");
		Student student = new Student("Khue","Nguyen","khuenguyen@gmail.com");
		Student student2 = new Student("Khue","Bui","khuebui@gmail.com");
		Student student3 = new Student("Khue","Ngo","khuengo@gmail.com");
		System.out.println("Saving the student .....");
		studentDao.save(student);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Creating new student object ..... ");
		Student student = new Student("Khue","Truong","khuetruong@gmail.com");
		System.out.println("Saving the student .....");
		studentDao.save(student);
		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
