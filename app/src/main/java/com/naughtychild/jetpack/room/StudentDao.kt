package com.naughtychild.jetpack.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student: Student )

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("select * from Student")
    fun getStudent(): List<Student>


    @Query("select * from Student")
    fun getStudentLiveData():LiveData<List<Student>>

    @Query("select * from Student where id=:id")
    fun getStudentById(id: Int): Student
}