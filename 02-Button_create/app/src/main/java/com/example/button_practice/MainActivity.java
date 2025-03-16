package com.example.button_practice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private Button signUpBtn;
    private TextView massageTxt;
    private View TextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.logInButton);
        signUpBtn = findViewById(R.id.signUpButton);
        massageTxt = findViewById(R.id.massageText);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void showloginMassage(View v){
        if (v.getId() == R.id.logInButton){
            Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
            Log.d("tag", "log in successfully");
            massageTxt.setText("log in successfully");
        }

        if (v.getId() == R.id.signUpButton){
            Toast toast = Toast.makeText(MainActivity.this, "Sign up Successfully", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            massageTxt.setText("Sign up successfully");
        }

    }

}