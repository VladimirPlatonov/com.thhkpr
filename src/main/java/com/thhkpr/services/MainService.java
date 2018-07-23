package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Things;
import com.thhkpr.databases.tables.pojos.Storage;
import com.thhkpr.databases.tables.pojos.Users;
import com.thhkpr.models.StorageModel;
import com.thhkpr.models.ThingsModel;
import com.thhkpr.models.UsersModel;
import com.thhkpr.repositories.SettingsRepository;
import com.thhkpr.repositories.StorageRepository;
import com.thhkpr.repositories.ThingsRepository;
import com.thhkpr.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService
{
	@Autowired
	private UsersRepository usersRepository;
    @Autowired
	private ThingsRepository thingsRepository;
    @Autowired
	private StorageRepository storagesRepository;
    @Autowired
	private SettingsRepository settingsRepository;


    public Users addUsers(UsersModel usersModel)
	{
        Integer id = usersRepository.insert(usersModel);

		return getOneUserById(id);
	}

	public Things addThings(ThingsModel thingsModel)
	{
        Integer id = thingsRepository.insert(thingsModel);

		return getOneThingById(id);
	}

    public Storage addStorage (StorageModel storageModel)
    {
        Integer id = storagesRepository.insert(storageModel);

	    return getOneStorageById(id);
    }


    public Users edit(UsersModel usersModel)
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

	public List<Things> getAllThings()
	{
		return thingsRepository.selectAll();
	}

	public List<Storage> getAllStorage()
	{
		return storagesRepository.selectAll();
	}


	public Users getOneUserById(Integer id)
	{
	    return usersRepository.selectOneById(id);
	}

	public Storage getOneStorageById(Integer id)
	{
	    return storagesRepository.selectOneById(id);
	}

	public Things getOneThingById(Integer id)
	{
		return thingsRepository.selectOneById(id);
	}
}
