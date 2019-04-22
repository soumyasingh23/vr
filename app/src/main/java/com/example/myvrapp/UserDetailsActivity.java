package com.example.myvrapp;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class UserDetailsActivity extends AppCompatActivity {

    TextView userName, psychBefore, psychAfter, vrInvolvement, commSupp, healthBefore, healthAfter, timeBalBefore, timeBalAfter, HIbefore, HIafter;
    private Button back, logout;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        UserInformation user = (UserInformation) getIntent().getSerializableExtra("user");
        firebaseAuth = FirebaseAuth.getInstance();
        userName = (TextView) findViewById(R.id.userName3);
        userName.setText(user.getName().toUpperCase());

        commSupp = (TextView) findViewById(R.id.commSupp);
        commSupp.setText(user.getCommunitySupport());

        healthBefore = (TextView) findViewById(R.id.health);
        healthBefore.setText(user.getHealthAndEnergyLevel());

        psychBefore = (TextView) findViewById(R.id.psych);
        psychBefore.setText(user.getPsychologicalWellBeing());

        timeBalBefore = (TextView) findViewById(R.id.timeBal);
        timeBalBefore.setText(user.getTimeBalance());

        float HIb = (Float.parseFloat(user.getCommunitySupport()) + Float.parseFloat(user.getPsychologicalWellBeing()) + Float.parseFloat(user.getHealthAndEnergyLevel()) + Float.parseFloat(user.getTimeBalance()))/4;
        HIbefore = (TextView) findViewById(R.id.HappInd);
        HIbefore.setText(Float.toString(HIb));

        databaseReference = FirebaseDatabase.getInstance().getReference("PostUseInfo").child(user.getUserId());

        psychAfter = (TextView) findViewById(R.id.psychAfter);
        vrInvolvement = (TextView) findViewById(R.id.Involvement);
        healthAfter = (TextView) findViewById(R.id.healthAfter);
        timeBalAfter = (TextView) findViewById(R.id.timeBalAfter);
        HIafter = (TextView) findViewById(R.id.HappIndAfter);

        back = (Button) findViewById(R.id.backBtn2);
        logout = (Button) findViewById(R.id.logoutBtn3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DoctorActivity.class));
            }
        });

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

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserInformation user = dataSnapshot.getValue(UserInformation.class);
                psychAfter.setText(user.getPsychologicalWellBeing());
                vrInvolvement.setText(user.getVrInvolvement());
                healthAfter.setText(user.getHealthAndEnergyLevel());
                timeBalAfter.setText(user.getTimeBalance());
                float HIa = (Float.parseFloat(user.getVrInvolvement()) + Float.parseFloat(user.getPsychologicalWellBeing()) + Float.parseFloat(user.getHealthAndEnergyLevel()) + Float.parseFloat(user.getTimeBalance()))/4;
                HIafter.setText(Float.toString(HIa));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
