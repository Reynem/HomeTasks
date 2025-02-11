package com.example.study;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    TextView logoText;
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
        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button3);
        Button nextActivity = findViewById(R.id.button4);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(nextActivity);
            }
        });
        logoText = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoAlert("Хотите закрыть наше приложение? 💔");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(((Button) view).getText().toString(), ((Button) view));
            }
        });


    }

    public void buttonTag(View view){

    }
    public void showInfo(String text, Button button){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        button.setText("Уже нажали");
    }

    private void showInfoAlert(String text){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Крутой текст")
                .setMessage("Привет зачетный парень")
                .setCancelable(false) // Можно ли закрыть
                .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("GET OUT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void startNewActivity(View view){
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);

    }
}