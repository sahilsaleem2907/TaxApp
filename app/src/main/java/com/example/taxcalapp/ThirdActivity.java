package com.example.taxcalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
 Double Tax ;
 EditText Sal ,Cap ,Oth;
 Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_third);
        ConstraintLayout constraintLayout = findViewById(R.id.layout2);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        Sal = findViewById(R.id.salary);
        Cap = findViewById(R.id.capital);
        Oth = findViewById(R.id.other);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal(Double.parseDouble(Sal.getText().toString()),Double.parseDouble(Cap.getText().toString()),
                        Double.parseDouble(Oth.getText().toString()));
            }
        });


    }

    public void cal(Double Salary , Double Capital , Double Other)
    {

        if(Salary > 1000000.0)
        {
            Tax = (0.34 * Salary) + (0.2 * Capital) + (0.15 * Other );
            Intent myIntent = new Intent(ThirdActivity.this, FourthActivity.class);
            myIntent.putExtra("Tax", Tax);
            ThirdActivity.this.startActivity(myIntent);
        }
        else{
                Tax = (0.3 * Salary) + (0.2 * Capital) + (0.15 * Other );
            Intent myIntent = new Intent(ThirdActivity.this, FourthActivity.class);
            myIntent.putExtra("Tax", Tax);
            ThirdActivity.this.startActivity(myIntent);
        }

    }


}