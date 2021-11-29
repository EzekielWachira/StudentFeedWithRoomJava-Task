package com.example.studentfeedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentfeedback.databinding.FragmentUpdateRecordsBinding;
import com.example.studentfeedback.model.Feedback;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UpdateRecordsFragment extends Fragment {

    private static final String TAG = "UpdateRecordsFragment";

    private FragmentUpdateRecordsBinding binding;
    private FeedbackRecordViewModel recordViewModel;
    private Feedback feedback;

    private int learningOutcomeCom;
    private int opportunities;
    private int relevance;
    private int response;
    private int enhancedTeaching;

    public UpdateRecordsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateRecordsBinding.inflate(inflater, container, false);
        feedback = UpdateRecordsFragmentArgs.fromBundle(getArguments()).getFeedback();
        recordViewModel = new ViewModelProvider(this).get(FeedbackRecordViewModel.class);

        setUpUI();

        return binding.getRoot();
    }

    private void setUpUI() {
        binding.moduleName.setText(feedback.moduleName);
        binding.aspect.setText(feedback.aspectsOfModuleToBeImproved);

        switch (feedback.getOutcomeClearlyCommunicated()) {
            case 1: {
                binding.radioLearningOutcome1.setChecked(true);
                learningOutcomeCom = 1;
                break;
            }
            case 2: {
                binding.radioLearningOutcome2.setChecked(true);
                learningOutcomeCom = 2;
                break;
            }
            case 3: {
                binding.radioLearningOutcome3.setChecked(true);
                learningOutcomeCom = 3;
                break;
            }
            case 4: {
                binding.radioLearningOutcome4.setChecked(true);
                learningOutcomeCom = 4;
                break;
            }
            case 5: {
                binding.radioLearningOutcome5.setChecked(true);
                learningOutcomeCom = 5;
                break;
            }
        }

        switch (feedback.getOpportunitiesEnabledAchieveOutcome()) {
            case 1: {
                binding.radioOpportunities1.setChecked(true);
                opportunities = 1;
                break;
            }
            case 2: {
                binding.radioOpportunities2.setChecked(true);
                opportunities = 2;
                break;
            }
            case 3: {
                binding.radioOpportunities3.setChecked(true);
                opportunities = 3;
                break;
            }
            case 4: {
                binding.radioOpportunities4.setChecked(true);
                opportunities = 4;
                break;
            }
            case 5: {
                binding.radioOpportunities5.setChecked(true);
                opportunities = 5;
                break;
            }
        }

        switch (feedback.getRelevanceOfModuleToQualification()) {
            case 1: {
                binding.radioRelevance1.setChecked(true);
                relevance = 1;
                break;
            }
            case 2: {
                binding.radioRelevance2.setChecked(true);
                relevance = 2;
                break;
            }
            case 3: {
                binding.radioRelevance3.setChecked(true);
                relevance = 3;
                break;
            }
            case 4: {
                binding.radioRelevance4.setChecked(true);
                relevance = 4;
                break;
            }
            case 5: {
                binding.radioRelevance5.setChecked(true);
                relevance = 5;
                break;
            }
        }

        switch (feedback.getLecturerRespondedComprehensively()) {
            case 1: {
                binding.radioResponse1.setChecked(true);
                response = 1;
                break;
            }
            case 2: {
                binding.radioResponse2.setChecked(true);
                response = 2;
                break;
            }
            case 3: {
                binding.radioResponse3.setChecked(true);
                response = 3;
                break;
            }
            case 4: {
                binding.radioResponse4.setChecked(true);
                response = 4;
                break;
            }
            case 5: {
                binding.radioResponse5.setChecked(true);
                response = 5;
                break;
            }
        }

        switch (feedback.getTechnologyEnhancedTeaching()) {
            case 1: {
                binding.radioEnhancedReaching1.setChecked(true);
                enhancedTeaching = 1;
                break;
            }
            case 2: {
                binding.radioEnhancedReaching2.setChecked(true);
                enhancedTeaching = 2;
                break;
            }
            case 3: {
                binding.radioEnhancedReaching3.setChecked(true);
                enhancedTeaching = 3;
                break;
            }
            case 4: {
                binding.radioEnhancedReaching4.setChecked(true);
                enhancedTeaching = 4;
                break;
            }
            case 5: {
                binding.radioEnhancedReaching5.setChecked(true);
                enhancedTeaching = 5;
                break;
            }
        }


        binding.radioGroupLearningOutcomeCom.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_learning_outcome_1: {
                    learningOutcomeCom = 1;
                    break;
                }
                case R.id.radio_learning_outcome_2: {
                    learningOutcomeCom = 2;
                    break;
                }
                case R.id.radio_learning_outcome_3: {
                    learningOutcomeCom = 3;
                    break;
                }
                case R.id.radio_learning_outcome_4: {
                    learningOutcomeCom = 4;
                    break;
                }
                case R.id.radio_learning_outcome_5: {
                    learningOutcomeCom = 5;
                    break;
                }
            }
        });

        binding.radioGroupResponse.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_response_1: {
                    response = 1;
                    break;
                }
                case R.id.radio_response_2: {
                    response = 2;
                    break;
                }
                case R.id.radio_response_3: {
                    response = 3;
                    break;
                }
                case R.id.radio_response_4: {
                    response = 4;
                    break;
                }
                case R.id.radio_response_5: {
                    response = 5;
                    break;
                }
            }
        });

        binding.radioGroupRelevance.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_relevance_1: {
                    relevance = 1;
                    break;
                }
                case R.id.radio_relevance_2: {
                    relevance = 2;
                    break;
                }
                case R.id.radio_relevance_3: {
                    relevance = 3;
                    break;
                }
                case R.id.radio_relevance_4: {
                    relevance = 4;
                    break;
                }
                case R.id.radio_relevance_5: {
                    relevance = 5;
                    break;
                }
            }
        });

        binding.radioGroupOpportunities.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_opportunities_1: {
                    opportunities = 1;
                    break;
                }
                case R.id.radio_opportunities_2: {
                    opportunities = 2;
                    break;
                }
                case R.id.radio_opportunities_3: {
                    opportunities = 3;
                    break;
                }
                case R.id.radio_opportunities_4: {
                    opportunities = 4;
                    break;
                }
                case R.id.radio_opportunities_5: {
                    opportunities = 5;
                    break;
                }
            }
        });

        binding.radioGroupEnhancedTeaching.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_enhanced_reaching_1: {
                    enhancedTeaching = 1;
                    break;
                }
                case R.id.radio_enhanced_reaching_2: {
                    enhancedTeaching = 2;
                    break;
                }
                case R.id.radio_enhanced_reaching_3: {
                    enhancedTeaching = 3;
                    break;
                }
                case R.id.radio_enhanced_reaching_4: {
                    enhancedTeaching = 4;
                    break;
                }
                case R.id.radio_enhanced_reaching_5: {
                    enhancedTeaching = 5;
                    break;
                }
            }
        });

        binding.btnUpdate.setOnClickListener(view -> {
            Feedback editedFeedback = new Feedback(
                    feedback.getId(),
                    binding.moduleName.getText().toString(),
                    learningOutcomeCom,
                    opportunities,
                    relevance,
                    response,
                    enhancedTeaching,
                    binding.aspect.getText().toString()
            );
            recordViewModel.updateFeedback(editedFeedback);
            Toast.makeText(requireContext(), "Feedback updated", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}