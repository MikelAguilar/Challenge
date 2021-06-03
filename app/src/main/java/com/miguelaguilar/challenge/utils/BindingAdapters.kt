package com.miguelaguilar.challenge.utils

import android.view.View
import android.view.WindowManager
import android.view.WindowManager.*
import android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.miguelaguilar.challenge.R
import com.miguelaguilar.challenge.utils.extension.getParentActivity
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.textColorResource


@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: LinearLayout, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: RecyclerView, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableEnabled")
fun setMutableEnabled(view: ImageView, enabled: MutableLiveData<Boolean>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && enabled != null)
        enabled.observe(parentActivity, Observer { value -> view.isEnabled = value ?: true })
}

@BindingAdapter("mutableSrc")
fun setMutableSrc(view: ImageView, src: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && src != null)
        src.observe(parentActivity, Observer { value ->
            view.setImageResource(value ?: R.mipmap.ic_launcher)
        })
}

@BindingAdapter("mutableBackground")
fun setMutableBackground(view: View, src: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && src != null)
        src.observe(parentActivity, Observer { value ->
            if (value != null)
                view.backgroundResource = value
        })

}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: ImageView, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null)
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })

}


@BindingAdapter("mutableEnabled")
fun setMutableEnabled(view: Button, enabled: MutableLiveData<Boolean>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && enabled != null)
        enabled.observe(parentActivity, Observer { value -> view.isEnabled = value ?: true })
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}


@BindingAdapter("mutableColorRsc")
fun setMutableColor(view: TextView, src: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && src != null) {
        src.observe(parentActivity, Observer { value ->
            if (value != null)
                view.textColorResource = value
        })
    }
}

@BindingAdapter("mutableTextRsrc")
fun setMutableTextRsrc(view: TextView, text: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { _ ->
            view.setText(text.value ?: R.string.app_name)
        })
    }
}

@BindingAdapter("checked")
fun setMutableChecked(view: CheckedTextView, checked: MutableLiveData<Boolean>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && checked != null) {
        checked.observe(parentActivity, Observer {
            view.isChecked = checked.value ?: false
        })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableEnabledActivity")
fun setMutableEnabledView(view: View, enabled: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && enabled != null)
        enabled.observe(parentActivity, Observer { value ->
            enabled.let {
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            }
            run { value }
        })
}