package com.thhkpr.controllers;

import com.thhkpr.databases.tables.pojos.Users;
import com.thhkpr.databases.tables.pojos.Things;
import com.thhkpr.models.UsersModel;
import com.thhkpr.models.ThingsModel;
import com.thhkpr.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class MainController
{
	@Autowired
	private MainService mainService;

    @RequestMapping("/add")
	//@PostMapping(value = "")
	public ResponseEntity<Things> save(@RequestBody(required = true) ThingsModel thingsModel)
	{
		log.info("===== save ===== {}", thingsModel);

		Things things = mainService.addThings(thingsModel);
		
		log.info("{}", things);
		
		return ResponseEntity.ok(things);
	}

    /*
	@PutMapping(value = "")
	public ResponseEntity<Users> edit(@RequestBody(required = true) UsersModel usersModel)
	{
		log.info("===== edit ===== {}", usersModel);
		
		Users users = usersService.edit(usersModel);
		
		log.info("{}", users);

		return ResponseEntity.ok(users);
	}*/
	
	/*
    @DeleteMapping(value = "{id}")
	public ResponseEntity<Users> remove(@PathVariable(value = "id") Integer id)
	{
		log.info("===== remove ===== {}", id);
		
		Users users = usersService.remove(id);
		
		log.info("{}", users);
		
		return ResponseEntity.ok(users);
	}*/
	
	@GetMapping(value = "")
	public ResponseEntity<List<Things>> all()
	{
		log.info("===== all =====");

		List<Things> things = mainService.getAllThings();
		
		return ResponseEntity.ok(things);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Things> id(@PathVariable(value = "id") Integer id)
	{
		log.info("===== id ===== {}", id);
		
		Things things = mainService.getOneThingById(id);
		
		return ResponseEntity.ok(things);
	}
}
