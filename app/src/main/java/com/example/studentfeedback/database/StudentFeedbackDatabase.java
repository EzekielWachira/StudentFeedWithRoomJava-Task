package com.example.studentfeedback.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.studentfeedback.dao.FeedbackDao;
import com.example.studentfeedback.model.Feedback;

@Database(entities = {Feedback.class}, version = 1)
public abstract class StudentFeedbackDatabase extends RoomDatabase {
    public abstract FeedbackDao feedbackDao();
}
