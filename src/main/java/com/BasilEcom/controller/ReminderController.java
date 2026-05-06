package com.BasilEcom.controller;

import com.BasilEcom.entity.Reminder;
import com.BasilEcom.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {
    @Autowired
    ReminderService reminderService;
    @PostMapping("/create")
    public ResponseEntity<Reminder> createReminder(@Valid @RequestBody Reminder reminder)
    {
        Reminder saved = reminderService.createReminder(reminder);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/getAllReminders")
    public ResponseEntity<List<Reminder>> getAllReminder()
    {

        return  ResponseEntity.ok(reminderService.getAllReminders());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id)
    {

        return  ResponseEntity.ok(reminderService.getReminderById(id));
    }
    @PutMapping("/updateReminder/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id,@Valid @RequestBody Reminder reminder)
    {

        return  ResponseEntity.ok(reminderService.updateReminder(id,reminder));
    }
    @DeleteMapping("/deleteReminder/{id}")
    public ResponseEntity<String> deleteReminder(@PathVariable Long id)
    {
         reminderService.deleteReminder(id);
        return  ResponseEntity.ok("Reminder deleted sucessfully");
    }
}
