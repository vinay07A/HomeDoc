package com.example.project.health;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.project.health.R;

import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private EditText username = null, password = null;
    private Button login = null;
    private TextView text = null, forgot_password = null;

    private static CheckBox show_hide_password;
    private static LinearLayout loginLayout;
    private static FragmentActivity fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.mail_id);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.signup);
        show_hide_password = (CheckBox) findViewById(R.id.show_hide_password);
        forgot_password = (TextView) findViewById(R.id.forgot_password);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Signup_activity.class);
                startActivity(j);
            }
        });
    }

    private void setListener(){
        //forgot_password.setOnClickListener(this);
        // Set check listener over checkbox for showing and hiding password

        show_hide_password.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    show_hide_password.setText(R.string.hide_pwd);
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    password.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());// show password
                } else {
                    show_hide_password.setText(R.string.show_pwd);// change
                    // checkbox
                    // text

                    password.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());// hide password
                }

            }
        });
    }

        public void login (View view){
            onRestart();
            if (username.getText().toString().equals("admin") &&
                    password.getText().toString().equals("admin")) {


                Toast.makeText(getApplicationContext(), "Welcome",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Home_Acitivity.class);
                startActivity(i);

            } else if ((username.getText().toString().equals("")) && (password.getText().toString().equals(""))) {
                Toast.makeText(getApplicationContext(), "No credential",
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "Invalid username or password",
                        Toast.LENGTH_SHORT).show();

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
