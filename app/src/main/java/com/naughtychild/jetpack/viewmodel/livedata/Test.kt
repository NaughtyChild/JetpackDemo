package com.naughtychild.jetpack.viewmodel.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


class TransMapViewModel: ViewModel() {
    val userLivedata = MutableLiveData<User>()

    val mapLiveData = Transformations.map(userLivedata){
        "${it.name} : ${it.age}"//这里可以返回任意类型的数据
    }
    val mapLiveData1 = Transformations.switchMap(userLivedata) {
        changeUser(it!!)
    }
    private fun changeUser(it: User): LiveData<String> {
        return MutableLiveData("${it.name}  的名字杜甫知道")
    }
    fun sendData() {
        userLivedata.value=User("李白",1200)//对userLivedata进行复制
    }
}
data class SwitchUser(var name: String, var age: Int)
data class User(var name:String,var age:Int)