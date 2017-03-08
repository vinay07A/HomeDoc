package com.example.project.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class bmi_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_activity);
    }

    public void calculateBMI(View view){

        double height=0,weight=0, BMIresult=0;
        String result = "";
        EditText weightInput = (EditText) findViewById(R.id.weight_id);
        EditText heightInput = (EditText) findViewById(R.id.height_id);

        Button calculateBMI = (Button) findViewById(R.id.BMICalculate_id);

        TextView resultView = (TextView) findViewById(R.id.BMIResult_id);
        TextView bmiValue = (TextView) findViewById(R.id.BMI_id);

        weight = Double.parseDouble(weightInput.getText().toString());
        height = Double.parseDouble(heightInput.getText().toString());

        if( height <=0 || weight <=0){

            resultView.setText("Height or Weight cannot be zero.");
            bmiValue.setText("");

        }
        else {

            height = height / 3.333333;
            BMIresult = weight / (height * height);
            String BMIString = String.format("%.2f", BMIresult);

            if (BMIresult < 18.5) {
                result = "You are underweight";
            } else if ((BMIresult > 18.5) && (BMIresult < 25)) {
                result = "You are Normal";
            } else {
                result = "You are overweight";
            }

            bmiValue.setText(BMIString);
            resultView.setText(result);
        }




    }
}
