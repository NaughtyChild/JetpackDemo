package com.naughtychild.jetpack.room;
import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
public class StudentViewModel extends AndroidViewModel {
    private MyDatabase myDatabase;
    private LiveData<List<Student>> listLiveData;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        myDatabase = MyDatabase.getInstance(application);
        listLiveData = myDatabase.studentDao().getStudentLiveData();
    }
    public LiveData<List<Student>> getListLiveData() {
        return listLiveData;
    }
    public void setListLiveData(LiveData<List<Student>> listLiveData) {
        this.listLiveData = listLiveData;
    }
}
