package com.thhkpr.services;

import com.thhkpr.databases.tables.pojos.Settings;
import com.thhkpr.models.SettingsModel;
import com.thhkpr.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsService
{
    @Autowired
	private SettingsRepository settingsRepository;

    public Settings add (SettingsModel settingsModel)
	{
        Integer id = settingsRepository.insert(settingsModel);

		return getOneById(id);
	}

    public Settings edit (SettingsModel settingsModel)
	{
        settingsRepository.update(settingsModel);

		return getOneById(settingsModel.getSettingsId());
	}

	public Settings remove (Integer id)
	{
		settingsRepository.delete(id);
		
		return getOneById(id);
	}

	public List<Settings> getAll ()
	{
		return settingsRepository.selectAll();
	}

	public Settings getOneById(Integer id)
	{
	    return settingsRepository.selectOneById(id);
	}

	public Settings getOneById(String paramName)
	{
	    return settingsRepository.selectOneById(paramName);
	}

}
