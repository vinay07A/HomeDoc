package com.example.project.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Forgotpassword extends AppCompatActivity implements OnClickListener {

    private static View view;
    private static  EditText email = null;
    private static  TextView submit=null;
    private  static TextView back=null;

    public Forgotpassword(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        initviews();
        setListener();

    }

    //InitViews
    private  void initviews() {
        email = (EditText) findViewById(R.id.registered_emailid);
        submit = (TextView) findViewById(R.id.forgot_button);
        back = (TextView) findViewById(R.id.backToLoginBtn);
    }

    private void setListener(){

        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

            switch (v.getId()){

                case R.id.forgot_button:
                         submitbutton();
                            break;

                case R.id.backToLoginBtn:
                        //Refresh login page
                    Intent l = new Intent(Forgotpassword.this, MainActivity.class);
                    startActivity(l);
                    finish();
                            break;


            }

    }

    private void submitbutton(){


        // Get email id and password
       String getEmailId = email.getText().toString();


        // Check patter for email id
        Pattern p = Pattern.compile(Utils.regEx);

        Matcher m = p.matcher(getEmailId);


        //check email is null or not
        if (getEmailId.equals("") || getEmailId.length() == 0){
            Toast.makeText(getApplicationContext(), "Please enter your email id",
                    Toast.LENGTH_SHORT).show();
        }
        // Check if email id is valid or not
        else if (!m.find()){
            Toast.makeText(getApplicationContext(), "Your Email Id is Invalid",
                    Toast.LENGTH_SHORT).show();
            onRestart();

        }
        else{
            Toast.makeText(getApplicationContext(), "get forgot password",
                    Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Intent k = new Intent(Forgotpassword.this, Forgotpassword.class);
        startActivity(k);
        finish();

    }


}
