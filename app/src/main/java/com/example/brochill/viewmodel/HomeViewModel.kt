package com.example.brochill.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brochill.api.BaseUrl
import com.example.brochill.api.BroChillService
import com.example.brochill.dataclass.DataCreateTweet
import com.example.brochill.dataclass.DataLogin
import com.example.brochill.dataclass.DataRegisterModel
import com.example.brochill.response.WelcomeData
import com.example.brochill.response.LoginResponse
import com.example.brochill.response.ResponseGetTweets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var credentials: MutableLiveData<String> = MutableLiveData()
    val registerCredential: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginCredential: MutableLiveData<LoginResponse> = MutableLiveData()
    val getAllTweets: MutableLiveData<ResponseGetTweets> = MutableLiveData()
    val welcome: MutableLiveData<WelcomeData?> = MutableLiveData()
    val login:MutableLiveData<String> = MutableLiveData()
    val userRegistered :MutableLiveData<String> = MutableLiveData()


    fun login(email: String, password: String) {
        val service = BaseUrl.getInstance(" ").create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataLogin(email, password)
            var response = service.login(dataModal)
            if(response.isSuccessful) {
                if (response.body() != null) {
                    loginCredential.postValue(response.body())
                } else {
                    credentials.postValue("bad")
                }
            }
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String) {
        val service = BaseUrl.getInstance(" ").create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataRegisterModel(firstName, lastName, email, password)
            var response = service.register(dataModal)
            if(response.isSuccessful) {
                if (response.body() != null) {
                    registerCredential.postValue(response.body())
                } else {
                    userRegistered.postValue("registered")
                }
            }

        }
    }
    fun createTweet(token: String?, message: String) {
        val service = BaseUrl.getInstance(token).create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataCreateTweet(message)
            service.createTweet(dataModal)
        }
    }
    fun getTweets(token:String?) {
        val service = BaseUrl.getInstance(token).create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            var response = service.getTweet()
            if(response.isSuccessful) {
                getAllTweets.postValue(response.body())
            }
        }

    }
    fun getWelcome(token:String?){
        if(token?.isNotEmpty()!!){
            val service = BaseUrl.getInstance(token).create(BroChillService::class.java)
            GlobalScope.launch(Dispatchers.IO) {

                var response=service.getWelcome()

                if(response.isSuccessful){
                    var server= response.body()
                    welcome.postValue(server)
                }


            }
        }else{
            login.postValue("log")

        }


    }
}

