package com.example.project.health;

/**
 * Created by ubuntu on 6/3/17.
 */


import android.speech.tts.TextToSpeech;


public class Utils {



    private Utils() {
    }


    //Email Validation pattern
   // public static final String regEx = "\b[a-z]{4}\b";
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
    public  static final  String fname = "\\b[A-Za-z]+\\b";
    public static final String lname = "\\b[A-Za-z]+\\b";
    public static final String number = "\\b[7-9][0-9]{9}\\b";
    public static final String pwd = "\\b[A-Za-z0-9]{8,}\\b";
    //var reg = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;

    public static final String date = "\\b^(0[1-9]|1\\d|2\\d|3[01])\\/(0[1-9]|1[0-2])\\/(19|20)\\d{2}\\b";



}



