package com.example.myvrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class data_collection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);
        Spinner templev = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(data_collection.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.choices));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        templev.setAdapter(myadapter);
        Spinner sleept = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> myadapter2 = new ArrayAdapter<>(data_collection.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.hours));
        myadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sleept.setAdapter(myadapter2);
        Spinner appetite = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> myadapter3 = new ArrayAdapter<>(data_collection.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.appetite));
        myadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appetite.setAdapter(myadapter3);
    }
}
