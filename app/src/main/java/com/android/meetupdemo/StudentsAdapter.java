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
        holder.studentName.setText(studentsModel.getStudentName());
        holder.marksEnglish.setText(studentsModel.getMarksEnglish());
        holder.marksHindi.setText(studentsModel.getMarksHindi());
        holder.marksRegional.setText(studentsModel.getMarksRegional());
        holder.marksMaths.setText(studentsModel.getMarksMaths());
        holder.marksScience.setText(studentsModel.getMarksScience());
        holder.marksSocial.setText(studentsModel.getMarksSocial());
        holder.marksTotal.setText(studentsModel.getMarksTotal());
        holder.marksAvg.setText(studentsModel.getMarksAvg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView studentName, marksEnglish, marksHindi, marksRegional, marksMaths, marksScience, marksSocial, marksTotal, marksAvg;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.tvStudentName);
            marksEnglish = (TextView) itemView.findViewById(R.id.tvSubEng);
            marksHindi = (TextView) itemView.findViewById(R.id.tvSubHindi);
            marksRegional = (TextView) itemView.findViewById(R.id.tvSubRegional);
            marksMaths = (TextView) itemView.findViewById(R.id.tvSubMaths);
            marksScience = (TextView) itemView.findViewById(R.id.tvSubScience);
            marksSocial = (TextView) itemView.findViewById(R.id.tvSubSocial);
            marksTotal = (TextView) itemView.findViewById(R.id.tvTotal);
            marksAvg = (TextView) itemView.findViewById(R.id.tvAvg);
        }
    }
}
