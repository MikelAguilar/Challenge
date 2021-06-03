package com.miguelaguilar.challenge.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.miguelaguilar.challenge.base.BaseViewModel
import com.miguelaguilar.challenge.injection.network.AppAPI
import com.miguelaguilar.challenge.models.*
import com.miguelaguilar.challenge.ui.adapters.BeersAdapterlist
import com.squareup.moshi.Json
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okio.BufferedSink
import org.json.JSONArray
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import javax.inject.Inject


class GeneralViewModel : BaseViewModel() {
    @Inject
    lateinit var appAPI: AppAPI
    private var subscription: Disposable? = null

    val responseGetBeers : MutableLiveData<JsonArray> = MutableLiveData()
    val beerAdapter : BeersAdapterlist = BeersAdapterlist()

    fun getBeers() {
        subscription = appAPI.getBeers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveInfoStart() }
            .doOnTerminate { onRetrieveInfoFinish() }
            .subscribe(
                { r -> responseGetBeers.value = r },
                { error -> onRetrieveInfoError(error.localizedMessage) }
            )
    }
}