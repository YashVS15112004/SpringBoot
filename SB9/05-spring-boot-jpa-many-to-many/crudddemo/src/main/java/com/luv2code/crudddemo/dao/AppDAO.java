package com.luv2code.crudddemo.dao;


import java.util.List;

import com.luv2code.crudddemo.entity.Course;
import com.luv2code.crudddemo.entity.Instructor;
import com.luv2code.crudddemo.entity.InstructorDetail;
import com.luv2code.crudddemo.entity.Student;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    Course findCourseById(int theId);
    void update(Instructor tempInstructor);
    void update(Course tempCourse);
    void deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentByCourseId(int theId);
    Student findStudentAndCourseByStudentId(int theId);
    void update(Student tempStudent);
    void deleteStudentById(int theId);
}
