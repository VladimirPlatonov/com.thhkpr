/*
 * This file is generated by jOOQ.
 */
package com.thhkpr.db;


import com.thhkpr.db.tables.Settings;
import com.thhkpr.db.tables.Storage;
import com.thhkpr.db.tables.Things;
import com.thhkpr.db.tables.Users;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>thhkpr</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SETTINGS_PRIMARY = Indexes0.SETTINGS_PRIMARY;
    public static final Index SETTINGS_SETTINGS_ID = Indexes0.SETTINGS_SETTINGS_ID;
    public static final Index SETTINGS_SETTINGS_SETTINGS_ID_INDEX = Indexes0.SETTINGS_SETTINGS_SETTINGS_ID_INDEX;
    public static final Index SETTINGS_SETTINGS_SETTINGS_NAME_INDEX = Indexes0.SETTINGS_SETTINGS_SETTINGS_NAME_INDEX;
    public static final Index STORAGE_PRIMARY = Indexes0.STORAGE_PRIMARY;
    public static final Index STORAGE_STORAGE_ID = Indexes0.STORAGE_STORAGE_ID;
    public static final Index STORAGE_STORAGE_NAME_INDEX = Indexes0.STORAGE_STORAGE_NAME_INDEX;
    public static final Index STORAGE_STORAGE_PLACE_INDEX = Indexes0.STORAGE_STORAGE_PLACE_INDEX;
    public static final Index STORAGE_STORAGE_STORAGE_ID_INDEX = Indexes0.STORAGE_STORAGE_STORAGE_ID_INDEX;
    public static final Index THINGS_PRIMARY = Indexes0.THINGS_PRIMARY;
    public static final Index THINGS_THINGS_THING_ID_INDEX = Indexes0.THINGS_THINGS_THING_ID_INDEX;
    public static final Index THINGS_THINGS_THING_NAME_INDEX = Indexes0.THINGS_THINGS_THING_NAME_INDEX;
    public static final Index THINGS_THING_ID = Indexes0.THINGS_THING_ID;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;
    public static final Index USERS_USERS_USER_ID_INDEX = Indexes0.USERS_USERS_USER_ID_INDEX;
    public static final Index USERS_USERS_USER_NAME_USER_LOGIN_INDEX = Indexes0.USERS_USERS_USER_NAME_USER_LOGIN_INDEX;
    public static final Index USERS_USER_ID = Indexes0.USERS_USER_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index SETTINGS_PRIMARY = Internal.createIndex("PRIMARY", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.SETTINGS_ID }, true);
        public static Index SETTINGS_SETTINGS_ID = Internal.createIndex("settings_id", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.SETTINGS_ID }, true);
        public static Index SETTINGS_SETTINGS_SETTINGS_ID_INDEX = Internal.createIndex("settings_settings_id_index", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.SETTINGS_ID }, false);
        public static Index SETTINGS_SETTINGS_SETTINGS_NAME_INDEX = Internal.createIndex("settings_settings_name_index", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.SETTINGS_NAME }, false);
        public static Index STORAGE_PRIMARY = Internal.createIndex("PRIMARY", Storage.STORAGE, new OrderField[] { Storage.STORAGE.STORAGE_ID }, true);
        public static Index STORAGE_STORAGE_ID = Internal.createIndex("storage_id", Storage.STORAGE, new OrderField[] { Storage.STORAGE.STORAGE_ID }, true);
        public static Index STORAGE_STORAGE_NAME_INDEX = Internal.createIndex("storage_name_index", Storage.STORAGE, new OrderField[] { Storage.STORAGE.STORAGE_NAME }, false);
        public static Index STORAGE_STORAGE_PLACE_INDEX = Internal.createIndex("storage_place_index", Storage.STORAGE, new OrderField[] { Storage.STORAGE.STORAGE_PLACE }, false);
        public static Index STORAGE_STORAGE_STORAGE_ID_INDEX = Internal.createIndex("storage_storage_id_index", Storage.STORAGE, new OrderField[] { Storage.STORAGE.STORAGE_ID }, false);
        public static Index THINGS_PRIMARY = Internal.createIndex("PRIMARY", Things.THINGS, new OrderField[] { Things.THINGS.THING_ID }, true);
        public static Index THINGS_THINGS_THING_ID_INDEX = Internal.createIndex("things_thing_id_index", Things.THINGS, new OrderField[] { Things.THINGS.THING_ID }, false);
        public static Index THINGS_THINGS_THING_NAME_INDEX = Internal.createIndex("things_thing_name_index", Things.THINGS, new OrderField[] { Things.THINGS.THING_NAME }, false);
        public static Index THINGS_THING_ID = Internal.createIndex("thing_id", Things.THINGS, new OrderField[] { Things.THINGS.THING_ID }, true);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.USER_ID }, true);
        public static Index USERS_USERS_USER_ID_INDEX = Internal.createIndex("users_user_id_index", Users.USERS, new OrderField[] { Users.USERS.USER_ID }, false);
        public static Index USERS_USERS_USER_NAME_USER_LOGIN_INDEX = Internal.createIndex("users_user_name_user_login_index", Users.USERS, new OrderField[] { Users.USERS.USER_NAME, Users.USERS.USER_LOGIN }, false);
        public static Index USERS_USER_ID = Internal.createIndex("user_id", Users.USERS, new OrderField[] { Users.USERS.USER_ID }, true);
    }
}
