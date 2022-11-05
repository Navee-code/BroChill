package com.example.brochill


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val registerCredential: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginCredential: MutableLiveData<LoginResponse> = MutableLiveData()
    val tweetCreated: MutableLiveData<CreateTweetModel> = MutableLiveData()
    val getAllTweets: MutableLiveData<ResponseGetTweets> = MutableLiveData()


    fun login(email: String, password: String) {
        val service = BaseUrl.getInstance(" ").create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataLogin(email, password)
            var response = service.login(dataModal)
            loginCredential.postValue(response.body())
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String) {
        val service = BaseUrl.getInstance(" ").create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataRegisterModel(firstName, lastName, email, password)
            var response = service.register(dataModal)
            registerCredential.postValue(response.body())
        }
    }
    fun createTweet(token: String?, message: String) {
        val service = BaseUrl.getInstance(token).create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataCreateTweet(message)
            service.createTweet(dataModal)
        }
    }
    fun getTweets(token:String?){
        val service = BaseUrl.getInstance(token).create(BroChillService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            var response=service.getTweet()

            getAllTweets.postValue(response.body())
        }

    }
}

