package com.thhkpr;

import org.jooq.*;
import com.thhkpr.db.tables.records.UsersRecord;
import org.jooq.impl.DSL;
import org.jooq.types.ULong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.thhkpr.db.tables.Users.USERS;
import static javafx.css.StyleOrigin.AUTHOR;
import static javafx.css.StyleOrigin.USER;

public class Main {
    public static void main(String[] args) {

        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/thhkpr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";





        try (Connection conn = DriverManager.getConnection(url,userName,password)) {
            //conn.setAutoCommit(false);

            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            /*
            Result<Record> fetchActiveUsers = create
                    .select()
                    .from(USERS)
                    .where(USERS.USER_ACTIVE.equal(1))
                    .orderBy(USERS.USER_NAME)
                    .fetch();

            Result<Record> fetchAllUsers = create
                    .select()
                    .from(USERS)
                    .fetch();

            System.out.println("All USERS records:");
            for (Record r : fetchAllUsers) {
                System.out.println(r);
            }

            System.out.println("Active USERS records:");
            for (Record r : fetchActiveUsers) {
                System.out.println(r);
            }
*/

            System.out.println("like Ivanov's USERS records:");
            Result<Record> fetchIvanovsUsers = create
                    .select()
                    .from(USERS)
                    .where(USERS.USER_NAME.like("%ivan%"))
                    .orderBy(USERS.USER_NAME)
                    .fetch();
            System.out.println(fetchIvanovsUsers);

            //create.update(USERS).set(USERS.USER_ACTIVE,0).where(USERS.USER_NAME.like("%ivan%")).execute();
            //fetchIvanovsUsers. forEach(record -> {record. setValue(USERS.USER_ACTIVE,"-1")} );

            System.out.println("like Ivanov's updates USERS records:");
            for (Record r : fetchIvanovsUsers) {
                r.set(USERS.USER_ACTIVE,0);
                //r.intoResultSet().updateInt(USERS.USER_ACTIVE,0);//
                // r.set(USERS.USER_ACTIVE,0);
            }



            //conn.commit();

            System.out.println(fetchIvanovsUsers);

            //conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
