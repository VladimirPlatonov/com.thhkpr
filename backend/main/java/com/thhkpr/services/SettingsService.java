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
        return
         (getOneById(settingsModel.getSettingsName()) == null)
                ? getOneById(settingsRepository.insert(settingsModel))
                : edit(settingsModel);
 	}

    public Settings edit (SettingsModel settingsModel)
	{
        return getOneById( settingsRepository.update(settingsModel) );

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
