package com.example.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    Button btLogout;
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        init();

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string="Successfully Logged Out";
                Intent intent=getIntent();
                intent.putExtra("message", string);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void init() {
        btLogout=findViewById(R.id.btLogout);
    }


}
