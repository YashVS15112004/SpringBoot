package com.luv2code.crudddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.crudddemo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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
}
