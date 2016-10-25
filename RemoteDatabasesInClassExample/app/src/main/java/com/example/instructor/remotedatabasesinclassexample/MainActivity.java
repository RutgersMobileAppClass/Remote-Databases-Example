package com.example.instructor.remotedatabasesinclassexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void queryClick(View view) {

        // The big difference between the slides and this is the inclusion
        // in updated FireBase of "DatabaseReference" and "FirebaseDatabase"


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Simpsons"); // What database can I actually talk to?
        DatabaseReference students = ref.child("Students");
        DatabaseReference bart = students.child("Bart");
        bart.child("Name").setValue("Bart");
        bart.child("ID").setValue(1);
        bart.child("Email").setValue("a@gmail.com");
        bart.child("Test").setValue("Test", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Toast.makeText(MainActivity.this, "Added!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
