package com.BasilEcom.repository;

import com.BasilEcom.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ReminderRepo extends JpaRepository<Reminder,Long> {

    List<Reminder> findByReminderTimeBefore(LocalDateTime reminderTime);
}
