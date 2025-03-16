package com.example.timepickerpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TimePicker selectTime;
    private Button showBtn;
    private TextView timeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showBtn = (Button) findViewById(R.id.timeShowButton);
        timeTxt = (TextView) findViewById(R.id.showTextid);
        selectTime = (TimePicker) findViewById(R.id.selectTimeID);


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = SelectTime();
                timeTxt.setText("Selected Time: " + time);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String SelectTime(){
        String time = selectTime.getCurrentHour() + ":" + selectTime.getCurrentMinute();
        return time;
    }
}