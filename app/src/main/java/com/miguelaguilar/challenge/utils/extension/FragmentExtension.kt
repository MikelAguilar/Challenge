package com.miguelaguilar.challenge.utils.extension

import android.text.InputType
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.alert


fun Fragment.hideKeyboard() {
    activity?.hideKeyboard(view!!)
}


fun Fragment.requestText(mensaje: Int, hint: String = "Editar", func: (String) -> Unit) {
    this.alert(message = mensaje) {
        customView {
            linearLayout {
                this.orientation = LinearLayout.VERTICAL
                val textinput = editText()
                textinput.hint = hint
                textinput.inputType = InputType.TYPE_CLASS_TEXT
                positiveButton("Actualizar") { _ ->
                    func(textinput.text.toString())
                }
                negativeButton("Cancelar") {

                }
            }
        }
    }.show()
}
