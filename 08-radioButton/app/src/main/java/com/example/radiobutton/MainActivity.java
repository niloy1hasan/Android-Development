package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton genderBtn;
    private RadioGroup genderGroup;
    private Button showBtn;
    private TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showBtn = (Button)  findViewById(R.id.showBtnId);
        resultTxt = (TextView) findViewById(R.id.resultTxt);
        genderGroup = (RadioGroup) findViewById(R.id.radioGroupId);


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = genderGroup.getCheckedRadioButtonId();
                genderBtn = (RadioButton) findViewById(selectedId);
                String str = genderBtn.getText().toString();
                resultTxt.setText("Gender: " + str);

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}