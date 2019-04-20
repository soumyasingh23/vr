package com.example.myvrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        UserInformation user = (UserInformation) getIntent().getSerializableExtra("user");
        String details = "Name :"+user.getName() + "\nEmail: " +user.getEmail();
        TextView textView = (TextView)findViewById(R.id.userDetails);
        textView.setText(details);

    }
}
