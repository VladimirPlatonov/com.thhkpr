package com.thhkpr.repositories;

import com.thhkpr.databases.tables.Things;
import com.thhkpr.databases.tables.records.ThingsRecord;
import com.thhkpr.models.ThingsModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class ThingsRepository
{
	Things things = Things.THINGS;

	@Autowired
	private DSLContext dsl;

	public Integer insert(ThingsModel thingsModel)
    {
        Timestamp currentDateTime = new Timestamp( (new Date()).getTime());

		ThingsRecord thingsRecord = dsl.insertInto(
				 	things,
					things.THING_NAME,
					things.THING_DESCRIBE,
					things.THING_VOICE,
					//things.THING_STORAGEID,
					things.SYS_DATE_CREATE,
					things.SYS_DATE_UPDATE,
					things.SYS_WHO_UPDATE_NAME)
				.values(
						thingsModel.getThingName(),
						thingsModel.getThingDescribe(),
                        null,
                        //null,
                        currentDateTime,
                        currentDateTime,
						"undefined user"
                        )
				.returning(things.THING_ID)
				.fetchOne();
		return thingsRecord.getValue(things.THING_ID);
	}

	public boolean update(ThingsModel thingsModel)
    {
        Timestamp currentDateTime = new Timestamp( (new Date()).getTime());

		return dsl.update(things)
				.set(things.THING_NAME, thingsModel.getThingName())
                .set(things.THING_DESCRIBE, thingsModel.getThingDescribe())
                .set(things.THING_VOICE, thingsModel.getThingVoice())
                .set(things.SYS_DATE_UPDATE, currentDateTime) //thingsModel.getSysDateUpdate())
                .set(things.SYS_WHO_UPDATE_NAME, thingsModel.getSysWhoUpdateName())
				.where(things.THING_ID.equal(thingsModel.getThingId()))
				.execute() == 1;
	}

	public boolean delete(Integer id)
	{
		return dsl.deleteFrom(things)
				.where(things.THING_ID.eq(id))
				.execute() == 1;
	}

	public List<com.thhkpr.databases.tables.pojos.Things> selectAll()
	{
		return dsl.selectFrom(things).orderBy(things.SYS_WHO_UPDATE_NAME.desc())
                .fetchInto(com.thhkpr.databases.tables.pojos.Things.class);
	}

	public com.thhkpr.databases.tables.pojos.Things selectOneById(Integer id)
	{
		return dsl.selectFrom(things)
				.where(things.THING_ID.eq(id))
                .orderBy(things.SYS_DATE_UPDATE.desc())
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Things.class);
	}
}
