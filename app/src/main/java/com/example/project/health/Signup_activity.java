package com.example.project.health;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.app.FragmentTransaction;

import android.support.v4.app.Fragment;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;


import org.w3c.dom.Text;

public class Signup_activity extends AppCompatActivity implements OnClickListener{

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
    private static EditText firstname,lastname,mobileno,email,birth_date,password,confirmpassword;
    private static Button next;
    private static TextView login;
    //private static Spinner occupation;
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
        inputlayout_birth = (TextInputLayout) findViewById(R.id.input_layout_birth);
        inputlayout_pwd = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputlayout_cpwd = (TextInputLayout) findViewById(R.id.input_layout_cpassword);


        firstname = (EditText) findViewById(R.id.first_name);
        lastname = (EditText) findViewById(R.id.last_name);
        mobileno = (EditText) findViewById(R.id.phn_no);
        email = (EditText) findViewById(R.id.input_email);
        birth_date = (EditText) findViewById(R.id.birth);
       // occupation = (Spinner) findViewById(R.id.spinner_occupation);
        password = (EditText) findViewById(R.id.input_password);
        confirmpassword = (EditText) findViewById(R.id.input_cpassword);
        login = (TextView) findViewById(R.id.already_user);
        next = (Button) findViewById(R.id.btn_next);

        //TextWatcher for all
        firstname.addTextChangedListener(new MyTextWatcher(firstname));
        lastname.addTextChangedListener(new MyTextWatcher(lastname));
        mobileno.addTextChangedListener(new MyTextWatcher(mobileno));
        email.addTextChangedListener(new MyTextWatcher(email));
        birth_date.addTextChangedListener(new MyTextWatcher(birth_date));
        password.addTextChangedListener(new MyTextWatcher(password));
        confirmpassword.addTextChangedListener(new MyTextWatcher(confirmpassword));
    }

    //setListener
    private void setListener(){
        next.setOnClickListener(this);
        login.setOnClickListener(this);
       // occupation.setOnItemSelectedListener(this);

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
                finish();
                break;
        }
    }


    /*@Override
    public void onItemSelected(AdapterView<?> parent,View view,int position,long id){

        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }*/




    public void nextsignup(){

        //sending data to signup 2
        Intent nextscreen = new Intent(Signup_activity.this, Signup_Activity2.class);
        nextscreen.putExtra("fname",firstname.getText().toString());
        nextscreen.putExtra("lname",lastname.getText().toString());
        nextscreen.putExtra("num",mobileno.getText().toString());
        nextscreen.putExtra("mailid",email.getText().toString());
        nextscreen.putExtra("dob",birth_date.getText().toString());


        Log.e("n", firstname.getText()+"."+ lastname.getText()+"."+mobileno.getText()+"."+email.getText()+"."+birth_date.getText());
        startActivity(nextscreen);

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
        if(!validatebirth()){
            return;
        }
        if(!validatepwd()){
            return;
        }
        if(!validatecpwd()){
            return;
        }
        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        nextsignup();

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
     private boolean validatebirth() {
         String getbirth = birth_date.getText().toString();


         // Check patter for birth
         Pattern p = Pattern.compile(Utils.date);

         Matcher m = p.matcher(getbirth);

         // Check for both field is empty or not
         if (getbirth.equals("") || getbirth.length() == 0){
             inputlayout_birth.setError(getString(R.string.err_msg_birth));
             requestFocus(birth_date);
             return false;
         }else if(!m.find()){
             inputlayout_birth.setError(getString(R.string.err_msg_birth1));
             requestFocus(birth_date);
             return false;

         }
         else  {

             inputlayout_birth.setErrorEnabled(false);
         }
         return true;
     }

    private boolean validatepwd() {
        try {
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
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(),
                    Toast.LENGTH_SHORT).show();
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
    private class MyTextWatcher implements TextWatcher {
        private View view;
        private MyTextWatcher(View view){
            this.view = view;
        }
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public  void onTextChanged(CharSequence charSequence, int i,int i1,int i2){

        }
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {

                case R.id.first_name:
                        validatefname();
                        break;
                case R.id.last_name:
                        validatelname();
                        break;
                case R.id.phn_no:
                        validatemobile();
                        break;
                case R.id.input_email:
                        validatemail();
                        break;
                case R.id.birth:
                        validatebirth();
                        break;
                case R.id.input_password:
                        validatepwd();
                        break;

            }
        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


}