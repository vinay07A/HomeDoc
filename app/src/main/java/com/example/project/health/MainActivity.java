package com.example.project.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username=null;
    private EditText password=null;
    private Button login=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.button);

    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Welcome",
                    Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,Home_activity.class);
            startActivity(i);

        } else {
            Toast.makeText(getApplicationContext(), "Invalid username or password",
                    Toast.LENGTH_SHORT).show();

            }
        }
    }

