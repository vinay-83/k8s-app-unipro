package com.isg.unipro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("am from unipro port");
		return "Unipro test port";
	}
	
	@PostMapping("/save")
	public String saveUserangular(@RequestBody UserModel user) {
		UserModel um = new UserModel();
		um.setName(user.getName());
		userRepo.save(um);
		return "User saved";
	}
	
	@PostMapping("/saveInMongo")
	public String saveInMongo(@RequestBody EmployeeModel emp) {
		EmployeeModel um = new EmployeeModel();
		um.setName(emp.getName());
		um.setEmail(emp.getEmail());
		um.setExperience(emp.getExperience());
		um.setDomain(emp.getDomain());
		empRepo.insert(um);
		return "User saved";
	}
	
	@GetMapping("/getAllFromMongo")
	public List<EmployeeModel> getAllFromMongo() {
		return empRepo.findAll();
	}
	@GetMapping("/addUser/{id}/{name}")
	public UserModel saveUser(@PathVariable Integer id, @PathVariable String name) {
		UserModel um = new UserModel();
		um.setName(name);
		um.setId(id);
		return userRepo.save(um);
	}
	
	@GetMapping("getAllFromMysql")
	public List<UserModel> getAllFromMysql(){
		return userRepo.findAll();
	}
	//mongo-java-mysql-myworld.apps.okd.kpit.com
	@GetMapping("/addEmp/{id}/{name}")
	public EmployeeModel saveaddEmp(@PathVariable Integer id, @PathVariable String name) {
		EmployeeModel um = new EmployeeModel();
		um.setName(name);
		um.setId(id);
		return empRepo.insert(um);
	}
}
