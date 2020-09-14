package com.isg.unipro;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isg.unipro.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{

}
