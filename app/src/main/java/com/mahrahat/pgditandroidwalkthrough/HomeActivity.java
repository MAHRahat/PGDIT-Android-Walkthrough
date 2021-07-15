package com.mahrahat.pgditandroidwalkthrough;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        Button createOpButton = findViewById(R.id.btnInsert);
        createOpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                EditText etRoll = findViewById(R.id.etRoll);
                String myRoll = etRoll.getText().toString();
                cv.put("roll", myRoll);
                cv.put("name", ((EditText) findViewById(R.id.etName)).getText().toString());
                cv.put("email", ((EditText) findViewById(R.id.etEmail)).getText().toString());
                cv.put("pass", ((EditText) findViewById(R.id.etPass)).getText().toString());
                itdb.insert(tableName, null, cv);
            }
        });
    }

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

}
