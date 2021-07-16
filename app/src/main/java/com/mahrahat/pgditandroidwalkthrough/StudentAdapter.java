package com.mahrahat.pgditandroidwalkthrough;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private final List<Student> students;
    Context context;

    public StudentAdapter(List<Student> students, Context context) {
        super(context, R.layout.activity_all_info, students);
        this.context = context;
        this.students = students;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.list_student, parent, false);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.roll.setText(student.getRoll());
        viewHolder.name.setText(student.getName());
        return convertView;
    }

    private static class ViewHolder {
        TextView roll, name;
    }
}
