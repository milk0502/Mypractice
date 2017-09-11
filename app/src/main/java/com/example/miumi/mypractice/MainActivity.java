package com.example.miumi.mypractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    View.OnClickListener buttonLitener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            textView.setText(editText.getText().toString());

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv);
        editText = (EditText) findViewById(R.id.edittext);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(buttonLitener);

        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_add).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_subtract).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_multiply).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_divide).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_equal).setOnClickListener(buttonNumberListener);

    }
    int recentoperater=R.id.button_equal;
    double result;
    boolean isOperatorKeyPushed; //計算キーが押されたことを記憶

    View.OnClickListener buttonOperatorListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            double value = Double.parseDouble(editText.getText().toString());//Double.parseDobleは文字列型をダブル型に変換する
            if (recentoperater == R.id.button_equal) {
                result = value;
            } else {
                result = calc(recentoperater, result, value);
                editText.setText(String.valueOf(result));
            }
            recentoperater = operatorButton.getId();
            textView.setText((operatorButton.getText()));
            isOperatorKeyPushed = true;
        }
    };


    View.OnClickListener buttonNumberListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
        if(isOperatorKeyPushed==true){
            editText.setText(button.getText());
        }else{
            editText.setText(button.getText());
        }isOperatorKeyPushed=false;

        }
    };

    View.OnClickListener buttonLitener=new View.OnClickListener(){
        @Override
        public void onClick(View view){
            recentoperater=R.id.button_equal;
            result=0;
            isOperatorKeyPushed=false;

            textView.setText("");
            editText.setText("");
        }
    };
    }
