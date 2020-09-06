package br.com.gbguerra.digio.interview.app.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import br.com.gbguerra.digio.interview.app.databinding.ItemSpotlightBinding
import br.com.gbguerra.digio.interview.app.extension.ui.loadImage
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.SpotlightUiModel

class SpotlightAdapter : RecyclerView.Adapter<SpotlightAdapter.ViewHolder>() {

    var spotlights = mutableListOf<SpotlightUiModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).run {
            ItemSpotlightBinding.inflate(this, parent, false)
        }.apply {
            root.updateLayoutParams<RecyclerView.LayoutParams> {
                width = (parent.measuredWidth * CARD_PERCENT_WIDTH).toInt()
            }
        }.run {
            ViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spotlight = spotlights[position]
        holder.binding.bannerSpotlightImageview.loadImage(spotlight.imageUrl)
    }

    override fun getItemCount() = spotlights.size

    class ViewHolder(val binding: ItemSpotlightBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val CARD_PERCENT_WIDTH = 0.88
    }
}
