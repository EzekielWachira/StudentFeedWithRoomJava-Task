package com.example.studentfeedback.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studentfeedback.model.Feedback;

import java.util.List;

@Dao
public interface FeedbackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFeedback(Feedback...feedbacks);

    @Query("SELECT * FROM `student_feedback_table` ORDER BY `id` DESC")
    LiveData<List<Feedback>> getAll();

    @Update
    void update(Feedback feedback);

    @Delete
    void delete(Feedback feedback);

}
