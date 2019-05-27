package com.example.mvpdemo;

import android.view.View;
import android.widget.Toast;

public class ButtonClickListener extends LoginScreen implements View.OnClickListener {
    LoginScreen loginScreen =new LoginScreen();
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btLogin:
                onAuthSuccess();
                Toast.makeText(loginScreen, "Hi", Toast.LENGTH_SHORT).show();
        }
    }
}
