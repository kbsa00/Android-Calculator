package com.example.eier.calculator;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    private TextView totaltextview;
    private ImageButton plus;
    private ImageButton minus;
    private ImageButton multiply;
    private ImageButton equals;
    private ImageButton divide;
    private Button clear;
    private Button[] btnArray = new Button[10];
    private float sum = 0;
    private float digit = 0;
    private int lastID;
    private String finalanswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        totaltextview = (TextView) findViewById(R.id.textView);
        run();
    }


    public void run(){

        Resources res = getResources();
        for (int i = 0; i < btnArray.length; i++){
            String id = "button" + i;

            btnArray[i] = (Button) findViewById(res.getIdentifier(id, "id", getPackageName()));

        }


        for (int i = 0; i < btnArray.length; i++){


            btnArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    float number = Float.parseFloat(totaltextview.getText().toString());

                    String idname = v.getResources().getResourceName(v.getId());

                    String num = String.valueOf(idname.charAt(idname.length() - 1));

                    if (number == 0){
                        totaltextview.setText(num);
                    }
                    else{
                        totaltextview.append(num);
                    }
                }
            });
        }


        clear = (Button) findViewById(R.id.buttonClear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totaltextview.setText("0");
                sum = 0;
            }
        });

        plus = (ImageButton) findViewById(R.id.image3);
        multiply = (ImageButton) findViewById(R.id.image1);
        divide = (ImageButton) findViewById(R.id.image0);
        minus = (ImageButton) findViewById(R.id.image2);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit = Float.parseFloat(totaltextview.getText().toString());
                sum += digit;
                lastID = 1;

                totaltextview.setText("0");
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit = Float.parseFloat(totaltextview.getText().toString());
                sum += digit;
                lastID = 2;
                totaltextview.setText("0");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit = Float.parseFloat(totaltextview.getText().toString());
                sum += digit;
                lastID = 3;
                totaltextview.setText("0");
            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit = Float.parseFloat(totaltextview.getText().toString());
                sum += digit;
                lastID = 4;
                totaltextview.setText("0");
            }
        });



        equals = (ImageButton) findViewById(R.id.equals);

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (lastID){

                    case 1:
                            digit = Float.parseFloat(totaltextview.getText().toString());
                            sum += digit;
                            finalanswer = String.valueOf(sum);
                            totaltextview.setText(finalanswer);
                            sum = 0;
                            lastID = 0;

                    break;

                    case 2:
                            digit = Float.parseFloat(totaltextview.getText().toString());
                            sum = (sum - digit);
                            finalanswer = String.valueOf(sum);
                            totaltextview.setText(finalanswer);
                            sum = 0;
                            lastID = 0;
                        break;

                    case 3:
                            digit = Float.parseFloat(totaltextview.getText().toString());
                            sum = (sum / digit);
                            finalanswer = String.valueOf(sum);
                            totaltextview.setText(finalanswer);
                            sum = 0;
                            lastID = 0;
                        break;

                    case 4:

                            digit = Float.parseFloat(totaltextview.getText().toString());
                            sum = (sum * digit);
                            finalanswer = String.valueOf(sum);
                            totaltextview.setText(finalanswer);
                            sum = 0;
                            lastID = 0;
                        break;
                }
            }
        });

    }
}
