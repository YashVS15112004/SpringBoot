package com.luv2code.crudddemo.dao;

import com.luv2code.crudddemo.entity.Instructor;
import com.luv2code.crudddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
