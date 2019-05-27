package com.example.mvpdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView tvUsername;
    private TextView tvPassword;
    private TextView tvRegister;

    private EditText etUsername;
    private EditText etPassword;

    private String lang;
    private String stUsername;
    private String stPassword;

    private Button btLogin;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String AUTH_STATUS = "AuthStatus";
    private final String USER_DATA = "UserData";
    private final String USER_NAME = "abc";
    private final String USER_PWD = "abc";

    private final int request_code=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListeners();
        checkSharedPrefs();
    }

    @Override
    protected void onResume() {
        super.onResume();

        lang = Locale.getDefault().getISO3Language();

        switch (lang) {
            case "eng":
                setTextValue("User Name", "Password", "Enter your Username", "Enter Your Password");
                break;
            case "spa":
                setTextValue("Nombre de usuario", "Contraseña", "Ingrese su nombre de usuario", "Ingresa tu contraseña");
                break;
            case "fra":
                setTextValue("Nom d'utilisateur", "Mot de passe", "Entrez votre nom d'utilisateur", "Tapez votre mot de passe");
                break;
            default:
                setTextValue("User Name", "Password", "Enter your Username", "Enter Your Password");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btLogin){
            onAuthSuccess();
        }else if(v == tvRegister){
            showRegistrationPage();
        }
    }

     void onAuthSuccess() {
        if(verifyDetails()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    editor.putBoolean(AUTH_STATUS, true);
                    editor.apply();
                }
            }).start();

            Intent intent = new Intent(getApplicationContext(), MainScreen.class);
            startActivityForResult(intent,request_code);

        }else{
            showToast("Invalid user name or password");
        }
    }


    //abstract inheritance interface

    //common place to initialize
    private void init() {
        tvUsername = findViewById(R.id.userNam);
        tvPassword = findViewById(R.id.passWor);
        tvRegister = findViewById(R.id.tvRegister);
        etUsername = findViewById(R.id.userName);
        etPassword = findViewById(R.id.passWord);
        btLogin = findViewById(R.id.btLogin);
        preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);
        editor = preferences.edit();
    }

    private void initListeners() {
        btLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    //common place to setText
    public void setTextValue(String tvUser, String tvPass, String etUser, String etPass) {
        tvUsername.setText(tvUser);
        tvPassword.setText(tvPass);
        etUsername.setHint(etUser);
        etPassword.setHint(etPass);
    }

    private boolean verifyDetails() {
        return USER_NAME.equals(etUsername.getText().toString())
                && USER_PWD.equals(etPassword.getText().toString());
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    //return true if verification is successful
    private boolean verifyAuthStatus() {
        return preferences.getBoolean(AUTH_STATUS, false);
    }

    private void showRegistrationPage() {
        Intent intent = new Intent(getApplicationContext(), registerPage.class);
        startActivity(intent);
    }

    private void checkSharedPrefs() {
        if (verifyAuthStatus()) {
            Intent intent = new Intent(getApplicationContext(), MainScreen.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==requestCode){
            if(resultCode==RESULT_OK){
                String logout_message=data.getStringExtra("message");
                Toast.makeText(this, logout_message, Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        editor.putBoolean(AUTH_STATUS, false);
                        editor.apply();
                    }
                }).start();
            }
            else if (resultCode==RESULT_CANCELED)
                Toast.makeText(this, "Logout Failed", Toast.LENGTH_SHORT).show();
        }
    }
    //Todo 1. use manifest one time history option 2. use startActivityForResult 3.create a clicklistener is separate class

}