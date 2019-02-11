package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Storage;
import com.thhkpr.models.StorageModel;
import com.thhkpr.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService
{
	@Autowired
	private StorageRepository storageRepository;

    public Storage addStorage (StorageModel storageModel)
    {
        Integer id = storageRepository.insert(storageModel);

	    return getOneStorageById(id);
    }

    public Storage editStorage(StorageModel storageModel)
	{
		storageRepository.update(storageModel);

		return getOneStorageById(storageModel.getStorageId());
	}

	public List<Storage> getAllStorage()
	{
		return storageRepository.selectAll();
	}

	public Storage getOneStorageById(Integer id)
	{
	    return storageRepository.selectOneById(id);
	}

	public Storage getOneStorageByName(String id)
	{
		return storageRepository.selectOneByName(id);
	}
}
