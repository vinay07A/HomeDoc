package com.example.project.health;

/**
 * Created by ubuntu on 21/3/17.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi_calculate extends Fragment implements View.OnClickListener{

    private static TextView title =null;
    private static EditText weight = null;
    private static  EditText height = null;
   private static Button button = null;
    private static TextView bmi =null;
    private static TextView result_view =null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        final View view =  inflater.inflate(R.layout.fargment_bmi, container, false);
        title = (TextView) view.findViewById(R.id.textView3);
        weight = (EditText) view.findViewById(R.id.weight_id);
        height = (EditText) view.findViewById(R.id.height_id);

        bmi = (TextView) view.findViewById(R.id.BMI_id);
        result_view = (TextView) view.findViewById(R.id.BMIResult_id);

        button = (Button) view.findViewById(R.id.BMICalculate_id);
        setListeners();


        return view;
    }



    public void setListeners(){

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

       switch (v.getId()){

           case R.id.BMICalculate_id:
                                    calculatebmi();
                                 Toast.makeText(getActivity().getApplicationContext(), "WELL DONE",
                                         Toast.LENGTH_SHORT).show();
                                    break;


       }
    }
  public void calculatebmi(){

        double height_bmi=0,weight_bmi=0, BMIresult=0;
        String result = "";

        weight_bmi = Double.parseDouble(weight.getText().toString());
        height_bmi = Double.parseDouble(height.getText().toString());

        if( height_bmi <=0 || weight_bmi <=0){

            result_view.setText("Height or Weight cannot be zero.");
            bmi.setText("");

        }
        else {

            height_bmi = height_bmi / 3.333333;
            BMIresult = weight_bmi / (height_bmi * height_bmi);
            String BMIString = String.format("%.2f", BMIresult);

            if (BMIresult < 18.5) {
                result = "You are underweight";
            } else if ((BMIresult > 18.5) && (BMIresult < 25)) {
                result = "You are Normal";
            } else {
                result = "You are overweight";
            }

            bmi.setText(BMIString);
            result_view.setText(result);
        }


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("BMI");
    }
}
