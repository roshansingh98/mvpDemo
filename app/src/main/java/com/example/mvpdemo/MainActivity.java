package com.example.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.text);
        textView.setText(R.string.userName);

        TextView textView1=findViewById(R.id.text1);
        textView1.setText(R.string.passWord);
    }
}
