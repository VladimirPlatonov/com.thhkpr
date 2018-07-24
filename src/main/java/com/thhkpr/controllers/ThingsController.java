package com.thhkpr.controllers;

import com.thhkpr.databases.tables.pojos.Things;
import com.thhkpr.models.ThingsModel;
import com.thhkpr.services.ThingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/things")
public class ThingsController
{
	@Autowired
	private ThingsService thingsService;

	/*
	* Example Joins on two tables
	Map<UserPojo, List<RolePojo>> result =
    dsl.select(USER.fields())
   .select(ROLE.fields())
   .from(USER)
   .join(USER_TO_ROLE).on(USER.USER_ID.eq(USER_TO_ROLE.USER_ID))
   .join(ROLE).on(ROLE.ROLE_ID.eq(USER_TO_ROLE.ROLE_ID))
   .where(USER.U_EMAIL.equal(email))
   .fetchGroups(

       // Map records first into the USER table and then into the key POJO type
       r -> r.into(USER).into(UserPojo.class),

       // Map records first into the ROLE table and then into the value POJO type
       r -> r.into(ROLE).into(RolePojo.class)
   );
	*/

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
	public ResponseEntity<List<Things>> allThings ()
	{
		log.info("===== all =====");

		List<Things> things = thingsService.getAllThings();
		
		return ResponseEntity.ok(things);
	}


    @RequestMapping("add")
    //@PostMapping(value = "")
    public ResponseEntity<Things> save(@RequestBody(required = true) ThingsModel thingsModel)
    {
        log.info("===== insert ===== {}", thingsModel);

        Things things = thingsService.addThings(thingsModel);

        log.info("{}", things);

        return ResponseEntity.ok(things);
    }

    @GetMapping(value = "{id}")
	public ResponseEntity<Things> id(@PathVariable(value = "id") Integer id)
	{
		log.info("===== id ===== {}", id);
		
		Things things = thingsService.getOneThingById(id);
		
		return ResponseEntity.ok(things);
	}

}
