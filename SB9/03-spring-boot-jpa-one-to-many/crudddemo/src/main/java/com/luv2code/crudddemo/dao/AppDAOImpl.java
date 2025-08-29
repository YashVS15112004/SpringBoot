package com.luv2code.crudddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.crudddemo.entity.Instructor;
import com.luv2code.crudddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    // define entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) 
    {
        entityManager.persist(theInstructor);
    }


    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }


    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
       Instructor tempInstructor = entityManager.find(Instructor.class,theId);
       entityManager.remove(tempInstructor);
    }


    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
       InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
       return tempInstructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        //remove the associated object refrence
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

       entityManager.remove(tempInstructorDetail);
    }   
}
