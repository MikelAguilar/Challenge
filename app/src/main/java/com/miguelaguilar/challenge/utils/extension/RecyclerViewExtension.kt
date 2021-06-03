package com.miguelaguilar.challenge.utils.extension

import android.view.View
import androidx.recyclerview.widget.RecyclerView


fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}


interface OnItemClickListener {
    fun onItemClicked(position: Int, view: View)
}

fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
    this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewDetachedFromWindow(p0: View) {
            p0.setOnClickListener(null)
        }

        override fun onChildViewAttachedToWindow(p0: View) {
            p0.setOnClickListener {
                val holder = getChildViewHolder(p0)
                onClickListener.onItemClicked(holder.adapterPosition, p0)
            }
        }
    })
}