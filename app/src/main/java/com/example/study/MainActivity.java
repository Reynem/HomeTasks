package com.example.study;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView resultView;
    private EditText number_field_1;
    private EditText number_field_2;
    private Button getsum;
    private Button getsubs;
    private Button getmultip;
    private Button getdivision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultView = findViewById(R.id.maintitle);
        number_field_1 = findViewById(R.id.editTextText);
        number_field_2 = findViewById(R.id.editTextText2);
        getsum = findViewById(R.id.sum);
        getsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 + num2;
                resultView.setText(String.valueOf(res));
            }
        });
        getsubs = findViewById(R.id.diff);
        getsubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 - num2;
                resultView.setText(String.valueOf(res));
            }
        });
        getmultip = findViewById(R.id.Multiplication);
        getmultip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 * num2;
                resultView.setText(String.valueOf(res));
            }
        });
        getdivision = findViewById(R.id.diff2);
        getdivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 / num2;
                resultView.setText(String.valueOf(res));
            }
        });

    }
}