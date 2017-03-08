package com.example.project.health;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;


import org.w3c.dom.Text;

public class Signup_activity extends AppCompatActivity implements OnClickListener {

   /* private static Toolbar toolbar;
    private static EditText firstname,lastname,mobileno,email,birth,password,confirmpassword;
    private static Button next;
    private static TextView login;
    private static TextInputLayout inputlayout_fname,inputlayout_lname,inputlayout_mobile,inputlayout_email;
    private static TextInputLayout inputlayout_birth,inputlayout_pwd,inputlayout_cpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

       toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initviews();
        setListener();
    }

    //initviews
    private void initviews(){}
    private void setListener(){}*/


    private static Toolbar toolbar;
    private static EditText firstname,lastname,mobileno,email,birth,password,confirmpassword;
    private static Button next;
    private static TextView login;
    private static TextInputLayout inputlayout_fname,inputlayout_lname,inputlayout_mobile,inputlayout_email;
    private static TextInputLayout inputlayout_birth,inputlayout_pwd,inputlayout_cpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

        initviews();
        setListener();
    }

    //initviews
    private void initviews(){

        inputlayout_fname = (TextInputLayout) findViewById(R.id.input_layout_fname);
        inputlayout_lname = (TextInputLayout) findViewById(R.id.input_layout_lname);
        inputlayout_mobile = (TextInputLayout) findViewById(R.id.input_layout_phone);
        inputlayout_email = (TextInputLayout) findViewById(R.id.input_layout_email);
        //inputlayout_birth = (TextInputLayout) findViewById(R.id.input_layout_birth);
        inputlayout_pwd = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputlayout_cpwd = (TextInputLayout) findViewById(R.id.input_layout_cpassword);
        next = (Button) findViewById(R.id.btn_next);

        firstname = (EditText) findViewById(R.id.first_name);
        lastname = (EditText) findViewById(R.id.last_name);
        mobileno = (EditText) findViewById(R.id.phn_no);
        email = (EditText) findViewById(R.id.input_email);
        // birth = (EditText) findViewById(R.id.birth);
        password = (EditText) findViewById(R.id.input_password);
        confirmpassword = (EditText) findViewById(R.id.input_cpassword);
        login = (TextView) findViewById(R.id.already_user);
    }

    //setListener
    private void setListener(){
        next.setOnClickListener(this);
        login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_next:
                submitform();
                break;
            case R.id.already_user:
                Intent l = new Intent(Signup_activity.this, MainActivity.class);
                startActivity(l);
                break;
        }
    }

    //validate form
    private void submitform(){

        if(!validatefname()){
            return;
        }
        if(!validatelname()){
            return;
        }
        if(!validatemobile()){
            return;
        }
        if(!validatemail()){
            return;
        }
        /*if(!validatebirth()){
            return;
        }*/
        if(!validatepwd()){
            return;
        }
        if(!validatecpwd()){
            return;
        }
        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();

    }

    private boolean validatefname() {

        String getfname = firstname.getText().toString();

        Pattern p = Pattern.compile(Utils.fname);
        Matcher m = p.matcher(getfname);


        if (getfname.equals("") || getfname.length() == 0) {
            inputlayout_fname.setError(getString(R.string.err_msg_fname));
            requestFocus(firstname);
            return false;
        }else if(!m.find()){
            inputlayout_fname.setError(getString(R.string.err_msg_fname1));
            requestFocus(firstname);
            return false;

        }
        else  {

            inputlayout_fname.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatelname() {
        String getlname = lastname.getText().toString();

        Pattern p = Pattern.compile(Utils.lname);
        Matcher m = p.matcher(getlname);


        if (getlname.equals("") || getlname.length() == 0) {
            inputlayout_lname.setError(getString(R.string.err_msg_lname));
            requestFocus(lastname);
            return false;
        }else if(!m.find()){
            inputlayout_lname.setError(getString(R.string.err_msg_lname1));
            requestFocus(lastname);
            return false;

        }
        else  {

            inputlayout_lname.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatemobile() {
        String getnum = mobileno.getText().toString();

        Pattern p = Pattern.compile(Utils.number);
        Matcher m = p.matcher(getnum);


        if (getnum.equals("") || getnum.length() == 0) {
            inputlayout_mobile.setError(getString(R.string.err_msg_mobile));
            requestFocus(mobileno);
            return false;
        }else if(!m.find()){
            inputlayout_mobile.setError(getString(R.string.err_msg_num));
            requestFocus(mobileno);
            return false;

        }
        else  {

            inputlayout_mobile.setErrorEnabled(false);
        }


        return true;
    }
    private boolean validatemail() {
        String getEmailId = email.getText().toString();


        // Check patter for email id
        Pattern p = Pattern.compile(Utils.regEx);

        Matcher m = p.matcher(getEmailId);

        // Check for both field is empty or not
        if (getEmailId.equals("") || getEmailId.length() == 0){
            inputlayout_email.setError(getString(R.string.err_msg_mail));
            requestFocus(email);
            return false;
        }else if(!m.find()){
            inputlayout_email.setError(getString(R.string.err_msg_mail1));
            requestFocus(email);
            return false;

        }
        else  {

            inputlayout_email.setErrorEnabled(false);
        }

        return true;
    }
    /* private boolean validatebirth() {
         if (birth.getText().toString().trim().isEmpty()) {
             inputlayout_birth.setError(getString(R.string.err_msg_birth));
             requestFocus(birth);
             return false;
         } else {
             inputlayout_birth.setErrorEnabled(false);
         }

         return true;
     }*/
    //String getpwd = password.getText().toString();
    private boolean validatepwd() {
        String getpwd = password.getText().toString();


        // Check patter for email id
        Pattern p = Pattern.compile(Utils.pwd);

        Matcher m = p.matcher(getpwd);

        // Check for both field is empty or not
        if (getpwd.equals("") || getpwd.length() == 0) {
            inputlayout_pwd.setError(getString(R.string.err_msg_pwd));
            requestFocus(password);
            return false;
        } else if (!m.find()) {
            inputlayout_pwd.setError(getString(R.string.err_msg_pwd1));
            requestFocus(password);
            return false;

        } else {

            inputlayout_pwd.setErrorEnabled(false);
        }

        return true;

    }
    private boolean validatecpwd() {
        String getcpwd = confirmpassword.getText().toString();
        String getpwd = password.getText().toString();

        // Check patter for email id
        // Pattern p = Pattern.compile(Utils.pwd);

        //Matcher m = p.matcher(getcpwd);

        // Check for both field is empty or not
        if (getcpwd.equals("") || getcpwd.length() == 0){
            inputlayout_cpwd.setError(getString(R.string.err_msg_cpwd));
            requestFocus(confirmpassword);
            return false;
        }else if(!getcpwd.equals(getpwd)){
            inputlayout_pwd.setError(getString(R.string.err_msg_cpwd1));
            requestFocus(confirmpassword);
            return false;

        }
        else  {

            inputlayout_cpwd.setErrorEnabled(false);
        }


        return true;
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


}