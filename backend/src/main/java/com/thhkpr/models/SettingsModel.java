package com.thhkpr.models;

import lombok.*;
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
