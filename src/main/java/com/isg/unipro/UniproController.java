package com.isg.unipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isg.unipro.model.UserModel;

@RestController
public class UniproController {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/whoAmI")
	public String whoAmI() {
		System.out.println("Am from unipro version 1.0");
		return "Am from unipro version 1.0";
	}
	
	@GetMapping("/addUser/{id}/{name}")
	public UserModel saveUser(@PathVariable Integer id, @PathVariable String name) {
		UserModel um = new UserModel();
		um.setName(name);
		um.setUserId(id);
		return userRepo.save(um);
	}
}
