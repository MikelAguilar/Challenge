package com.miguelaguilar.challenge.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.miguelaguilar.challenge.R
import com.miguelaguilar.challenge.databinding.ActivityMainBinding
import com.miguelaguilar.challenge.models.ResponseListBeers
import com.miguelaguilar.challenge.ui.viewModel.GeneralViewModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), AnkoLogger{

    lateinit var binding: ActivityMainBinding
    private lateinit var generalViewModel: GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        generalViewModel = ViewModelProviders.of(this)[GeneralViewModel::class.java]
        binding.viewModel = generalViewModel
        binding.recyclerViewBeers.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        generalViewModel.beerAdapter.setContext(this)

        generalViewModel.getBeers()
        generalViewModel.responseGetBeers.observe(this, {
            val responses : MutableList<ResponseListBeers> = mutableListOf()
            var jArray = it.asJsonArray
            for(jsonIndex in 0 until jArray.size()) {
                responses.add(Gson().fromJson(jArray[jsonIndex].asJsonObject, ResponseListBeers::class.java))
            }
            generalViewModel.beerAdapter.updateList(responses)
        })
        generalViewModel.beerAdapter.setClickAction {
            startActivity<DetailsActivity>("beer" to it)
        }
    }
}