package br.com.gbguerra.digio.interview.app.extension.ui

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt

fun String.setColorSpan(@ColorInt color: Int): Spannable {
    return SpannableString(this).apply {
        setSpan(
            ForegroundColorSpan(color),
            0,
            this.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
    }
}
