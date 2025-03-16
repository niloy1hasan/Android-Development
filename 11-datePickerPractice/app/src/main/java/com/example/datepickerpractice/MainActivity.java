package com.example.datepickerpractice;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private TextView selectDate;
    private Button selectBtn;
    private DatePicker date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        selectBtn = (Button) findViewById(R.id.selectButton);
        selectDate = (TextView) findViewById(R.id.currentDateID);
        date = (DatePicker) findViewById(R.id.datePickerID);

        selectDate.setText("Current Date: " + currentDate());

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate.setText("Current Date: " + currentDate());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    String currentDate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date.getDayOfMonth() + "/" + (date.getMonth()+1) + "/" + date.getYear());
        return  stringBuilder.toString();
    }
}