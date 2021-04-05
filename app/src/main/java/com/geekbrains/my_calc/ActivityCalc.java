package com.geekbrains.my_calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.geekbrains.my_calc.R.id.alertTitle;
import static com.geekbrains.my_calc.R.id.button1;

public class ActivityCalc extends AppCompatActivity implements Constants {

    Pattern pattern = Pattern.compile("^-?\\d{1,}(\\.\\d{1,})?[-+*/]\\d{1,}(\\.\\d{1,})?$");
    private boolean correct;
    private final static String RezKey = "RezKey";
    private final static String appTheme = "APP_THEME";

    private int myStyleId;
    private int[] numberButtonID;

    private Button buttonGoSettings;
    private EditText rez;
    protected RadioGroup rg;

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
        // получим тему из настроек (первоначальный экран)
        // 0 - светлая тема;
        // 1 - темная тема.
        myStyleId = getIntent().getExtras().getInt(MY_STYLE_ID);
        setTheme(getAppTheme(myStyleId));
        setContentView(R.layout.activity_main_2_vertical);
        // инициализация кнопок калькулятора
        initButtonID();
        initView();
        initButtonClick();
    }

    private void initButtonID() {

        numberButtonID = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15,
                R.id.button16, R.id.button17, R.id.button18, R.id.button19, R.id.button20};

    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleID(codeStyle);
    }

    private int codeStyleToStyleID(int codeStyle) {
        switch (codeStyle) {
            case 2131230837:
                return R.style.MyStyleDark;
            default:
                return R.style.MyStyle;
        }
    }

    private void initView() {

        buttonGoSettings = findViewById(R.id.goSettings);
        rez = findViewById(R.id.editTextTextMultiLine2);
        // изначально устанавиваем пустую строку
        rez.setText("");
        initButtonClick();
        initRezEnter();
    }

    private void initRezEnter() {

        //Matcher matcher = pattern.matcher(rez.getText());
        //correct = matcher.matches();

        TextWatcher inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Matcher matcher = pattern.matcher(rez.getText());
                correct = matcher.matches();

            }

        };
        rez.addTextChangedListener(inputTextWatcher);
    }

    private void initButtonClick() {

        for (int i = 0; i < numberButtonID.length; i++) {
            int index = i;
            findViewById(numberButtonID[i]).setOnClickListener(v -> {
                setOnClickButton(findViewById(numberButtonID[index]));
            });
        }

        buttonGoSettings.setOnClickListener(v -> {
            Intent intentSetting = new Intent(this,MainActivitySetting.class);
            intentSetting.putExtra(MY_STYLE_ID_RETURN, myStyleId);
            setResult(RESULT_OK, intentSetting);
            startActivity(intentSetting);
            finish();
        });
    }

    private void setOnClickButton(Button btn) {

        String rezText = String.valueOf(rez.getText());
        String buttonText = String.valueOf(btn.getText());
        String result = null;

        switch (buttonText) {

            case "C":
                rez.setText("");
                return;
            /*case "()":
                // если введено число, тогда добавляем *(
                if (isNumber(rezText)){
                    result = rezText.concat("*(");
                    return;
                }
                // если после последнего символа "("
                return;*/
            case "+/-":
                // если введено число и нет знака "-", то добавляем, иначе нет
                if (isNumber(rezText)) {
                    result = ((rezText.equals("-")) ? rezText.substring(2, rezText.length()) : "-".concat(rezText));
                }
                return;
            case "=":

                // проверим, корректный ли ввод данных в rez
                if (!correct){
                    // предупреждение о некорректных данных
                    // светлая тема
                    AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyStyle);
                    builder.setTitle("Внимание!");
                    builder.setMessage("Некорректный ввод данных");
                    //builder.setIcon(R.drawable.lesson2_main);
                    builder.setPositiveButton("Ок, я исправлю", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    alertDialog.getWindow().setLayout(600,700);
                    return;
                }

                double resultCalc = 0;
                // получим результат в обратной польской записи
                char[] masRezText = GetExpression(rezText).toCharArray();
                Stack<Double> stack = new Stack<>();

                //парсим rezText слева направо
                for (int i = 0; i < masRezText.length; i++) {

                    String currentElement = String.valueOf(masRezText[i]);

                    if (currentElement.equals(" ")){
                        continue;
                    }

                    // если число, тогда добавляем в стек, иначе
                    // вытаскиваем 2 элемента из стека
                    if (isNumber(currentElement)) {
                        stack.push(Double.parseDouble(currentElement));
                    } else {
                        double tmp1 = stack.pop();
                        double tmp2 = stack.pop();

                        switch (currentElement) {
                            case "+":
                                stack.push(tmp1 + tmp2);
                                break;
                            case "-":
                                stack.push(tmp1 - tmp2);
                                break;
                            case "*":
                                stack.push(tmp1 * tmp2);
                                break;
                            case "/":
                                stack.push((tmp2 == 0) ? 0 : tmp1 / tmp2);
                                break;
                        }
                    }
                }
                // получаем результат
                if (!stack.isEmpty()) {
                    resultCalc = stack.pop();
                } else {
                    // по умолчнию
                    resultCalc = 0;
                }

                rez.setText(String.valueOf(resultCalc));

                return;

            default:
                result = String.valueOf(rez.getText()).concat(buttonText);
        }

        rez.setText(result);
    }

    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // метод, который преобразует в постфиксную запись
    private String GetExpression(String input) {

        StringBuilder sb = new StringBuilder(); // изменяемая строка
        Stack<Character> op = new Stack<Character>(); // стек чаров
        char[] chars = input.toCharArray(); // входную строку в массив чаров

        int N = chars.length; // длина массива чаров

        // пробегаем массив чаров слева направо
        for (int i = 0; i < N; i++) {
            char ch = chars[i];

            if (Character.isDigit(chars[i])) {
                sb.append(chars[i]);
                //    sb.append(' ');
            } else if (ch == '(') {
                // левая скобка - помещаем в стек
                op.push(ch);
            } else if (ch == ')') {
                // правая скобка - берем все значения из стека до левой скобки
                while (op.peek() != '(') {
                    sb.append(op.pop());
                    //.append(' ');
                }
            } else if (IsOperator(ch)) {
                while (!op.isEmpty() && GetPriority(op.peek()) > GetPriority(ch)) {
                    sb.append(op.pop());
                    //.append(' ');
                }
                op.push(ch);
            }

        }

        while (!op.isEmpty()) {
            sb.append(op.pop());
            //.append(' ');
        }

        return sb.toString().replace('(',' ');
    }

    //метод, провеяет, если текущий символ - операция
    private static boolean IsOperator(char c) {
        if (("*/+-()^".indexOf(c) != -1)) {
            return true;
        } else {
            return false;
        }
    }

    // метод, возвращает приоритет оператора
    private static byte GetPriority(char c) {
        switch (c) {
            case '(':
                return 0;
            case ')':
                return 1;
            case '+':
                return 2;
            case '-':
                return 3;
            case '*':
                return 4;
            case '/':
                return 4;
            case '^':
                return 5;

            default:
                return 6;

        }
    }

}