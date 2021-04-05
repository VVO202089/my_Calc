package com.geekbrains.my_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivitySetting extends AppCompatActivity implements Constants {

    private Button launch_Calc;
    private RadioGroup rg;
    private RadioButton changeLightTheme;
    private RadioButton changeDarkTheme;

    private static final int REQUEST_SETTING_ACTIVITY = 99; // для возврата к настройкам

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initElements();
    }

    private void setStyle(int StyleID) {
        switch (StyleID) {
            case 2131230837:
                changeDarkTheme.setChecked(true);
                return;
            default:
                changeLightTheme.setChecked(true);
                return;
        }
    }

    private void initElements() {
        rg = findViewById(R.id.radioGroup);
        changeLightTheme = findViewById(R.id.changeLightTheme);
        changeDarkTheme = findViewById(R.id.changeDarkTheme);
        setStyle(getIntent().getIntExtra(MY_STYLE_ID_RETURN,2131230838));
        launch_Calc = findViewById(R.id.launch_Calc);
        launch_Calc.setOnClickListener(v -> {
            Intent runCalc = new Intent(MainActivitySetting.this, ActivityCalc.class);
            runCalc.putExtra(MY_STYLE_ID, rg.getCheckedRadioButtonId());
            //startActivity(runCalc);
            startActivityForResult(runCalc,REQUEST_SETTING_ACTIVITY);
            finish();
        });
    }

    protected void onActivityResult(int RequestCode, int resultCode, Intent data){
        if (RequestCode != REQUEST_SETTING_ACTIVITY) {
            super.onActivityResult(RequestCode, resultCode, data);
            return;
        }
        if (RequestCode == RESULT_OK){
            setStyle(data.getIntExtra(MY_STYLE_ID_RETURN,2131230838));
        }
    }
}