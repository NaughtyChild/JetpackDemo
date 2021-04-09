package com.naughtychild.jetpack.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.naughtychild.jetpack.R;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        myDatabase = MyDatabase.getInstance(RoomActivity.this);
        Button insertStudentBt = findViewById(R.id.insert_student_bt);
        insertStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        myDatabase.studentDao().insertStudent(new Student("张三", "24"));
                        Log.d("RoomActivity", "onClick: 插入张三");
                    }
                }.start();
            }
        });
        Button queryStudentBt = findViewById(R.id.query_Student_bt);
        queryStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        List<Student> student = myDatabase.studentDao().getStudent();
                        Log.d("RoomActivity", "onClick: 查询张三"+student.size());
                    }
                }.start();
            }
        });
    }
}