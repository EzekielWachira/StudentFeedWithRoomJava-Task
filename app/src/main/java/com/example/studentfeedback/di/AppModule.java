package com.example.studentfeedback.di;

import android.content.Context;

import androidx.room.Room;

import com.example.studentfeedback.dao.FeedbackDao;
import com.example.studentfeedback.database.StudentFeedbackDatabase;
import com.example.studentfeedback.repository.FeedbackRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    @Singleton
    public static StudentFeedbackDatabase roomDatabase(@ApplicationContext Context context) {
        StudentFeedbackDatabase database = Room.databaseBuilder(
                context,
                StudentFeedbackDatabase.class,
                "feedback.db"
        ).build();
        return database;
    }

    @Provides
    @Singleton
    public static FeedbackDao feedbackDao(StudentFeedbackDatabase database) {
        return database.feedbackDao();
    }

    @Provides
    @Singleton
    public static FeedbackRepository feedbackRepository(FeedbackDao feedbackDao) {
        return new FeedbackRepository(feedbackDao);
    }

}
