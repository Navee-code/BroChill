package com.example.brochill

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class HomeViewModel : ViewModel() {
    val service = BaseUrl.getInstance().create(BroChillService::class.java)


    fun login(s: String, s1: String) {
        GlobalScope.launch(Dispatchers.IO) {
            var response = service.login(s, s1)
            var hello = response.body()
            withContext(Dispatchers.Main){

            }



        }


    }


}