package com.example.myroomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewholder> {
    Context ct;
    List<StudentEntity> list;

    public StudentAdapter(Context ct, List<StudentEntity> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewholder(LayoutInflater
                .from(ct).inflate(R.layout.student_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewholder holder, int position) {
holder.tv_roll.setText(list.get(position).getRollnumber());
holder.tv_name.setText(list.get(position).getName());
holder.tv_delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //for delete we will come soon
    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewholder extends RecyclerView.ViewHolder {
        TextView tv_edit,tv_delete,tv_name,tv_roll;
        public StudentViewholder(@NonNull View itemView) {
            super(itemView);
            tv_edit=itemView.findViewById(R.id.edit);
            tv_delete=itemView.findViewById(R.id.delete);
            tv_name=itemView.findViewById(R.id.name);
            tv_roll=itemView.findViewById(R.id.rollnumber);
        }
    }
}
