package com.example.RESTJPA.dao;

import com.example.RESTJPA.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //create a EnitityManager
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee",Employee.class);


        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        //if id=0 it will insert/save otherwise update
        //@Trasactional will be taken care by service layer
        employee.setId(0);
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        //find the employee with id
       Employee employee= entityManager.find(Employee.class,id);
       // delete the employee
       entityManager.remove(employee);
    }
}
