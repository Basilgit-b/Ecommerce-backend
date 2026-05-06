package com.BasilEcom.service;

import com.BasilEcom.entity.Reminder;
import com.BasilEcom.entity.Status;
import com.BasilEcom.repository.ReminderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReminderService {
    @Autowired
    ReminderRepo reminderRepo;
    public Reminder createReminder (Reminder reminder)
    {
        reminder.setStatus(Status.PENDING);
        if(reminder.getReminderTime().isBefore(LocalDateTime.now()))
        {
            throw new RuntimeException("Date cannot be in the past");
        }
        return reminderRepo.save(reminder);
    }

    public List<Reminder> getAllReminders() {

        return reminderRepo.findAll();
    }

    public Reminder getReminderById(Long id) {

        return reminderRepo.findById(id).orElseThrow(()->new RuntimeException("Reminder Not Found"));
    }

    public void deleteReminder(Long id) {
        Reminder reminder = getReminderById(id);
         reminderRepo.delete(reminder);
    }

    public Reminder updateReminder(Long id, Reminder updatedReminder) {
        Reminder existingReminder = getReminderById(id);

        existingReminder.setTitle(updatedReminder.getTitle());
        existingReminder.setEmail(updatedReminder.getEmail());
        existingReminder.setReminderTime(updatedReminder.getReminderTime());
        existingReminder.setMessage(updatedReminder.getMessage());

        return  reminderRepo.save(existingReminder);

    }
}
