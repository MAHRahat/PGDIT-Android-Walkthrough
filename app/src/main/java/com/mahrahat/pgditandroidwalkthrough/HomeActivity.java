package com.mahrahat.pgditandroidwalkthrough;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

        String[] stringOfEmails = new String[]{
                "akash@du.ac.bd",
                "batash@du.ac.bd",
                "chameli@du.ac.bd",
                "dola@du.ac.bd",
                "einstein@du.ac.bd",
                "feynman@du.ac.bd",
                "hazi@du.ac.bd",
                "gazi@du.ac.bd",
                "fountaein@yandex.com"
        };
        AutoCompleteTextView actv = findViewById(R.id.actvEmail);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringOfEmails);
        actv.setAdapter(aa);

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
                cv.put("email", ((AutoCompleteTextView) findViewById(R.id.actvEmail)).getText().toString());
                cv.put("pass", ((EditText) findViewById(R.id.etPass)).getText().toString());
                itdb.insert(tableName, null, cv);
            }
        });

        Button readOpButton = findViewById(R.id.btnQuery);
        readOpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String[] columns = new String[]{"name", "email"};
                String whereClause = "roll = ?";
                String[] whereArgs = new String[]{((EditText) findViewById(R.id.etRoll)).getText().toString()};
                String groupBy = null;
                String having = null;
                String orderBy = null;
                String limit = null;
                Cursor cursor = itdb.query(tableName,
                        columns,
                        whereClause,
                        whereArgs,
                        groupBy,
                        having,
                        orderBy,
                        limit);
                while (cursor.moveToNext()) {
                    String readName = cursor.getString(cursor.getColumnIndex("name"));
                    String readEmail = cursor.getString(cursor.getColumnIndex("email"));
                    showToast("Name: " + readName + ", Email: " + readEmail);
                }
            }
        });

        Button updateOpButton = findViewById(R.id.btnUpdate);
        updateOpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", ((EditText) findViewById(R.id.etName)).getText().toString());
                String whereClause = "roll = ?";
                String[] whereArgs = new String[]{((EditText) findViewById(R.id.etRoll)).getText().toString()};
                itdb.update(tableName,
                        contentValues,
                        whereClause,
                        whereArgs);
            }
        });

        Button deleteOpButton = findViewById(R.id.btnDelete);
        deleteOpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String whereClause = "roll = ?";
                String[] whereArgs = new String[]{((EditText) findViewById(R.id.etRoll)).getText().toString()};
                itdb.delete(tableName, whereClause, whereArgs);
            }
        });

        Button btnShowAllInfo = findViewById(R.id.btnShowAll);
        btnShowAllInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AllInfo.class));
            }
        });
    }

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

}
