package com.example.myvrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    TextView email;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email = (TextView)findViewById(R.id.textView3);
        logout = (Button)findViewById(R.id.logout);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            startActivity(new Intent(getApplicationContext(), LogInActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        email.setText("hello, "+user.getDisplayName());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                Toast.makeText(getApplicationContext(), "Signed out successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
