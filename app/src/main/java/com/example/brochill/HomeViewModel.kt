package com.example.brochill


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class HomeViewModel : ViewModel() {
    private val service = BaseUrl.getInstance().create(BroChillService::class.java)
    val registerCredential: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginCredential: MutableLiveData<LoginResponse> = MutableLiveData()

    fun login(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataLogin(email, password)
            var response = service.login(dataModal)
            loginCredential.postValue(response.body())
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val dataModal = DataRegisterModel(firstName, lastName, email, password)
            var response = service.register(dataModal)
            registerCredential.postValue(response.body())
        }


    }
}