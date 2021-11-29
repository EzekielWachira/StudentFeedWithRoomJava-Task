package com.example.studentfeedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentfeedback.databinding.FragmentCaptureRecordsBinding;
import com.example.studentfeedback.model.Feedback;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CaptureRecordsFragment extends Fragment {

    private FragmentCaptureRecordsBinding binding;

    private FeedbackRecordViewModel recordViewModel;
    private int learningOutcomeCom;
    private int opportunities;
    private int relevance;
    private int response;
    private int enhancedTeaching;

    public CaptureRecordsFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCaptureRecordsBinding.inflate(inflater, container, false);
        recordViewModel = new ViewModelProvider(this).get(FeedbackRecordViewModel.class);

        setUpUI();

        return binding.getRoot();
    }

    private void setUpUI() {

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


        binding.btnSubmit.setOnClickListener(view -> {
            if (binding.moduleName.getText().toString().isEmpty()) {
                showToast("Please fill the module name");
            } else if (binding.radioGroupLearningOutcomeCom.getCheckedRadioButtonId() == -1) {
                showToast("Please fill out all the fields");
            } else if (binding.radioGroupOpportunities.getCheckedRadioButtonId() == -1) {
                showToast("Please fill out all the fields");
            } else if (binding.radioGroupRelevance.getCheckedRadioButtonId() == -1) {
                showToast("Please fill out all the fields");
            } else if (binding.radioGroupResponse.getCheckedRadioButtonId() == -1) {
                showToast("Please fill out all the fields");
            } else if (binding.radioGroupEnhancedTeaching.getCheckedRadioButtonId() == -1) {
                showToast("Please fill out all the fields");
            } else if (binding.aspect.getText().toString().isEmpty()) {
                showToast("Please fill out all the fields");
            } else {

                Feedback feedback = new Feedback(0,
                        binding.moduleName.getText().toString(),
                        learningOutcomeCom,
                        opportunities,
                        relevance,
                        response,
                        enhancedTeaching,
                        binding.aspect.getText().toString()
                );

                recordViewModel.addFeedback(feedback);

                showToast("Feedback submitted!");
            }
        });
    }

    private int getSelectedRadio(RadioGroup radioGroup) {
        int selectedValue = 0;
//        if (radioGroup.getCheckedRadioButtonId() == 1) selectedValue = 1;
//        else if (radioGroup.getCheckedRadioButtonId() == 2) selectedValue = 2;
//        else if (radioGroup.getCheckedRadioButtonId() == 3) selectedValue = 3;
//        else if (radioGroup.getCheckedRadioButtonId() == 4) selectedValue = 4;
//        else if (radioGroup.getCheckedRadioButtonId() == 5) selectedValue = 5;


        switch (radioGroup.getCheckedRadioButtonId()) {
            case 1: {
                selectedValue = 1;
                break;
            }
            case 2: {
                selectedValue = 2;
                break;
            }
            case 3: {
                selectedValue = 3;
                break;
            }
            case 4: {
                selectedValue = 4;
                break;
            }
            case 5: {
                selectedValue = 5;
                break;
            }
        }
        return selectedValue;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}