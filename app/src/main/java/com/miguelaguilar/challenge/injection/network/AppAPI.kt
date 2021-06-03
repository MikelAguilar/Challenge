package com.miguelaguilar.challenge.injection.network

import com.google.gson.JsonArray
import com.miguelaguilar.challenge.models.*
import io.reactivex.Observable
import org.json.JSONArray
import retrofit2.http.*

import retrofit2.http.POST
import java.io.Serializable

interface AppAPI {
    @GET("beers?page=10")
    fun getBeers(): Observable<JsonArray>
}