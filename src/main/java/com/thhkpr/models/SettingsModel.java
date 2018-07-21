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
public class SettingsModel
{
    private Integer settingsId;
    private String  settingsName;
    private String  settingsValue;


}
