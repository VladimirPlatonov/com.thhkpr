package com.thhkpr.controllers;

import com.thhkpr.databases.tables.pojos.Users;
import com.thhkpr.models.UsersModel;
import com.thhkpr.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class MainController
{
	@Autowired
	private UsersService usersService;

	@PostMapping(value = "")
	public ResponseEntity<Users> save(@RequestBody(required = true) UsersModel usersModel)
	{
		log.info("===== save ===== {}", usersModel);

		Users users = usersService.save(usersModel);
		
		log.info("{}", users);
		
		return ResponseEntity.ok(users);
	}


	@PutMapping(value = "")
	public ResponseEntity<Users> edit(@RequestBody(required = true) UsersModel usersModel)
	{
		log.info("===== edit ===== {}", usersModel);
		
		Users users = usersService.edit(usersModel);
		
		log.info("{}", users);

		
		return ResponseEntity.ok(users);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Users> remove(@PathVariable(value = "id") Integer id)
	{
		log.info("===== remove ===== {}", id);
		
		Users users = usersService.remove(id);
		
		log.info("{}", users);
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "")
	public ResponseEntity<List<Users>> all()
	{
		log.info("===== all =====");

		List<Users> users = usersService.getAll();
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Users> id(@PathVariable(value = "id") Integer id)
	{
		log.info("===== id ===== {}", id);
		
		Users users = usersService.getOneById(id);
		
		return ResponseEntity.ok(users);
	}
}
