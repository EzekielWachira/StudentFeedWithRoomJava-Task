package com.example.studentfeedback.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "student_feedback_table")
public class Feedback implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "module_name")
    public String moduleName;

    @ColumnInfo(name = "learning_outcome_clearly_communicated")
    public int outcomeClearlyCommunicated;

    @ColumnInfo(name = "opportunities_enabled_achieve_outcome")
    public int opportunitiesEnabledAchieveOutcome;

    @ColumnInfo(name = "relevance_of_module_to_qualification")
    public int relevanceOfModuleToQualification;

    @ColumnInfo(name = "lecturer_responded_comprehensively")
    public int lecturerRespondedComprehensively;

    @ColumnInfo(name = "technology_enhance_teaching")
    public int technologyEnhancedTeaching;

    @ColumnInfo(name = "aspects_of_module_to_be_improved")
    public String aspectsOfModuleToBeImproved;

    public Feedback(int id, String moduleName,
                    int outcomeClearlyCommunicated,
                    int opportunitiesEnabledAchieveOutcome,
                    int relevanceOfModuleToQualification,
                    int lecturerRespondedComprehensively,
                    int technologyEnhancedTeaching,
                    String aspectsOfModuleToBeImproved) {
        this.id = id;
        this.moduleName = moduleName;
        this.outcomeClearlyCommunicated = outcomeClearlyCommunicated;
        this.opportunitiesEnabledAchieveOutcome = opportunitiesEnabledAchieveOutcome;
        this.relevanceOfModuleToQualification = relevanceOfModuleToQualification;
        this.lecturerRespondedComprehensively = lecturerRespondedComprehensively;
        this.technologyEnhancedTeaching = technologyEnhancedTeaching;
        this.aspectsOfModuleToBeImproved = aspectsOfModuleToBeImproved;
    }

    public int getId() {
        return id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getOutcomeClearlyCommunicated() {
        return outcomeClearlyCommunicated;
    }

    public int getOpportunitiesEnabledAchieveOutcome() {
        return opportunitiesEnabledAchieveOutcome;
    }

    public int getRelevanceOfModuleToQualification() {
        return relevanceOfModuleToQualification;
    }

    public int getLecturerRespondedComprehensively() {
        return lecturerRespondedComprehensively;
    }

    public int getTechnologyEnhancedTeaching() {
        return technologyEnhancedTeaching;
    }

    public String getAspectsOfModuleToBeImproved() {
        return aspectsOfModuleToBeImproved;
    }

    public static DiffUtil.ItemCallback<Feedback> itemCallback = new DiffUtil.ItemCallback<Feedback>() {
        @Override
        public boolean areItemsTheSame(@NonNull Feedback oldItem, @NonNull Feedback newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Feedback oldItem, @NonNull Feedback newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };
}
