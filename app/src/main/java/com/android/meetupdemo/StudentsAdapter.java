package com.android.meetupdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mokriya on 26/03/17.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    private ArrayList<StudentsModel> data;

    public StudentsAdapter(ArrayList<StudentsModel> studentsModel) {
        this.data = studentsModel;
    }


    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        StudentsModel studentsModel = data.get(position);
        holder.studentName.setText(studentsModel.getStud_name());
        holder.marksEnglish.setText(studentsModel.getStud_sub3());
        holder.marksHindi.setText(studentsModel.getStud_sub2());
        holder.marksRegional.setText(studentsModel.getStud_sub1());
        holder.marksMaths.setText(studentsModel.getStud_sub4());
        holder.marksScience.setText(studentsModel.getStud_sub5());
        holder.marksAvg.setText(studentsModel.getStud_avg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView studentName, marksEnglish, marksHindi, marksRegional, marksMaths, marksScience, marksAvg;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.tvStudentName);
            marksEnglish = (TextView) itemView.findViewById(R.id.tvSubEng);
            marksHindi = (TextView) itemView.findViewById(R.id.tvSubHindi);
            marksRegional = (TextView) itemView.findViewById(R.id.tvSubRegional);
            marksMaths = (TextView) itemView.findViewById(R.id.tvSubMaths);
            marksScience = (TextView) itemView.findViewById(R.id.tvSubScience);
            marksAvg = (TextView) itemView.findViewById(R.id.tvAvg);
        }
    }
}
