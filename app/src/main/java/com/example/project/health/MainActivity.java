package com.example.project.health;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static EditText email = null;
    private static EditText password = null;
    private static Button login = null;
    private static TextView text = null;
    private static CheckBox show_hide_password;
    private static View view;

    public  MainActivity(){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();

    }


        /*text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Signup_activity.class);
                startActivity(j);
            }
        });*/



    //InitViews
    private  void initViews(){
        email = (EditText) findViewById(R.id.mail_id);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.signup);
        show_hide_password = (CheckBox) findViewById(R.id.show_hide_password);
        //forgot_password = (TextView) findViewById(R.id.forgot_password);

    }

    private void setListeners(){
            login.setOnClickListener(this);
            text.setOnClickListener(this);

        //show hide password

        show_hide_password.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkbox status is changed from uncheck to check
                if(!isChecked){
                    //showpassword
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                checkvalidation();
                break;


        }
    }


    //Check Validation
    private void checkvalidation() {

        // Get email id and password
        String getEmailId = email.getText().toString();
        String getPassword = password.getText().toString();

        // Check patter for email id
        Pattern p = Pattern.compile(Utils.regEx);

        Matcher m = p.matcher(getEmailId);

        // Check for both field is empty or not
        if (getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0) {

            Toast.makeText(getApplicationContext(), "No credential",
                    Toast.LENGTH_SHORT).show();
        } else if (!m.find()){
            Toast.makeText(getApplicationContext(), "Your Email Id is Invalid",
                    Toast.LENGTH_SHORT).show();
            onRestart();

            }

        else {
            Toast.makeText(getApplicationContext(), "Welcome",
                    Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Home_Acitivity.class);
            startActivity(i);
            }
        }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent k = new Intent(MainActivity.this, MainActivity.class);
        startActivity(k);
        finish();

    }
}