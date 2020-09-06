package br.com.gbguerra.digio.interview.app.feature.home.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.gbguerra.digio.interview.app.R
import br.com.gbguerra.digio.interview.app.extension.ui.isLastIndex

class SpotlightItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val viewPosition = parent.getChildAdapterPosition(view)
        val resources = requireNotNull(view.context.resources)

        val marginNormal = resources.getDimensionPixelSize(R.dimen.margin_normal)
        val marginXSmall = resources.getDimensionPixelSize(R.dimen.margin_xsmall)

        val isFirstIndex = viewPosition == 0
        if (isFirstIndex) {
            outRect.left = marginNormal
        }

        if (parent.isLastIndex(viewPosition)) {
            outRect.right = marginNormal
        } else {
            outRect.right = marginXSmall
        }
    }
}
