package com.mahrahat.pgditandroidwalkthrough;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AllInfo extends AppCompatActivity {

    ListView lvStList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_info);

        List<Student> studentList = new ArrayList<Student>();
        lvStList = findViewById(R.id.lvAllInfo);
        lvStList.setAdapter(new StudentAdapter(studentList, this.getApplicationContext()));

        SQLiteDatabase itdb = openOrCreateDatabase("walkthrough.db", MODE_PRIVATE, null);
        String tableName = "Student";

        Cursor cursor = itdb.query(tableName, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int readRoll = cursor.getInt(cursor.getColumnIndex("roll"));
            String readName = cursor.getString(cursor.getColumnIndex("name"));
            studentList.add(new Student(readRoll, readName));
        }
    }
}
