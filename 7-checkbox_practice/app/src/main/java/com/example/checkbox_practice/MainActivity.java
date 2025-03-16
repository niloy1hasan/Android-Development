package com.example.checkbox_practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public Button showBtn;
    public CheckBox milkCheck, breadCheck, buiskitCheck, eggCheck;
    private TextView showTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showBtn = (Button) findViewById(R.id.showButton);
        milkCheck = (CheckBox) findViewById(R.id.milkcheck);
        breadCheck = (CheckBox) findViewById(R.id.breadcheck);
        buiskitCheck = (CheckBox) findViewById(R.id.buiskitcheck);
        eggCheck = (CheckBox) findViewById(R.id.eggcheck);
        showTxt = (TextView) findViewById(R.id.resultTxt);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if(milkCheck.isChecked()){
                    String value = milkCheck.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }

                if(breadCheck.isChecked()){
                    String value = breadCheck.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }
                if(buiskitCheck.isChecked()){
                    String value = buiskitCheck.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }
                if(eggCheck.isChecked()){
                    String value = eggCheck.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }

                showTxt.setText(stringBuilder);

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}