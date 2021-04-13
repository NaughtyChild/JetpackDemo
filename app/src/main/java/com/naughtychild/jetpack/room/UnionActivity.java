package com.naughtychild.jetpack.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.naughtychild.jetpack.R;

import java.util.List;

public class UnionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union);
        StudentViewModel studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        studentViewModel.getListLiveData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                for (Student student : students) {
                    Log.d("UnionActivity", "onChanged: " + student);
                }
            }
        });
    }
}