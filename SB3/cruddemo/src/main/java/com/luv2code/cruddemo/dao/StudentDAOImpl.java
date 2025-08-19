package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // definr field for entity manager
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
        // implement deleteAll method
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
        // implement delete method
    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
    Student student = entityManager.find(Student.class, id);

    //delete the student
    if (student != null) {
    entityManager.remove(student);
    }
    }
        // implement update method
    @Override
    @Transactional
    public void update(Student theStudent) {
            entityManager.merge(theStudent);
    }
        // implement findByLastName method
    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
            "FROM Student WHERE lastName =:lastName", Student.class);
        //set query parameter
        theQuery.setParameter("lastName",lastName);
        //return query results 
        return theQuery.getResultList();
    }
    
        // implement findAll method
    @Override
    public List<Student> findAll() {
            //create query
            TypedQuery<Student> theQuery =  entityManager.createQuery("FROM Student order by lastName",Student.class);
            //return query results
            return theQuery.getResultList();
    }
    
    //inject entity manager using constructor injection
    @Override
    public Student findById(Integer id) {
            return entityManager.find(Student.class, id);
    }

    //implement save method 
    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }
    
}
