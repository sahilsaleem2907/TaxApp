package com.example.taxcalapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editText ;
    Button button ;

    public void continue_clicked(View view)
    {

        if(isValidPanCardNo(editText.getText().toString()))
        {
            Toast.makeText(this, "PAN Number is Valid", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);

        }else if (isValidPanCardNo(editText.getText().toString()) == false)
        {
            Toast.makeText(this, "PAN Number is Invalid", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        editText = findViewById(R.id.pan_no);
        button = findViewById(R.id.button);



    }

    public static boolean isValidPanCardNo(
            String panCardNo)
    {

        // Regex to check valid PAN Card number.
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";


        Pattern p = Pattern.compile(regex);


        if (panCardNo == null) {
            return false;
        }


        Matcher m = p.matcher(panCardNo);


        return m.matches();
    }


}