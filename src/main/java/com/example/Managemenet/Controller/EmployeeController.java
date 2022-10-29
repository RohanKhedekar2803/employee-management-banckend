package com.example.Managemenet.Controller;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Managemenet.Entity.employeeEntity;
import com.example.Managemenet.Model.Employee;
import com.example.Managemenet.Reposetory.reposetory;
import com.example.Managemenet.Services.Dao;
import ch.qos.logback.core.status.Status;

@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	public reposetory repo;
	
	@Autowired
	public Dao d;
	
	@GetMapping("/employee")
	public ResponseEntity<ArrayList<employeeEntity>> getEmployee(){
		ArrayList<employeeEntity>al= d.getAllEmployees();
		if(al.size()<0) {
			return (ResponseEntity<ArrayList<employeeEntity>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
		else {
			return ResponseEntity.of(Optional.of(al));
		}
	}
//	@GetMapping("/books")
//	public ResponseEntity<ArrayList<book>> getBooks() {
//		ArrayList<book> l=ds.getAllBook();
//		if(l.size()<=0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}else {
//			return ResponseEntity.of(Optional.of(l));
//		}
//				
//	}
	
	
	@GetMapping("/employee/{id}")
	public Optional<employeeEntity> getEmployeeById(@PathVariable("id") int id) {
		  Optional<employeeEntity> al=d.getEmployeeById(id);
		return al;
	}
	
	@PostMapping("/employee")
	public employeeEntity  createEmployee(@RequestBody Employee e){
		 employeeEntity emp=  d.createEmployee(e);
		  System.out.print(emp);
		return emp;
	}
	
	boolean t;
	@PutMapping("/employee/{id}")
	public boolean createEmployee(@RequestBody Employee e,@PathVariable("id") int id){
		d.updateEmployee(e,id);
		t=true;
		return t;
	}
	
	@DeleteMapping("/employee/{id}")
	public boolean deleteEmployee(@PathVariable("id")int id){
		d.deleteEmployee(id);
		return true;
	}
	
	

}
