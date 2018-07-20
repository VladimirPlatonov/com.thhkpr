package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Users;
import com.thhkpr.models.UsersModel;
import com.thhkpr.repositories.UsersRepository;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService
{
	@Autowired
	private UsersRepository usersRepository;

	public Boolean putThing() {
	    return true;
    }

	public Users save(UsersModel usersModel)
	{
		ULong id = usersRepository.insert(usersModel);

		return getOneById(id);
	}
	
	public Users edit(UsersModel usersModel)
	{
		usersRepository.update(usersModel);
		
		return getOneById(usersModel.getUserId());
	}

	public Users remove(ULong id)
	{
		usersRepository.delete(id);
		
		return getOneById(id);
	}
	
	public List<Users> getAll()
	{
		return usersRepository.selectAll();
	}
	
	public Users getOneById(ULong id)
	{
		return usersRepository.selectOneById(id);
	}
}
