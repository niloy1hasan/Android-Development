package com.example.edittext_practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plusButton;
    private Button minusButton;
    private TextView result;
    private EditText num1Input, num2Input;
    private View TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        plusButton = (Button) findViewById(R.id.plusBtn);
        minusButton = (Button) findViewById(R.id.minusBtn);
        result = (TextView) findViewById(R.id.output);
        num1Input = (EditText) findViewById(R.id.num1);
        num2Input = (EditText) findViewById(R.id.num2);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        try{
            String a = num1Input.getText().toString();
            String b = num2Input.getText().toString();

            double n1 = Double.parseDouble(a);
            double n2 = Double.parseDouble(b);

            if(v.getId()== R.id.plusBtn)
                result.setText(a + " + " + b + " = " + (n1+n2));
            else
                result.setText(a + " - " + b + " = " + (n1-n2));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Fill both input field", Toast.LENGTH_SHORT).show();
        }
    }
}