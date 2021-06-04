package com.example.myroomdatabase;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewholder> {
    @NonNull
    @Override
    public StudentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StudentViewholder extends RecyclerView.ViewHolder {
        public StudentViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
