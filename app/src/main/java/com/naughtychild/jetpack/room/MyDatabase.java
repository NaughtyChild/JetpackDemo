package com.naughtychild.jetpack.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "my_db";
    private static MyDatabase myDatabase;
    public static synchronized MyDatabase getInstance(Context mContext) {
        if (myDatabase == null) {
            myDatabase = Room.databaseBuilder(mContext.getApplicationContext(), MyDatabase.class, DATABASE_NAME).build();
        }
        return myDatabase;
    }
    public abstract StudentDao studentDao();
}
