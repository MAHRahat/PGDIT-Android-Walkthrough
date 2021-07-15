package com.mahrahat.pgditandroidwalkthrough;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.tvWelcome);
                String str = tv.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("passed", str);
                startActivity(intent);
            }
        });
    }
}
