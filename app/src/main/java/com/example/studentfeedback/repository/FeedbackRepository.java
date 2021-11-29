package com.example.studentfeedback.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.studentfeedback.dao.FeedbackDao;
import com.example.studentfeedback.model.Feedback;

import java.util.List;

import javax.inject.Inject;

public class FeedbackRepository {

    private final FeedbackDao feedbackDao;

    @Inject
    public FeedbackRepository(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    public void addFeedback(Feedback feedback) {
        new CreateFeedbackAsyncTask(feedbackDao).execute(feedback);
    }

    public LiveData<List<Feedback>> getAllFeedback() {
        return feedbackDao.getAll();
    }

    public void updateFeedback(Feedback feedback) {
        new UpdateFeedbackAsyncTask(feedbackDao).execute(feedback);
    }

    public void deleteFeedback(Feedback feedback) {
        new DeleteFeedbackAsyncTask(feedbackDao).execute(feedback);
    }

    static class CreateFeedbackAsyncTask extends AsyncTask<Feedback, Void, Void> {

        private final FeedbackDao feedbackDao;

        @Inject
        public CreateFeedbackAsyncTask(FeedbackDao feedbackDao) {
            this.feedbackDao = feedbackDao;
        }

        @Override
        protected Void doInBackground(Feedback... feedbacks) {
            feedbackDao.insertFeedback(feedbacks[0]);
            return null;
        }
    }

    static class UpdateFeedbackAsyncTask extends AsyncTask<Feedback, Void, Void> {

        private final FeedbackDao feedbackDao;

        @Inject
        public UpdateFeedbackAsyncTask(FeedbackDao feedbackDao) {
            this.feedbackDao = feedbackDao;
        }

        @Override
        protected Void doInBackground(Feedback... feedbacks) {
            feedbackDao.update(feedbacks[0]);
            return null;
        }
    }

    static class DeleteFeedbackAsyncTask extends AsyncTask<Feedback, Void, Void> {

        private final FeedbackDao feedbackDao;

        @Inject
        public DeleteFeedbackAsyncTask(FeedbackDao feedbackDao) {
            this.feedbackDao = feedbackDao;
        }

        @Override
        protected Void doInBackground(Feedback... feedbacks) {
            feedbackDao.delete(feedbacks[0]);
            return null;
        }
    }

}
