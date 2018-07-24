package com.thhkpr.controllers;

import com.thhkpr.databases.tables.pojos.Settings;
import com.thhkpr.models.SettingsModel;
import com.thhkpr.services.SettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/settings")
public class SettingsController
{
	@Autowired
	private SettingsService settingsService;

 	@GetMapping(value = "")
	public ResponseEntity<List<Settings>> all ()
	{
		log.info("===== all =====");

		List<Settings> settings = settingsService.getAll();

        log.info("{}", settings.toString() );
		
		return ResponseEntity.ok(settings);
	}

    @RequestMapping("add")
    public ResponseEntity<Settings> save (@RequestBody(required = true) SettingsModel settingsModel)
    {
        log.info("===== upsert ===== {}", settingsModel);

        Settings setting = settingsService.add(settingsModel);

        log.info("{}", setting.toString());

        return ResponseEntity.ok(setting);
    }

}
