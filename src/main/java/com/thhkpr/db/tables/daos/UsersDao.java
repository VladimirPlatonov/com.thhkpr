/*
 * This file is generated by jOOQ.
 */
package com.thhkpr.db.tables.daos;


import com.thhkpr.db.tables.Users;
import com.thhkpr.db.tables.records.UsersRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
@Repository
public class UsersDao extends DAOImpl<UsersRecord, com.thhkpr.db.tables.pojos.Users, ULong> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, com.thhkpr.db.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    @Autowired
    public UsersDao(Configuration configuration) {
        super(Users.USERS, com.thhkpr.db.tables.pojos.Users.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(com.thhkpr.db.tables.pojos.Users object) {
        return object.getUserId();
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.thhkpr.db.tables.pojos.Users> fetchByUserId(ULong... values) {
        return fetch(Users.USERS.USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>user_id = value</code>
     */
    public com.thhkpr.db.tables.pojos.Users fetchOneByUserId(ULong value) {
        return fetchOne(Users.USERS.USER_ID, value);
    }

    /**
     * Fetch records that have <code>user_name IN (values)</code>
     */
    public List<com.thhkpr.db.tables.pojos.Users> fetchByUserName(String... values) {
        return fetch(Users.USERS.USER_NAME, values);
    }

    /**
     * Fetch records that have <code>user_login IN (values)</code>
     */
    public List<com.thhkpr.db.tables.pojos.Users> fetchByUserLogin(String... values) {
        return fetch(Users.USERS.USER_LOGIN, values);
    }

    /**
     * Fetch records that have <code>user_password IN (values)</code>
     */
    public List<com.thhkpr.db.tables.pojos.Users> fetchByUserPassword(String... values) {
        return fetch(Users.USERS.USER_PASSWORD, values);
    }

    /**
     * Fetch records that have <code>user_active IN (values)</code>
     */
    public List<com.thhkpr.db.tables.pojos.Users> fetchByUserActive(Integer... values) {
        return fetch(Users.USERS.USER_ACTIVE, values);
    }
}
