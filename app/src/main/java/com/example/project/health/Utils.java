package com.example.project.health;

/**
 * Created by ubuntu on 6/3/17.
 */
import java.util.Locale;

import android.app.Service;
import android.speech.tts.TextToSpeech;
import android.text.format.Time;
import android.util.Log;





public class Utils implements TextToSpeech.OnInitListener  {





    //Email Validation pattern
   // public static final String regEx = "\b[a-z]{4}\b";
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
    public  static final  String fname = "\\b[A-Za-z]+\\b";
    public static final String lname = "\\b[A-Za-z]+\\b";
    public static final String number = "\\b[7-9][0-9]{9}\\b";
    public static final String pwd = "\\b[A-Za-z0-9]{8,}\\b";
    //var reg = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;

    public static final String date = "\\b^(0[1-9]|1\\d|2\\d|3[01])\\/(0[1-9]|1[0-2])\\/(19|20)\\d{2}\\b";


    //Pedometer

    private static final String TAG = "Utils";
    private Service mService;

    private static Utils instance = null;

    private Utils() {
    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public void setService(Service service) {
        mService = service;
    }

    /********** SPEAKING **********/

    private TextToSpeech mTts;
    private boolean mSpeak = false;
    private boolean mSpeakingEngineAvailable = false;

    public void initTTS() {
        // Initialize text-to-speech. This is an asynchronous operation.
        // The OnInitListener (second argument) is called after initialization completes.
        Log.i(TAG, "Initializing TextToSpeech...");
        mTts = new TextToSpeech(mService,
                this  // TextToSpeech.OnInitListener
        );
    }
    public void shutdownTTS() {
        Log.i(TAG, "Shutting Down TextToSpeech...");

        mSpeakingEngineAvailable = false;
        mTts.shutdown();
        Log.i(TAG, "TextToSpeech Shut Down.");

    }
    public void say(String text) {
        if (mSpeak && mSpeakingEngineAvailable) {
            mTts.speak(text,
                    TextToSpeech.QUEUE_ADD,  // Drop all pending entries in the playback queue.
                    null);
        }
    }

    // Implements TextToSpeech.OnInitListener.
    public void onInit(int status) {
        // status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
        if (status == TextToSpeech.SUCCESS) {
            int result = mTts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language data is missing or the language is not supported.
                Log.e(TAG, "Language is not available.");
            } else {
                Log.i(TAG, "TextToSpeech Initialized.");
                mSpeakingEngineAvailable = true;
            }
        } else {
            // Initialization failed.
            Log.e(TAG, "Could not initialize TextToSpeech.");
        }
    }

    public void setSpeak(boolean speak) {
        mSpeak = speak;
    }

    public boolean isSpeakingEnabled() {
        return mSpeak;
    }

    public boolean isSpeakingNow() {
        return mTts.isSpeaking();
    }

    public void ding() {
    }

    /********** Time **********/

    public static long currentTimeInMillis() {
        Time time = new Time();
        time.setToNow();
        return time.toMillis(false);
    }

}



