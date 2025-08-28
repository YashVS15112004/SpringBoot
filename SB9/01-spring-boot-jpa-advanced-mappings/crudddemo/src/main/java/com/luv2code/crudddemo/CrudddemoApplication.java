package com.luv2code.crudddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crudddemo.dao.AppDAO;
import com.luv2code.crudddemo.entity.Instructor;
import com.luv2code.crudddemo.entity.InstructorDetail;

@SpringBootApplication
public class CrudddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commondLineRunner(AppDAO appDAO)
	{
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructorById(appDAO);
		}; 
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		// Instructor tempInstructor = new
		// Instructor("Chad","Darby","darby@gmail.com");

		// // create the instructor detail
		// InstructorDetail tempInstructorDetail = new InstructorDetail(
		// 	"http://www.youtube.com",
		// 	"Coding"
		// );

		Instructor tempInstructor = new
		Instructor("Madhu","Patel","madhu@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
			"http://www.youtube.com",
			"Guitar"
		);

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		System.out.println("Saving instructor : "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor ID : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor : " + tempInstructor);
		System.out.println("The associate instructor detail only : " + tempInstructor.getInstructorDetail());
	}

	private void deleteInstructorById(AppDAO appDAO)
	{
		int theId = 1;
		System.out.println("Deleting Instructor with Id : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted!");
	}
}
