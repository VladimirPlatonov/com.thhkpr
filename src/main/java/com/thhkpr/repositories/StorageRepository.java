package com.thhkpr.repositories;

import com.thhkpr.databases.tables.Storage;
import com.thhkpr.databases.tables.records.StorageRecord;
import com.thhkpr.models.StorageModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class StorageRepository
{
	Storage storage = Storage.STORAGE;
	
	@Autowired
	private DSLContext dsl;


	public Integer insert(StorageModel storageModel)
    {
		StorageRecord storageRecord = dsl.insertInto(
					storage,
					storage.STORAGE_NAME,
					storage.STORAGE_DESCRIBE,
					storage.STORAGE_PLACE)
				.values(
						storageModel.getStorageName(),
						storageModel.getStorageDescribe(),
						storageModel.getStoragePlace())
				.returning(storage.STORAGE_ID)
				.fetchOne();
		return storageRecord.getValue(storage.STORAGE_ID);
	}
	
	public boolean update(StorageModel storageModel)
    {
		return dsl.update(storage)
				.set(storage.STORAGE_NAME, storageModel.getStorageName())
                .set(storage.STORAGE_DESCRIBE, storageModel.getStorageDescribe())
                .set(storage.STORAGE_PLACE, storageModel.getStoragePlace())
				.where(storage.STORAGE_ID.equal(storageModel.getStorageId()))
				.execute() == 1;
	}

	public boolean delete(Integer id)
	{
		return dsl.deleteFrom(storage)
				.where(storage.STORAGE_ID.eq(id))
				.execute() == 1;
	}
	
	public List<com.thhkpr.databases.tables.pojos.Storage> selectAll()
	{
		return dsl.selectFrom(storage)
                .fetchInto(com.thhkpr.databases.tables.pojos.Storage.class);
	}
	
	public com.thhkpr.databases.tables.pojos.Storage selectOneById(Integer id)
	{
		return dsl.selectFrom(storage)
				.where(storage.STORAGE_ID.eq(id))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Storage.class);
	}

	public com.thhkpr.databases.tables.pojos.Storage selectOneByName(String paramName)
	{
		return dsl.selectFrom(storage)
				.where(storage.STORAGE_NAME.likeIgnoreCase(paramName))
				.fetchOneInto(com.thhkpr.databases.tables.pojos.Storage.class);
	}
}
