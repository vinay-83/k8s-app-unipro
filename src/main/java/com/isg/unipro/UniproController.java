package com.isg.unipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isg.unipro.model.EmployeeModel;
import com.isg.unipro.model.UserModel;

@RestController
public class UniproController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/whoAmI")
	public String whoAmI() {
		System.out.println("Am from unipro version 1.0");
		return "Am from unipro version 1.0";
	}
	
	@PostMapping("/save")
	public String saveUserangular(@RequestBody UserModel user) {
		UserModel um = new UserModel();
		um.setName(user.getName());
		userRepo.save(um);
		return "User saved";
	}
	
	@PostMapping("/saveInMongo")
	public String saveInMongo(@RequestBody EmployeeModel user) {
		EmployeeModel um = new EmployeeModel();
		um.setName(user.getName());
		empRepo.insert(um);
		return "User saved";
	}
	
	@GetMapping("/addUser/{id}/{name}")
	public UserModel saveUser(@PathVariable Integer id, @PathVariable String name) {
		UserModel um = new UserModel();
		um.setName(name);
		um.setUserId(id);
		return userRepo.save(um);
	}
	
	@GetMapping("/addEmp/{id}/{name}")
	public EmployeeModel saveaddEmp(@PathVariable String id, @PathVariable String name) {
		EmployeeModel um = new EmployeeModel();
		um.setName(name);
		um.setId(id);
		return empRepo.insert(um);
	}
}
