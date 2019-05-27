package com.example.mvpdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registerPage extends AppCompatActivity {

    private EditText etUsername;
    private EditText etSurname;
    private EditText etPassword;
    private EditText etEmail;

    private Button btRegister;

    private String stUsername;
    private String stSurname;
    private String stEmail;
    private String stPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        init();
    }

    private void init(){
        etUsername=findViewById(R.id.etUsername);
        etSurname=findViewById(R.id.etSurname);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btRegister=findViewById(R.id.btRegister);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("User Data",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("Username",stUsername);
                editor.putString("Surname",stSurname);
                editor.putString("Email",stEmail);
                editor.putString("Password",stPassword);
                editor.putString("Logged in","False");
                editor.apply();

//                String val=sharedPreferences.getString("Logged in",null);
//                Toast.makeText(registerPage.this, val, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });
    }

    //to convert the input values to string
    private void convert(){
        stUsername=etUsername.getText().toString();
        stSurname=etSurname.getText().toString();
        stEmail=etEmail.getText().toString();
        stPassword=etPassword.getText().toString();
    }
}
