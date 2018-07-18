package com.thhkpr.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jooq.types.ULong;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersModel
{
    private ULong   userId;
    private String  userName;
    private String  userLogin;
    private String  userPassword;
    private Integer userActive;

}
