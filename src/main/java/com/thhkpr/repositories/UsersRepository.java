package com.thhkpr.repositories;

import com.thhkpr.databases.tables.Users;
import com.thhkpr.databases.tables.records.UsersRecord;
import com.thhkpr.models.UsersModel;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UsersRepository
{
	Users users = Users.USERS;
	
	@Autowired
	private DSLContext dsl;


	public ULong insert(UsersModel usersModel)
    {
		UsersRecord usersRecord = dsl.insertInto(users, users.USER_NAME, users.USER_LOGIN, users.USER_PASSWORD, users.USER_ACTIVE)
				.values(usersModel.getUserName(), usersModel.getUserLogin(), usersModel.getUserPassword(), 1)
				.returning(users.USER_ID)
				.fetchOne();
		return usersRecord.getValue(users.USER_ID);
	}
	
	public boolean update(UsersModel usersModel)
    {
		return dsl.update(users)
				.set(users.USER_NAME, usersModel.getUserName())
                .set(users.USER_LOGIN, usersModel.getUserLogin())
                .set(users.USER_PASSWORD, usersModel.getUserPassword())
                //.set(users.USER_ACTIVE, usersModel.getUserActive())
				.where(users.USER_ID.equal(usersModel.getUserId())
                  .and(users.USER_ACTIVE.eq(1)))
				.execute() == 1;
	}

	public boolean delete(ULong id)
	{
		return dsl.deleteFrom(users)
				.where(users.USER_ID.eq(id))
				.execute() == 1;
	}
	
	public List<com.thhkpr.databases.tables.pojos.Users> selectAll()
	{
		return dsl.selectFrom(users)
                .where(users.USER_ACTIVE.eq(1)) //+
                .fetchInto(com.thhkpr.databases.tables.pojos.Users.class);
	}
	
	public com.thhkpr.databases.tables.pojos.Users selectOneById(ULong id)
	{
		return dsl.selectFrom(users)
				.where(users.USER_ID.eq(id)
				.and(users.USER_ACTIVE.eq(1)))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Users.class);
	}
}
