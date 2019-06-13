package com.mrlonewolfer.recyclerviewwithedittextviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class personAdapter extends RecyclerView.Adapter<personAdapter.personViewHolder> {

    private  OnPersonClickListner listner;
    private ArrayList<personBean> personBeans;
    public personAdapter(ArrayList<personBean> personBeans, OnPersonClickListner listner) {
        this.personBeans=personBeans;
        this.listner=listner;
    }
    @NonNull
    @Override
    public personViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_row_item,viewGroup,false);
        personViewHolder viewHolder = new personViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final personViewHolder personViewHolder, final int position) {
        final personBean person=personBeans.get(position);
        personViewHolder.txtName.setText(person.getFirstName()+" "+person.getLastName());
        personViewHolder.txtEmail.setText(person.getAge()+" Years");
        personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.OnPersonClick(person);
            }
        });
        personViewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personBeans.remove(position);
                listner.OnPersonClick(person);
            }
        });


    }

    @Override
    public int getItemCount() {
        return personBeans.size();
    }

    public interface OnPersonClickListner{
        void OnPersonClick(personBean personBean);

    }

    public class personViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtEmail;
        ImageView imgDelete;

        public personViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtEmail=itemView.findViewById(R.id.txtAge);
            imgDelete=itemView.findViewById(R.id.imgDelete);

        }
    }
}
