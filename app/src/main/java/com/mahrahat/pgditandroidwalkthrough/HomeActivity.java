package com.mahrahat.pgditandroidwalkthrough;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvHome = findViewById(R.id.tvHomeHead);
        tvHome.setText("Hello");
    }
}
