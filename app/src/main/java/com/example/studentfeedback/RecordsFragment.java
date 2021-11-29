package com.example.studentfeedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.studentfeedback.common.VerticalItemDecorator;
import com.example.studentfeedback.databinding.FragmentRecordsBinding;
import com.example.studentfeedback.model.Feedback;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RecordsFragment extends Fragment implements SectionsPageAdapter.FeedbackClickInterface {

    private FragmentRecordsBinding binding;
    NavController navController;
    NavHostFragment navHostFragment;
    private SectionsPageAdapter sectionsPageAdapter;
    private FeedbackRecordViewModel recordViewModel;

    public RecordsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecordsBinding.inflate(inflater, container, false);
        recordViewModel = new ViewModelProvider(this).get(FeedbackRecordViewModel.class);


        navHostFragment = (NavHostFragment) getActivity()
                .getSupportFragmentManager()
                .findFragmentById(R.id.mainNavHostContainer);

        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        sectionsPageAdapter = new SectionsPageAdapter(Feedback.itemCallback, this);

        setUpUI();

        return binding.getRoot();
    }

    private void setUpUI() {

        binding.fab.setOnClickListener(view ->

                navController.navigate(R.id.action_recordsFragment_to_captureRecordsFragment)
        );

        binding.feedbackRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.feedbackRecyclerView.addItemDecoration(new VerticalItemDecorator(5));
        binding.feedbackRecyclerView.setAdapter(sectionsPageAdapter);

        recordViewModel.getFeedbacks().observe(getViewLifecycleOwner(), feedbacks -> {
            if (feedbacks.isEmpty()) {
                binding.layoutNoData.setVisibility(View.VISIBLE);
                binding.feedbackRecyclerView.setVisibility(View.INVISIBLE);
            } else sectionsPageAdapter.submitList(feedbacks);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(Feedback feedback) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("feedback", feedback);
        navController.navigate(R.id.action_recordsFragment_to_updateRecordsFragment, bundle);
    }
}