package com.example.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.text);
        //textView.setText(R.string.userName);

        TextView textView1=findViewById(R.id.text1);
        //textView1.setText(R.string.passWord);

        EditText editText=findViewById(R.id.userName);
        EditText editText1=findViewById(R.id.passWord);

        String lang=Locale.getDefault().getISO3Language();

        //Toast.makeText(this, lang, Toast.LENGTH_SHORT).show();

        switch (lang){
            case "eng":
                textView.setText("User Name");
                textView1.setText("Password");
                editText.setHint("Enter your Username");
                editText1.setHint("Enter your Password");
                break;
            case "spa":
                textView.setText("Nombre de usuario");
                textView1.setText("Contraseña");
                editText.setHint("Ingrese su nombre de usuario");
                editText1.setHint("Ingresa tu contraseña");
                break;
            case "fra":
                textView.setText("Nom d'utilisateur");
                textView1.setText("passWord");
                editText.setHint("Entrez votre nom d'utilisateur");
                editText1.setHint("Tapez votre mot de passe");
                break;
            default:
                textView.setText("User Name");
                textView1.setText("Password");
                editText.setHint("Enter your Username");
                editText1.setHint("Enter your Password");
                break;
        }
    }
}
