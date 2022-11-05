package com.example.brochill

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject


class HomeViewModel : ViewModel() {
   private val service = BaseUrl.getInstance().create(BroChillService::class.java)


    fun login(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
             service.login(email, password)
            withContext(Dispatchers.Main){

            }
        }
    }
    fun register(firstName: String, lastName: String, email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataRegisterModel(firstName,lastName,email,password)
            val jsonObj = JSONObject()
            jsonObj.put("first_name",firstName )
            jsonObj.put("last_name",lastName)
            jsonObj.put("email",email )
            jsonObj.put("password",password)

          var sell= service.register(dataModal)
            withContext(Dispatchers.Main){
                  var work=sell.body()
                Log.e("TAG",work?.token.toString())

            }
        }

    }


}