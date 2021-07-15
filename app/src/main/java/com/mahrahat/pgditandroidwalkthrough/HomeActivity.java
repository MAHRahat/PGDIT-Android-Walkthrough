package com.mahrahat.pgditandroidwalkthrough;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toast.makeText(this, "Greetings!", Toast.LENGTH_LONG).show();

//        Bundle bundle = getIntent().getExtras();
//        String s = bundle.getString("passed");
//        TextView tvHome = findViewById(R.id.tvHomeHead);
//        tvHome.setText(s);

        SQLiteDatabase itdb = openOrCreateDatabase("walkthrough.db", MODE_PRIVATE, null);
        String tableName = "Student";
        String createOp = "CREATE TABLE IF NOT EXISTS " +
                tableName +
                "(" +
                "roll int, " +
                "name text, " +
                "email text, " +
                "pass text" +
                ")";
        itdb.execSQL(createOp);
    }

}
