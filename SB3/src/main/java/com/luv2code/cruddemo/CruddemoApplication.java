package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			// deleteAll(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object..."); 
		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//dispaly the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student.Generated Id : " + theId);

		//retrieve student based on the id : primary key
		System.out.println("Retrieving the student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : "+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");


		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);


		// display id of the saved student
		System.out.println("Saved student.Geneated ID : "+tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple student objects...");
		Student student1 = new Student("John", "Smith", "john.smith@gmail.com");
		Student student2 = new Student("Mary", "Johnson", "mary.johnson@gmail.com");
		Student student3 = new Student("Michael", "Williams", "michael.williams@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Saved students. Generated IDs: " +
			student1.getId() + ", " +
			student2.getId() + ", " +
			student3.getId());
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get lists of students
		List<Student> thStudent = studentDAO.findAll();
		for(Student temStudent : thStudent)
		{
			System.out.println(temStudent);
		}
		//display list of students
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Example: Query students by last name "Doe"
		String lastName = "Duck";
		System.out.println("Finding students with last name: " + lastName); 
		// get a lsit of students
		List<Student> students = studentDAO.findByLastName(lastName);
		// display the list
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		//retrieve student based on id : primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");
		
		//update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student : "+myStudent);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		// specify the id of the student to delete
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);

		//Delete the student
		studentDAO.delete(studentId);
		System.out.println("Deleted student with id: " + studentId);
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}
}
