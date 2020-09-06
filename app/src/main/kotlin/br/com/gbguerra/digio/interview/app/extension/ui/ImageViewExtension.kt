package br.com.gbguerra.digio.interview.app.extension.ui

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .fit()
        .into(this)
}
