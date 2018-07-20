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

	private enum SettingParamName {CURRENT_SETTINGS_NAME,EMPTY};
	
	@Autowired
	private DSLContext dsl;


	public ULong insert(SettingsModel settingsModel)
    {
		SettingsRecord settingsRecord = dsl.insertInto(settings, settings.SETTINGS_NAME, settings.SETTINGS_LOGIN, settings.SETTINGS_PASSWORD, settings.SETTINGS_ACTIVE)
				.values(settingsModel.getSettingsName(), settingsModel.getSettingsLogin(), settingsModel.getSettingsPassword(), 1)
				.returning(settings.SETTINGS_ID)
				.fetchOne();
		return settingsRecord.getValue(settings.SETTINGS_ID);
	}
	
	public boolean update(SettingsModel settingsModel)
    {
		return dsl.update(settings)
				.set(settings.SETTINGS_NAME, settingsModel.getSettingsName())
                .set(settings.SETTINGS_LOGIN, settingsModel.getSettingsLogin())
                .set(settings.SETTINGS_PASSWORD, settingsModel.getSettingsPassword())
                //.set(settings.SETTINGS_ACTIVE, settingsModel.getSettingsActive())
				.where(settings.SETTINGS_ID.equal(settingsModel.getSettingsId())
                  .and(settings.SETTINGS_ACTIVE.eq(1)))
				.execute() == 1;
	}

	public boolean delete(ULong id)
	{
		return dsl.deleteFrom(settings)
				.where(settings.SETTINGS_ID.eq(id))
				.execute() == 1;
	}
	
	public List<com.thhkpr.databases.tables.pojos.Users> selectAll()
	{
		return dsl.selectFrom(settings)
                .where(settings.SETTINGS_ACTIVE.eq(1)) //+
                .fetchInto(com.thhkpr.databases.tables.pojos.Users.class);
	}
	
	public com.thhkpr.databases.tables.pojos.Users selectOneById(ULong id)
	{
		return dsl.selectFrom(settings)
				.where(settings.SETTINGS_ID.eq(id)
				.and(settings.SETTINGS_ACTIVE.eq(1)))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Users.class);
	}
}
