package com.example.Managemenet.Reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Managemenet.Entity.employeeEntity;


public interface reposetory  extends CrudRepository<employeeEntity, Integer>{

}
