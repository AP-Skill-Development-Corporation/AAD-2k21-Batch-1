package com.example.dummywhtsup.contacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dummywhtsup.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    int images[];
    String titles[];
    String number[];

    public MyAdapter(Context ctx, int[] images, String[] titles, String[] number) {
        this.ctx = ctx;
        this.images = images;
        this.titles = titles;
        this.number = number;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater
                .from(ctx)
                .inflate(R.layout.each_row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.myName.setText(titles[position]);
    holder.myNumber.setText(number[position]);
    holder.myImage.setImageResource(images[position]);
    holder.myImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String cName=titles[position];
            String cNumber=number[position];
            Intent i=new Intent(ctx,DetailesActivity.class);
                /*implict-->out side app screen
                    * explicit-->with in app screen */
            i.putExtra("key_name",cName);
            i.putExtra("key_number",cNumber);
            ctx.startActivity(i);



        }
    });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myImage;
        TextView myName,myNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage=itemView.findViewById(R.id.iv);
            myName=itemView.findViewById(R.id.name);
            myNumber=itemView.findViewById(R.id.number);
        }
    }
}
