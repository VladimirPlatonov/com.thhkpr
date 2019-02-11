package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Users;
import com.thhkpr.models.UsersModel;
import com.thhkpr.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService
{
	@Autowired
	private UsersRepository usersRepository;

    public Users addUsers(UsersModel usersModel)
	{
        Integer id = usersRepository.insert(usersModel);

		return getOneUserById(id);
	}

    public Users editStorage(UsersModel usersModel)
	{
		usersRepository.update(usersModel);
		
		return getOneUserById(usersModel.getUserId());
	}

	public Users remove(Integer id)
	{
		usersRepository.delete(id);
		
		return getOneUserById(id);
	}


	public List<Users> getAllUsers()
	{
		return usersRepository.selectAll();
	}

	public Users getOneUserById(Integer id)
	{
	    return usersRepository.selectOneById(id);
	}

}
