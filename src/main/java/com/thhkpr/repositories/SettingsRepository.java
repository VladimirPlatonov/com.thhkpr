package com.thhkpr.repositories;

import com.thhkpr.databases.tables.Settings;
import com.thhkpr.databases.tables.records.SettingsRecord;
import com.thhkpr.models.SettingsModel;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class SettingsRepository
{
	Settings settings = Settings.SETTINGS;

    enum SettingParamName {CURRENT_SETTINGS_NAME,EMPTY};
	
	@Autowired
	private DSLContext dsl;


	public Integer insert(SettingsModel settingsModel)
    {
		SettingsRecord settingsRecord = dsl.insertInto(
		            settings,
                    settings.SETTINGS_NAME,
                    settings.SETTINGS_VALUE)
				.values(
				        settingsModel.getSettingsName(),
                        settingsModel.getSettingsValue())
				.returning(settings.SETTINGS_ID)
				.fetchOne();
		return settingsRecord.getValue(settings.SETTINGS_ID);
	}
	
	public boolean update(SettingsModel settingsModel)
    {
		return dsl.update(settings)
				.set(settings.SETTINGS_NAME, settingsModel.getSettingsName())
                .set(settings.SETTINGS_VALUE, settingsModel.getSettingsValue())
				.where(settings.SETTINGS_ID.equal(settingsModel.getSettingsId()))
				.execute() == 1;
	}

	public boolean delete(Integer id)
	{
		return dsl.deleteFrom(settings)
				.where(settings.SETTINGS_ID.eq(id))
				.execute() == 1;
	}
	
	public List<com.thhkpr.databases.tables.pojos.Settings> selectAll()
	{
		return dsl.selectFrom(settings)
                .fetchInto(com.thhkpr.databases.tables.pojos.Settings.class);
	}
	
	public com.thhkpr.databases.tables.pojos.Settings selectOneById(String par)
	{
		return dsl.selectFrom(settings)
				.where(settings.SETTINGS_NAME.likeIgnoreCase(par))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Settings.class);
	}

	public com.thhkpr.databases.tables.pojos.Settings selectOneById(Integer par)
	{
		return dsl.selectFrom(settings)
				.where(settings.SETTINGS_ID.eq(par))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Settings.class);
	}
}
