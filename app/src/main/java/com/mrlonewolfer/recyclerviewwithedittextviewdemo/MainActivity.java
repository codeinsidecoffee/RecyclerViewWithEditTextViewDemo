package com.mrlonewolfer.recyclerviewwithedittextviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, personAdapter.OnPersonClickListner {
    EditText edtFName,edtLname,edtAge;
    Button btnSubmit;
    Context context;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<personBean> personBeans;
    personAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =this;
        edtFName=findViewById(R.id.edtFName);
        edtLname=findViewById(R.id.edtLName);
        edtAge=findViewById(R.id.edtAge);
        btnSubmit=findViewById(R.id.btnSumbit);
        btnSubmit.setOnClickListener(this);
        personBeans=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new personAdapter(personBeans,this);
        recyclerView.setAdapter(adapter);
    }

    private void preparedData() {

        personBeans.add(
                new personBean(edtFName.getText().toString(),edtLname.getText().toString(),edtAge.getText().toString()));

    }

    @Override
    public void onClick(View v) {

        preparedData();
        personAdapter adapter=new personAdapter(personBeans,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnPersonClick(personBean personBean) {
      adapter.notifyDataSetChanged();
        Toast.makeText(context, personBean.getFirstName(), Toast.LENGTH_SHORT).show();
    }
}
