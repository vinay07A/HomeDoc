package com.example.project.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Signup_Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_2);

        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtlname = (TextView) findViewById(R.id.txtLname);
        TextView txtphone = (TextView) findViewById(R.id.phone_no);
        TextView txtmail = (TextView) findViewById(R.id.mail_id);
        TextView txtdob = (TextView) findViewById(R.id.dob);


        Intent i = getIntent();
        // Receiving the Data
        String fname = i.getStringExtra("fname");
        String lname = i.getStringExtra("lname");
        String number = i.getStringExtra("num");
        String Email = i.getStringExtra("mailid");
        String DOB = i.getStringExtra("dob");

        Log.e("Second Screen", fname + "." + lname+"."+number+"."+Email+"."+DOB);


        // Displaying Received data
        txtName.setText(fname);
        txtlname.setText(lname);
        txtphone.setText(number);
        txtmail.setText(Email);
        txtdob.setText(DOB);

    }
}
