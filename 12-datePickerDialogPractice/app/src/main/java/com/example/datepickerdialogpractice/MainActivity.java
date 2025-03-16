package com.example.datepickerdialogpractice;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button selectBtn;
    private TextView dateTxt;
    private DatePickerDialog datePickerDialog;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        selectBtn = (Button) findViewById(R.id.selectButton);
        dateTxt = (TextView) findViewById(R.id.dateId);

        selectBtn.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }




    @Override
    public void onClick(View v) {
        DatePicker datePicker = new DatePicker(this);

        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = datePicker.getMonth()+1;
        int currentYear = datePicker.getYear();
        datePickerDialog = new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTxt.setText("Selected Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
            }
        }

        , currentYear, currentMonth, currentDay);


        datePickerDialog.show();


    }
}