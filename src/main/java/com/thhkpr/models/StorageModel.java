package com.thhkpr.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jooq.types.ULong;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StorageModel
{
    private ULong     storageId;
    private String    storageName;
    private String    storageDescribe;
    private String    storagePlace;
    private Timestamp sysDateCreate;
    private Timestamp sysDateUpdate;
    private String    sysWhoUpdateName;

}
