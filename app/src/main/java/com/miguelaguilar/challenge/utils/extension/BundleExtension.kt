package com.miguelaguilar.challenge.utils.extension

import android.os.Bundle
import org.json.JSONObject

fun Bundle.getJson() : String {
    val jsonObject = JSONObject()
    for (key in this.keySet()) {
        try {
            jsonObject.put(key, JSONObject.wrap(this.get(key)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    return jsonObject.toString()
}