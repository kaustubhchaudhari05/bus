package com.hp.busmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.busmanagement.entity.AdminEntity;
import com.hp.busmanagement.repository.AdminRepository;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class Admin {
	
	@Autowired
	private AdminRepository repostiory;
	
	@PostMapping("/saveadmin")
	private void saveAdmin(@RequestBody AdminEntity adminEntity) {
		repostiory.save(adminEntity);
	}
	
	@GetMapping("/getadmin")
	private List<AdminEntity> getAdmin(){
		return (List<AdminEntity>)repostiory.findAll();
	}

}
