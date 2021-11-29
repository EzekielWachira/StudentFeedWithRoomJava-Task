package com.example.studentfeedback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentfeedback.model.Feedback;

public class SectionsPageAdapter extends ListAdapter<Feedback, SectionsPageAdapter.FeedbackViewHolder> {

    FeedbackClickInterface feedbackClickInterface;

    protected SectionsPageAdapter(@NonNull DiffUtil.ItemCallback<Feedback> diffCallback,
                                  FeedbackClickInterface feedbackClickInterface) {
        super(diffCallback);
        this.feedbackClickInterface = feedbackClickInterface;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feedback_item, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        Feedback feedback = getItem(position);
        holder.bindData(feedback);
    }


    class FeedbackViewHolder extends RecyclerView.ViewHolder {

        private final TextView moduleName;
        private final TextView outcomeComm;
        private final TextView outcomeOpp;
        private final TextView modRelevance;
        private final TextView lecResponse;
        private final TextView techEn;

        public FeedbackViewHolder(@NonNull View itemView) {
            super(itemView);

            moduleName = itemView.findViewById(R.id.moduleName);
            outcomeComm = itemView.findViewById(R.id.outcome_comm);
            outcomeOpp = itemView.findViewById(R.id.outcome_opp);
            modRelevance = itemView.findViewById(R.id.module_relevance);
            lecResponse = itemView.findViewById(R.id.lecturer_response);
            techEn = itemView.findViewById(R.id.technology_enhancement);
            itemView.setOnClickListener(view -> {
                feedbackClickInterface.onClick(getItem(getAdapterPosition()));
            });
        }

        public void bindData(Feedback feedback) {
            moduleName.setText(feedback.moduleName);
            outcomeComm.setText(String.valueOf(feedback.outcomeClearlyCommunicated));
            outcomeOpp.setText(String.valueOf(feedback.opportunitiesEnabledAchieveOutcome));
            modRelevance.setText(String.valueOf(feedback.relevanceOfModuleToQualification));
            lecResponse.setText(String.valueOf(feedback.lecturerRespondedComprehensively));
            techEn.setText(String.valueOf(feedback.technologyEnhancedTeaching));
        }
    }

    interface FeedbackClickInterface {
        void onClick(Feedback feedback);
    }
}
