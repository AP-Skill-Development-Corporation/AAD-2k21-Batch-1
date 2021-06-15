package com.example.mywhtsupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    Context ct;
    String c_names[];
    String c_numbers[];
    int c_images[];
    /*right click->generate->constractor->select all ->ok*/

    public ContactsAdapter(Context ct, String[] c_names, String[] c_numbers, int[] c_images) {
        this.ct = ct;
        this.c_names = c_names;
        this.c_numbers = c_numbers;
        this.c_images = c_images;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactsViewHolder(LayoutInflater.from(ct).inflate(R.layout.contact_row,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.tv.setText(c_names[position]);
        holder.tv1.setText(c_numbers[position]);
        holder.img.setImageResource(c_images[position]);
    }

    @Override
    public int getItemCount() {
        return c_images.length;
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv, tv1;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv_contactName);
            tv1 = itemView.findViewById(R.id.tv_contactNumber);
        }
    }
}
