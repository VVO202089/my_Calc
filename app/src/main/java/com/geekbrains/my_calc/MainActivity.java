package com.geekbrains.my_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private EditText rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        initView();
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        rez      = findViewById(R.id.editTextTextMultiLine2);
        initButtonClick();
    }

    private void initButtonClick() {

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button1.getText()));
                rez.setText(rezult);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button2.getText()));
                rez.setText(rezult);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button3.getText()));
                rez.setText(rezult);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button4.getText()));
                rez.setText(rezult);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button5.getText()));
                rez.setText(rezult);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button6.getText()));
                rez.setText(rezult);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button7.getText()));
                rez.setText(rezult);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button8.getText()));
                rez.setText(rezult);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button9.getText()));
                rez.setText(rezult);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button10.getText()));
                rez.setText(rezult);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button11.getText()));
                rez.setText(rezult);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button12.getText()));
                rez.setText(rezult);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button13.getText()));
                rez.setText(rezult);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button14.getText()));
                rez.setText(rezult);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button15.getText()));
                rez.setText(rezult);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button16.getText()));
                rez.setText(rezult);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button17.getText()));
                rez.setText(rezult);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button18.getText()));
                rez.setText(rezult);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button19.getText()));
                rez.setText(rezult);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rezult = String.valueOf(rez.getText()).concat(String.valueOf(button20.getText()));
                rez.setText(rezult);
            }
        });
    }
    
}