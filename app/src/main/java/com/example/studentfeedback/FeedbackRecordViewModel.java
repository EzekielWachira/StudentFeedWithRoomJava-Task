package com.example.studentfeedback;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.studentfeedback.model.Feedback;
import com.example.studentfeedback.repository.FeedbackRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FeedbackRecordViewModel extends ViewModel {

    private final FeedbackRepository feedbackRepository;
    public LiveData<List<Feedback>> feedbackList;

    @Inject
    public FeedbackRecordViewModel(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
        feedbackList = feedbackRepository.getAllFeedback();
    }

    public LiveData<List<Feedback>> getFeedbacks() {
        return feedbackRepository.getAllFeedback();
    }

    public void addFeedback(Feedback feedback) {
        feedbackRepository.addFeedback(feedback);
    }

    public void updateFeedback(Feedback feedback){
        feedbackRepository.updateFeedback(feedback);
    }

    public void deleteFeedback(Feedback feedback) {
        feedbackRepository.deleteFeedback(feedback);
    }

}
