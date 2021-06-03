package com.miguelaguilar.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelaguilar.challenge.R
import com.miguelaguilar.challenge.base.BaseViewModel
import com.miguelaguilar.challenge.databinding.ItemListBeersBinding
import com.miguelaguilar.challenge.models.ResponseListBeers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import kotlin.coroutines.coroutineContext

class BeersAdapterlist : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AnkoLogger {
    private lateinit var context: Context
    private lateinit var items: MutableList<Any>
    private lateinit var bindingItem: ItemListBeersBinding
    private var listenerClick: ((item: Any) -> Unit)? = null

    @Suppress("unused")
    fun setClickAction(listenerClick: (item: Any) -> Unit) {
        this.listenerClick = listenerClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                bindingItem = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_list_beers,
                    parent,
                    false
                )
                return BeerViewHolder(bindingItem, context)
            }

            else -> {
                bindingItem = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_list_beers,
                    parent,
                    false
                )
                return BeerViewHolder(bindingItem, context)
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        when (holder) {
            is BeerViewHolder -> {
                when (items[position]) {
                    is ResponseListBeers -> {
                        holder.bind(items[position] as ResponseListBeers)
                        bindingItem.masDetalles.setOnClickListener { listenerClick?.invoke(items[position]) }
                    }
                    /*is CertificacionConaveModel -> {
                        holder.bind(items[position] as CertificacionConaveModel)
                        bindingHeader.root.setOnClickListener { listenerClick?.invoke(items[position]) }
                        if ((items[position] as CertificacionConaveModel).isOpen == false) {
                            bindingHeader.imgDropdown8.imageResource =
                                R.drawable.ic_dropdown_arriba_rojo
                        } else {
                            bindingHeader.imgDropdown8.imageResource =
                                R.drawable.ic_dropdown_abajo_rojo
                        }
                        var pretotal = 0
                        var tamanoArreglo = (items[position] as CertificacionConaveModel).preguntas?.size
                        for (items in (items[position] as CertificacionConaveModel).preguntas ?: mutableListOf()) {
                            if (items?.tipoDato == "intMin") {
                                pretotal = items.value?.toInt() ?: 0
                            }
                        }
                        //bindingHeader.txtNumeroPromedio8.setText((pretotal/tamanoArreglo!!).toString())
                    }*/
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ResponseListBeers -> 0
            else -> -1
        }
    }

    override fun getItemCount(): Int {
        return if (::items.isInitialized) items.size else 0
    }

    fun updateList(items: List<Any>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    fun setContext(context: Context) {
        this.context = context
    }

    class BeerViewHolder(private val binding: ItemListBeersBinding, val context : Context) :
        RecyclerView.ViewHolder(binding.root), AnkoLogger {
        private val viewModel = ItemBeersViewModel()
        fun bind(item: ResponseListBeers) {
            binding.viewModel = viewModel
            viewModel.bind(item)
            Glide.with(context)
                .load(item.image_url)
                .into(binding.imagenBeer)
            binding.descripcion.text = context.getString(R.string.descripcion, item.description)
        }
    }
}

class ItemBeersViewModel : BaseViewModel(), AnkoLogger {
    val nombre : MutableLiveData<String> = MutableLiveData()
    val descripcion : MutableLiveData<String> = MutableLiveData()

    fun bind(item: ResponseListBeers){
        nombre.value = "Nombre: ${item.name}"
        descripcion.value = "Descripción: ${item.description}"
    }
}