package br.com.gbguerra.digio.interview.app.extension

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.isLastIndex(position: Int): Boolean = position == adapter?.itemCount?.minus(1)
