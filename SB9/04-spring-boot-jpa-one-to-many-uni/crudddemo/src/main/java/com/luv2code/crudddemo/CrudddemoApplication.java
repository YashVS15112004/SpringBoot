package com.luv2code.crudddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crudddemo.dao.AppDAO;
import com.luv2code.crudddemo.entity.Course;
import com.luv2code.crudddemo.entity.Instructor;
import com.luv2code.crudddemo.entity.InstructorDetail;
import com.luv2code.crudddemo.entity.Review;

@SpringBootApplication
public class CrudddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commondLineRunner(AppDAO appDAO)
	{
		return runner ->{
			//createCourseAndReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);
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
		int theId = 2;
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

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor Id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor : " + tempInstructor);
		System.out.println("The associated courses : "+ tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor Id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor : " + tempInstructor);
		// find courses
		System.out.println("Finding courses for instructor Id : " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("associated courses : " + tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO)
	{
		int theId = 2;
		System.out.println("Finding instructor Id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("temp Instructor : " + tempInstructor);
		System.out.println("the associated courses : " + tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void updateInstructor(AppDAO appDAO)
	{
		int theId = 2;
		System.out.println("Finding instructor id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Updating instructor id : " + theId);
		tempInstructor.setLastName("Sharma");
		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO)
	{
		int theId = 10;
		System.out.println("Finding course id : " + theId);
		Course tempCourse = appDAO.findCourseById(theId);
		
		System.out.println("Updating course id : " + theId);
		tempCourse.setTitle("Enjoy the simple things");
		appDAO.update(tempCourse);
		System.out.println("Done!!");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course Id : " +theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points.");

		// add some reviews
		tempCourse.addReview(new Review("Great Course...Loved it!!"));
		tempCourse.addReview(new Review("Cool Course.Good Job!"));
		tempCourse.addReview(new Review("Waste of Time.Bad Course.."));

		// save the course
		System.out.println("Saving the course!");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done!!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}
}
