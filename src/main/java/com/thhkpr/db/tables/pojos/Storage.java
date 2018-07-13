/*
 * This file is generated by jOOQ.
 */
package com.thhkpr.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "storage", schema = "thhkpr", indexes = {
    @Index(name = "PRIMARY", unique = true, columnList = "storage_id ASC"),
    @Index(name = "storage_id", unique = true, columnList = "storage_id ASC"),
    @Index(name = "storage_name_index", columnList = "storage_name ASC"),
    @Index(name = "storage_place_index", columnList = "storage_place ASC"),
    @Index(name = "storage_storage_id_index", columnList = "storage_id ASC")
})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1773050094;

    private ULong     storageId;
    private String    storageName;
    private String    storageDescribe;
    private String    storagePlace;
    private Timestamp sysDateCreate;
    private Timestamp sysDateUpdate;
    private String    sysWhoUpdateName;

    public Storage() {}

    public Storage(Storage value) {
        this.storageId = value.storageId;
        this.storageName = value.storageName;
        this.storageDescribe = value.storageDescribe;
        this.storagePlace = value.storagePlace;
        this.sysDateCreate = value.sysDateCreate;
        this.sysDateUpdate = value.sysDateUpdate;
        this.sysWhoUpdateName = value.sysWhoUpdateName;
    }

    public Storage(
        ULong     storageId,
        String    storageName,
        String    storageDescribe,
        String    storagePlace,
        Timestamp sysDateCreate,
        Timestamp sysDateUpdate,
        String    sysWhoUpdateName
    ) {
        this.storageId = storageId;
        this.storageName = storageName;
        this.storageDescribe = storageDescribe;
        this.storagePlace = storagePlace;
        this.sysDateCreate = sysDateCreate;
        this.sysDateUpdate = sysDateUpdate;
        this.sysWhoUpdateName = sysWhoUpdateName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id", unique = true, nullable = false, precision = 20)
    public ULong getStorageId() {
        return this.storageId;
    }

    public void setStorageId(ULong storageId) {
        this.storageId = storageId;
    }

    @Column(name = "storage_name", nullable = false, length = 500)
    @NotNull
    @Size(max = 500)
    public String getStorageName() {
        return this.storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    @Column(name = "storage_describe", length = 4000)
    @Size(max = 4000)
    public String getStorageDescribe() {
        return this.storageDescribe;
    }

    public void setStorageDescribe(String storageDescribe) {
        this.storageDescribe = storageDescribe;
    }

    @Column(name = "storage_place", length = 500)
    @Size(max = 500)
    public String getStoragePlace() {
        return this.storagePlace;
    }

    public void setStoragePlace(String storagePlace) {
        this.storagePlace = storagePlace;
    }

    @Column(name = "sys_date_create", nullable = false)
    public Timestamp getSysDateCreate() {
        return this.sysDateCreate;
    }

    public void setSysDateCreate(Timestamp sysDateCreate) {
        this.sysDateCreate = sysDateCreate;
    }

    @Column(name = "sys_date_update", nullable = false)
    public Timestamp getSysDateUpdate() {
        return this.sysDateUpdate;
    }

    public void setSysDateUpdate(Timestamp sysDateUpdate) {
        this.sysDateUpdate = sysDateUpdate;
    }

    @Column(name = "sys_who_update_name", length = 500)
    @Size(max = 500)
    public String getSysWhoUpdateName() {
        return this.sysWhoUpdateName;
    }

    public void setSysWhoUpdateName(String sysWhoUpdateName) {
        this.sysWhoUpdateName = sysWhoUpdateName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Storage (");

        sb.append(storageId);
        sb.append(", ").append(storageName);
        sb.append(", ").append(storageDescribe);
        sb.append(", ").append(storagePlace);
        sb.append(", ").append(sysDateCreate);
        sb.append(", ").append(sysDateUpdate);
        sb.append(", ").append(sysWhoUpdateName);

        sb.append(")");
        return sb.toString();
    }
}
