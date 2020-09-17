package com.isg.unipro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isg.unipro.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeModel, Integer>{

}
