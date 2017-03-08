package com.example.project.health;

/**
 * Created by ubuntu on 6/3/17.
 */

public class Utils {

    //Email Validation pattern
   // public static final String regEx = "\b[a-z]{4}\b";
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
    public  static final  String fname = "\\b[A-Za-z]+\\b";
    public static final String lname = "\\b[A-Za-z]+\\b";
    public static final String number = "\\b[7-9][0-9]{9}\\b";
    public static final String pwd = "\\b[A-Za-z]{6,}[0-9}{2,}\\b";


}
