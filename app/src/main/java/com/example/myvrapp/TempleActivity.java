package com.example.myvrapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TempleActivity extends AppCompatActivity {

    private ListView templeList;
    List<Temple> temples= new ArrayList<Temple>();
    private FirebaseListAdapter adapter;
    private DatabaseReference databaseReference;
    private ArrayList<String> templeNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple);
        templeList = (ListView) findViewById(R.id.templeList);
//        Query query = FirebaseDatabase.getInstance().getReference().child("Temple");
//        FirebaseListOptions<Temple> options = new FirebaseListOptions.Builder<Temple>()
//                .setLayout(R.layout.templerow_list)
//                .setLifecycleOwner(TempleActivity.this)
//                .setQuery(query, Temple.class)
//                .build();
//        adapter = new FirebaseListAdapter(options) {
//            @Override
//            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
//                TextView name = v.findViewById(R.id.TempleName);
//                TextView city = v.findViewById(R.id.TempleCity);
//                ImageView image = v.findViewById(R.id.TempleImage);
//
//                Temple temple = (Temple)model;
//                name.setText(temple.getName());
//                city.setText(temple.getCity());
//                Picasso.with(TempleActivity.this).load(temple.getImage().toString()).into(image);
//            }
//
//        };
//        templeList.setAdapter(adapter);
//
//        templeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("position {}", Integer.toString(position));
//                Log.i("id {}", Long.toString(id));
//                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        databaseReference = FirebaseDatabase.getInstance().getReference("Temple");


    }



    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                temples.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren() )
                {
                    Temple temple = dataSnapshot1.getValue(Temple.class);
                    temples.add(temple);
                }
                CustomListAdapter templeListAdapter = new CustomListAdapter(TempleActivity.this, temples);
                templeList.setAdapter(templeListAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        adapter.stopListening();
    }
}
