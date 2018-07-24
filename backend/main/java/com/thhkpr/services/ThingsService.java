package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Things;
import com.thhkpr.models.ThingsModel;
import com.thhkpr.repositories.ThingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingsService
{
    @Autowired
	private ThingsRepository thingsRepository;

	public Things addThings(ThingsModel thingsModel)
	{
        Integer id = thingsRepository.insert(thingsModel);

		return getOneThingById(id);
	}

    public Things editThings(ThingsModel thingsModel)
	{
		thingsRepository.update(thingsModel);

		return getOneThingById(thingsModel.getThingId());
	}

	public List<Things> getAllThings()
	{
		return thingsRepository.selectAll();
	}

	public Things getOneThingById(Integer id)
	{
		return thingsRepository.selectOneById(id);
	}
}
