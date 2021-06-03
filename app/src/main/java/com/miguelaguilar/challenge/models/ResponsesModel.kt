package com.miguelaguilar.challenge.models

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseListBeers(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("first_brewed")
    val first_brewed: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image_url")
    val image_url: String? = null,
    @SerializedName("abv")
    val abv: Int? = null,
    @SerializedName("ibu")
    val ibu: Int? = null,
    @SerializedName("target_fg")
    val target_fg: Int? = null,
    @SerializedName("target_og")
    val target_og: Int? = null,
    @SerializedName("ebc")
    val ebc: Int? = null,
    @SerializedName("srm")
    val srm: Double? = null,
    @SerializedName("ph")
    val ph: Double? = null,
    @SerializedName("attenuation_level")
    val attenuation_level: Double? = null,
    @SerializedName("volume")
    val volume: GenericValuesModel? = null,
    @SerializedName("boil_volume")
    val boil_volume: GenericValuesModel? = null,
    @SerializedName("method")
    val method: MethodModel? = null,
    @SerializedName("ingredients")
    val ingredients: IngredientsModel? = null,
    @SerializedName("food_pairing")
    val food_pairing: List<String?>? = null,
    @SerializedName("brewers_tips")
    val brewers_tips: String? = null
) : Serializable

data class GenericValuesModel(
    @SerializedName("value")
    val value: Int? = null,
    @SerializedName("unit")
    val unit: String? = null,
) : Serializable

data class MethodModel(
    @SerializedName("mash_temp")
    val mash_temp: List<MashTempModel?>? = null,
    @SerializedName("fermentation")
    val fermentation: MashTempModel? = null,
    @SerializedName("twist")
    val twist: String? = null
) : Serializable

data class IngredientsModel(
    @SerializedName("malt")
    val malt: List<MaltModel?>? = null,
    @SerializedName("hops")
    val hops: List<HopsModel?>? = null,
    @SerializedName("yeast")
    val yeast: String? = null
) : Serializable

data class MashTempModel(
    @SerializedName("temp")
    val temp: GenericValuesModel? = null,
    @SerializedName("duration")
    val duration: Int? = null
) : Serializable

data class MaltModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("amount")
    val amount: GenericValuesModel,
) : Serializable

data class HopsModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("amount")
    val amount: GenericValuesModel,
    @SerializedName("add")
    val add: String? = null,
    @SerializedName("attribute")
    val attribute: String? = null
) : Serializable