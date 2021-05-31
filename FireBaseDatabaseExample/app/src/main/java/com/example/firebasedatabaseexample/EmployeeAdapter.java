package com.example.firebasedatabaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends
        RecyclerView.Adapter<EmployeeAdapter.EmplyeeViewHolder> {

    Context ctx;
    List<Employee> list;

    public EmployeeAdapter(Context ctx, List<Employee> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public EmplyeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmplyeeViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.row_design,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull EmplyeeViewHolder holder, int position) {
        holder.n.setText(list.get(position).getEname());
        holder.i.setText(list.get(position).geteId());
        holder.s.setText(list.get(position).geteSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmplyeeViewHolder extends RecyclerView.ViewHolder {
        TextView n,i,s;
        public EmplyeeViewHolder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.tv_empname);
            i=itemView.findViewById(R.id.tv_empId);
            s=itemView.findViewById(R.id.tv_empsalaray);
        }
    }
}
