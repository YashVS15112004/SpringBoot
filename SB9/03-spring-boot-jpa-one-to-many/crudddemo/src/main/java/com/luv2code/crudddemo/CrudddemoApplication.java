package com.luv2code.crudddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crudddemo.dao.AppDAO;
import com.luv2code.crudddemo.entity.Course;
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
			// createInstructor(appDAO);

			//findInstructor(appDAO);

			// deleteInstructorById(appDAO);

			//findInstructorDetailById(appDAO);

			//deleteInstructorDetailById(appDAO);

			createInstructorWithCourses(appDAO);
		}; 
	}


	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor1 = new
		Instructor("Chad","Darby","darby@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail1 = new InstructorDetail(
			"http://www.youtube.com",
			"Coding"
		);

		Instructor tempInstructor2 = new
		Instructor("Madhu","Patel","madhu@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail2 = new InstructorDetail(
			"http://www.youtube.com",
			"Guitar"
		);

		// associate the objects
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);

		//save the instructor
		System.out.println("Saving instructor1 : "+tempInstructor1);
		appDAO.save(tempInstructor1);
		System.out.println("Done");
		
		System.out.println("Saving instructor2 : "+tempInstructor2);
		appDAO.save(tempInstructor2);
		System.out.println("Done");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding instructor ID : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor : " + tempInstructor);
		System.out.println("The associate instructor detail only : " + tempInstructor.getInstructorDetail());
	}

	private void deleteInstructorById(AppDAO appDAO)
	{
		int theId = 10;
		System.out.println("Deleting Instructor with Id : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int theId = 10;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail : "+ tempInstructorDetail);
		System.out.println("The associated instructor : " + tempInstructorDetail.getInstructor());
		System.out.println("Done!!");
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting InstructorDetail with Id : " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor1 = new
		Instructor("Susan","Pandey","susan@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail1 = new InstructorDetail(
			"http://www.youtube.com",
			"Video Games"
		);

		// associate the objects
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor1.add(tempCourse1);
		tempInstructor1.add(tempCourse2);

		// save the instructor
		// Will also save the courses bcz of CascadeType.PERSIST
		System.out.println("Saving instructor : "+tempInstructor1);
		System.out.println("The courses : " + tempInstructor1.getCourses());
		appDAO.save(tempInstructor1);

		System.out.println("DONE!!!");
	}
}
