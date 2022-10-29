package com.example.Managemenet.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Managemenet.Entity.employeeEntity;
import com.example.Managemenet.Model.Employee;
import com.example.Managemenet.Reposetory.reposetory;

@Component
public class Dao {
	
	@Autowired
	public reposetory repo;
	
	public ArrayList<employeeEntity> getAllEmployees() {
		 ArrayList<employeeEntity> al= (ArrayList<employeeEntity> ) repo.findAll();
		return al;
	}
	
	public Optional<employeeEntity> getEmployeeById(int id) {
		Optional<employeeEntity> emp= repo.findById(id);
		    Employee e=new Employee();
		    
		return emp;
	}
	
	
	public employeeEntity createEmployee(Employee e) {
		 employeeEntity e1=new employeeEntity(e.getFirst_name(),e.getLast_name(),e.getEmail());
		employeeEntity ent=repo.save(e1);
		return e1;
	}
	
	public boolean updateEmployee(Employee e, int id) {
		Optional<employeeEntity> optional=repo.findById(id);
		if(optional != null) {
			employeeEntity emp=optional.get();
			emp.setId(e.getId());
			emp.setFirst_name(e.getFirst_name());
			emp.setLast_name(e.getLast_name());
			emp.setEmail(e.getEmail());	
			repo.save(emp);
		}else {
			return false;
		}
		
		return true;
	
	}
	public void deleteEmployee(Integer id) {
		Optional<employeeEntity> optional=repo.findById(id);
		employeeEntity emp=optional.get();
		repo.delete(emp);
		
		
	}

}
