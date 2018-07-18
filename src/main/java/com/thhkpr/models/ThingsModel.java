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
public class ThingsModel
{
    private ULong thingId;
    private String    thingName;
    private String    thingDescribe;
    private byte[]    thnigVoice;
    private Timestamp sysDateCreate;
    private Timestamp sysDateUpdate;
    private String    sysWhoUpdateName;

}
