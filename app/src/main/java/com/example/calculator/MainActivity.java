package com.example.calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonEqual,
            buttonDecimal, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonDelete, buttonBackspace;

    EditText display;

    long mValue1, mValue2, result = 0;

    boolean mAddition, mSubtraction, mMultiplication, mDivision, mEqualpressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        //edittext
        display = findViewById(R.id.displayText);
        display.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                display.removeTextChangedListener(this);
                String originalString = s.toString();
                    try {
                        if(originalString.equals("")){
                            display.setText("0");
                        }
                        if(!mEqualpressed){
                            if(originalString.length() == 11){
                                Toast.makeText(getApplicationContext(), "Can't input more than 9 digits", Toast.LENGTH_SHORT).show();
                            }
                        }
                        Long longval;
                        if (originalString.contains(",")) {
                            originalString = originalString.replaceAll(",", "");
                        }
                        longval = Long.parseLong(originalString);

                        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                        formatter.applyPattern("###,###,###,###.###");
                        String formattedString = formatter.format(longval);
                        //setting text after format to EditText
                        display.setText(formattedString);
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                    }
                display.addTextChangedListener(this);
            }
        });
        //buttons
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonEqual = findViewById(R.id.buttonEqual);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        display.setTypeface(MMedium);
        button0.setTypeface(MLight);
        button1.setTypeface(MLight);
        button2.setTypeface(MLight);
        button3.setTypeface(MLight);
        button4.setTypeface(MLight);
        button5.setTypeface(MLight);
        button6.setTypeface(MLight);
        button7.setTypeface(MLight);
        button8.setTypeface(MLight);
        button9.setTypeface(MLight);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAfterSolved();
                display.setText(display.getText() + "9");
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                display.setText("0");
            }
        });
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedInput = display.getText().toString();
                int length = displayedInput.length();
                if(mEqualpressed != true) {
                    if (length > 0) {
                        displayedInput = displayedInput.substring(0, length - 1);
                        display.setText(displayedInput);
                    } else {
                        display.setText("0");
                    }
                }
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + ".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = convertStringToLong(display.getText().toString());
                //result += mValue1;
                setAfterSolved();
                mAddition = true;
                display.setText("0");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = convertStringToLong(display.getText().toString());
                //result -= mValue1;
                setAfterSolved();
                mSubtraction = true;
                display.setText("0");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = convertStringToLong(display.getText().toString());
                //result *= mValue1;
                setAfterSolved();
                mMultiplication = true;
                display.setText("0");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = convertStringToLong(display.getText().toString());
                //result /= mValue1
                setAfterSolved();
                mDivision = true;
                display.setText("0");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue2 = convertStringToLong(display.getText().toString());
                if(mAddition){
                    result = mValue1 + mValue2;
                    display.setText(String.valueOf(result));
                    mAddition = false;
                }
                if(mSubtraction){
                    result = mValue1 - mValue2;
                    display.setText(String.valueOf(result));
                    mSubtraction = false;
                }
                if(mMultiplication){
                    result = mValue1 * mValue2;
                    display.setText(String.valueOf(result));
                    mMultiplication = false;
                }
                if(mDivision){
                    if(mValue2 == 0){
                        Toast.makeText(getApplicationContext(), "Math Error: Divided by Zero", Toast.LENGTH_SHORT).show();
                        display.setText(R.string.mathError);
                    } else {
                        result = mValue1 / mValue2;
                        display.setText(String.valueOf(result));
                    }
                    mDivision = false;
                }
                if(result > 999999999){
                    //Toast.makeText(getApplicationContext(), "Number too big for calculator", Toast.LENGTH_SHORT).show();
                    NumberFormat format = new DecimalFormat("#.######E00");
                    display.setText(format.format(result));
                }
                mEqualpressed = true;
                result = 0;
            }
        });
    }
    public void setAfterSolved(){
        if(mEqualpressed){
            display.setText("0");
            mEqualpressed = false;
        }
    }
    public long convertStringToLong(String string){
        return Long.valueOf(string.replaceAll(",", ""));
    }
}
