package com.miguelaguilar.challenge.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.miguelaguilar.challenge.R
import com.miguelaguilar.challenge.databinding.ActivityDetailsBinding
import com.miguelaguilar.challenge.models.ResponseListBeers
import com.miguelaguilar.challenge.ui.viewModel.GeneralViewModel

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding
    private lateinit var generalViewModel: GeneralViewModel
    var beer = ResponseListBeers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        generalViewModel = ViewModelProviders.of(this)[GeneralViewModel::class.java]
        binding.viewModel = generalViewModel
        beer = (intent.getSerializableExtra("beer") ?: ResponseListBeers()) as ResponseListBeers

        setContent()

    }

    fun setContent(){
        binding.nombrebeer.text = getString(R.string.nombre, beer.name)
        binding.brewedTips.text = getString(R.string.brewedTips, beer.brewers_tips)
        Glide.with(this)
            .load(beer.image_url)
            .into(binding.imagenBeer)
        binding.descripcion.text = getString(R.string.descripcion, beer.description)
        binding.first.text = beer.first_brewed
        binding.tagline.text = beer.tagline
        /*var textosFood = listOf<String>()
        for((element, item) in beer.food_pairing?.withIndex() ?: listOf()){
            textosFood = listOf(item ?: "")
        }*/
        binding.food.text = beer.food_pairing.toString()
        var listaIng : String? = null
        for(item in beer.ingredients?.malt ?: listOf()){
            listaIng = "${item?.name}: ${item?.amount?.value.toString()} ${item?.amount?.unit }"
        }
        for(item in beer.ingredients?.hops ?: listOf()){
            listaIng = "${listaIng }\n${item?.name ?: ""}: ${item?.amount?.value.toString()} ${item?.amount?.unit}"
        }
        binding.ingredientes.text = listaIng

    }
}