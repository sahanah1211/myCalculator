package com.spr.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.function.DoubleConsumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC,
    btnDel, btnDivision, btnMultiplication, btnSubtraction, btnAddition, btnEqual, btnDot;

    private boolean dot_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                displayOne();
            }
        });
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                displayOne();
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                displayOne();
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                displayOne();
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                displayOne();
            }
        });
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                displayOne();
            }
        });
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                displayOne();
            }
        });
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                displayOne();
            }
        });
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                displayOne();
            }
        });
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                displayOne();
            }
        });
        btnAC = (Button) findViewById(R.id.btnAC);
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backSpace();
                displayOne();
            }
        });
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set dot_inserted = false
                dot_inserted = false;

                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is not dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backSpace();
                    }

                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " ÷ ";
                        operator_inserted = true;
                    }
                }
                //displayOne
                displayOne();
            }
        });
        btnMultiplication = (Button) findViewById(R.id.btnTimes);
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set dot_inserted = false
                dot_inserted = false;

                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is not dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backSpace();
                    }

                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " × ";
                        operator_inserted = true;
                    }
                }
                //displayOne
                displayOne();
            }
        });
        btnSubtraction = (Button) findViewById(R.id.btnMinus);
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set dot_inserted = false
                dot_inserted = false;

                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is not dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backSpace();
                    }

                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                //displayOne
                displayOne();
            }
        });
        btnAddition = (Button) findViewById(R.id.btnPlus);
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set dot_inserted = false
                dot_inserted = false;

                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is not dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backSpace();
                    }

                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                //displayOne
                displayOne();
            }
        });
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the last digit is not an operator
                if (operator_inserted == true && !curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)) {
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '×':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
        btnDot = (Button) findViewById(R.id.btnDot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if it's empty => append "0." and set dot_inserted variable to true
                if(curr.isEmpty()) {
                    curr = "0.";
                    dot_inserted = true;
                }
                // check if dot_inserted == false => append "."
                if (dot_inserted == false) {
                    curr = curr + ".";
                    dot_inserted = true;
                }
                displayOne();
            }
        });

    }

    public void displayOne () {
        calculation.setText(curr);
    }

    public void displayTwo () {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public void backSpace() {
        //if curr is not empty => remove last char
        if (!curr.isEmpty()) {
            // check if the dot is the last char in curr => set dot_inserted = false
            if (curr.substring(curr.length()-1, curr.length()).equals(".")) {
                dot_inserted = false;
            }

            //if the operator is detected => delete three digits or chars from the curr & set operation_inserted = false
            if (curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            } else {
                curr = curr.substring(0, curr.length()-1);
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}