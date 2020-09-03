package br.com.gbguerra.digio.interview.app.extension

import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver

fun ViewGroup.addViewObserver(function: (view: View) -> Unit) {
    val view = this
    view.viewTreeObserver.addOnGlobalLayoutListener(
        object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                function.invoke(view)
            }
        }
    )
}
