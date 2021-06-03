package com.miguelaguilar.challenge.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelaguilar.challenge.ui.viewModel.GeneralViewModel
import com.miguelaguilar.challenge.injection.component.DaggerViewModelInjector
import com.miguelaguilar.challenge.injection.component.ViewModelInjector
import com.miguelaguilar.challenge.injection.module.NetworkModule

abstract class BaseViewModel : ViewModel() {
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    private val enabledElement: MutableLiveData<Boolean> = MutableLiveData()
    val enableAction : MutableLiveData <Boolean> = MutableLiveData()

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
        loadingVisibility.value = View.GONE
        errorMessage.value = null
        enabledElement.value = true
    }

    private fun inject() {
        when (this) {
            is GeneralViewModel -> injector.inject(this)
        }
    }

    protected fun onRetrieveInfoStart() {
        loadingVisibility.value = View.VISIBLE
        enabledElement.value = false
        enableAction.value = false
        errorMessage.value = null
    }

    protected fun onRetrieveInfoFinish() {
        loadingVisibility.value = View.GONE
        enabledElement.value = true
        enableAction.value = true
    }

    protected fun onRetrieveInfoError(error: String?) {
        errorMessage.value = error
    }

}