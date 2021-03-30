package com.geekbrains.my_calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String RezKey = "RezKey";
    private final static String appTheme = "APP_THEME";

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
    private RadioButton changeDarkTheme;
    private RadioButton changeLightTheme;
    protected static final int AppThemeLightStyle = 0;
    protected static final int AppThemeDarkStyle = 1;

    // сохранение данных
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(RezKey, String.valueOf(rez.getText())); // сохраняем значение результата при смене ориентации
        super.onSaveInstanceState(outState);
    }

    // восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rez.setText(savedInstanceState.getString(RezKey)); // получаем значение результата
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2_vertical);
        // изначально светлая тема
        setTheme(getAppTheme(AppThemeLightStyle));
        initView();
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleID(getCodeStyle(codeStyle));
    }

    private int codeStyleToStyleID(int codeStyle) {
        switch (codeStyle) {
            case AppThemeDarkStyle:
                return R.style.MyStyleDark;
            default:
                return R.style.MyStyle;
        }
    }

    protected int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(appTheme, MODE_PRIVATE);
        return sharedPreferences.getInt(appTheme, codeStyle);
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
        rez = findViewById(R.id.editTextTextMultiLine2);
        // изначально устанавиваем пустую строку
        rez.setText("");
        // определим радио кнопки
        changeDarkTheme = findViewById(R.id.changeDarkTheme);
        changeLightTheme = findViewById(R.id.changeLightTheme);
        initButtonClick();
        initThemeChooser();
    }

    private void initThemeChooser() {

        changeLightTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked) {
                    setAppTheme(0);
                    recreate();
                }
            }
        });

        changeDarkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked) {
                    setAppTheme(1);
                    recreate();
                }
            }
        });

    }

    private void setAppTheme(int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(RezKey, MODE_PRIVATE);
        // сохраняем настройки через Editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(appTheme, i);
        editor.apply();
    }

    private void initButtonClick() {

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button9);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button10);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button11);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button12);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button13);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button14);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button15);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button16);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button17);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button18);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button19);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickButton(button20);
            }
        });
    }

    private void setOnClickButton(Button button) {

        String buttonText = String.valueOf(button.getText());
        String rezText = String.valueOf(rez.getText());

        String result = null;

        if (buttonText.equals("C")) {
            rez.setText("");
        } else if (buttonText.equals("+/-")) {
            if (String.valueOf(rez.getText()).length() == 1) {
                result = "-".concat(String.valueOf(rez.getText()));
            } else if (String.valueOf(rez.getText()).length() == 2) {
                result = (rezText.equals("-")) ? String.valueOf(rez.getText()).replace('-', ' ') : "-".concat(String.valueOf(rez.getText()));
            }
        } else if (buttonText.equals("=")) {
            // тут нужно выполнить расчет
        } else {
            result = String.valueOf(rez.getText()).concat(buttonText);
        }

        rez.setText(result);
    }

    @Override
    public void onClick(View v) {

    }
}