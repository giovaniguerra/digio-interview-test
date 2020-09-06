package br.com.gbguerra.digio.interview.app.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gbguerra.digio.interview.app.databinding.ItemProductBinding
import br.com.gbguerra.digio.interview.app.extension.ui.loadImage
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.ProductUiModel

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var products = mutableListOf<ProductUiModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.binding.bannerProductImageview.loadImage(product.imageUrl)
    }

    override fun getItemCount() = products.size

    class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)
}
