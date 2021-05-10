package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cacttuseducation2020_2021.R;

public class CalculatorActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPoint, buttonClear, buttonEqual,
    buttonAdd, buttonSub, buttonMultiplication, buttonDivision;

    ImageView ivBack;
    EditText editText;

    float valueOne, valueTwo;

    boolean isAddition, isSub, isMultiplication, isDivision;

    ConstraintLayout clPopupContainer;
    Button btnOk, btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        findViews();
        onClicks();
    }

    private void onClicks() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().length()>0) {
                    valueOne = Float.parseFloat(editText.getText().toString());
                    isAddition = true;
                    editText.setText(null);
                }

            }
        });


        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length()>0) {
                    valueOne = Float.parseFloat(editText.getText().toString());
                    isSub = true;
                    editText.setText(null);
                }

            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length()>0) {
                    valueOne = Float.parseFloat(editText.getText().toString());
                    isMultiplication = true;
                    editText.setText(null);
                }

            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length()>0) {
                    valueOne = Float.parseFloat(editText.getText().toString());
                    isDivision = true;
                    editText.setText(null);
                }

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueTwo = Float.parseFloat(editText.getText().toString());

                if (isAddition){
                    editText.setText(valueOne + valueTwo + "");
                    isAddition = false;
                }else if (isSub){
                    editText.setText(valueOne - valueTwo + "");
                    isSub = false;
                }else if (isMultiplication){
                    editText.setText(valueOne * valueTwo + "");
                    isMultiplication = false;
                }else if (isDivision){
                    editText.setText(valueOne / valueTwo + "");
                    isDivision = false;
                }

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clPopupContainer.setVisibility(View.GONE);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clPopupContainer.setVisibility(View.GONE);
            }
        });

        clPopupContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clPopupContainer.setVisibility(View.GONE);
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void findViews() {
        button0 = findViewById(R.id.btnZero);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonClear = findViewById(R.id.btnClear);
        buttonAdd = findViewById(R.id.btnAddition);
        buttonMultiplication = findViewById(R.id.btnMultiplication);
        buttonDivision = findViewById(R.id.btnDivision);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonPoint = findViewById(R.id.btnPoint);
        buttonSub = findViewById(R.id.btnSubtraction);
        editText = findViewById(R.id.etResult);
        clPopupContainer = findViewById(R.id.popUpContainer);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        ivBack = findViewById(R.id.ivBack);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        clPopupContainer.setVisibility(View.VISIBLE);


    }


}