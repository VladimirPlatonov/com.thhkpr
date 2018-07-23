package com.thhkpr.controllers;

import com.thhkpr.databases.tables.pojos.Storage;
import com.thhkpr.models.StorageModel;
import com.thhkpr.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/storages")
public class StorageController
{
	@Autowired
	private MainService mainService;

    @GetMapping(value = "")
    public ResponseEntity<List<Storage>> allStorage ()
    {
        log.info("===== all =====");

        List<Storage> storage = mainService.getAllStorage();

        return ResponseEntity.ok(storage);
    }

    @RequestMapping("add")
    //@PostMapping(value = "")
    public ResponseEntity<Storage> save(@RequestBody(required = true) StorageModel storageModel)
    {
        log.info("===== insert ===== {}", storageModel);

        Storage storage = mainService.addStorage(storageModel);

        log.info("{}", storage);

        return ResponseEntity.ok(storage);
    }

    /*
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

    @RequestMapping("/things")
    @GetMapping(value = "{id}")
	public ResponseEntity<Things> id(@PathVariable(value = "id") Integer id)
	{
		log.info("===== id ===== {}", id);
		
		Things things = mainService.getOneThingById(id);
		
		return ResponseEntity.ok(things);
	}
	*/
}
