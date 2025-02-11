package com.example.study;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        nextActivity.setOnClickListener(v -> startNewActivity(nextActivity));
        logoText = findViewById(R.id.textView);
        btn.setOnClickListener(v -> showInfoAlert());
        btn1.setOnClickListener(view -> showInfo(((Button) view).getText().toString(), ((Button) view)));


    }

    public void buttonTag(View view){

    }
    public void showInfo(String text, Button button){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        button.setText("Уже нажали");
    }

    private void showInfoAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("text")
                .setMessage("Хотите закрыть наше приложение? 💔")
                .setCancelable(false) // Можно ли закрыть
                .setPositiveButton("Yeah", (dialog, which) -> dialog.cancel())
                .setNegativeButton("GET OUT", (dialog, which) -> finish());
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void startNewActivity(View view){
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);

    }
}