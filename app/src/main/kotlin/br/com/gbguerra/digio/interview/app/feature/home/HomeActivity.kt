package br.com.gbguerra.digio.interview.app.feature.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.gbguerra.digio.interview.app.core.ui.AbstractActivity
import br.com.gbguerra.digio.interview.app.databinding.ActivityHomeBinding
import br.com.gbguerra.digio.interview.app.extension.loadImage
import br.com.gbguerra.digio.interview.app.extension.viewModel
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.HomeUiModel
import org.kodein.di.DI
import org.kodein.di.android.di
import org.kodein.di.android.subDI

class HomeActivity : AbstractActivity() {

    private val viewModel: HomeViewModel by viewModel()

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val spotlightAdapter by lazy { SpotlightAdapter() }
    private val productAdapter by lazy { ProductAdapter() }

    override val di: DI by subDI(di()) {
        import(homeModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerViews()
        setupObservers()
    }

    private fun setupRecyclerViews() {
        with(binding.spotlightHomeRecyclerview) {
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(this)
            adapter = spotlightAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            addItemDecoration(SpotlightItemDecoration())
        }

        with(binding.productHomeRecyclerview) {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            addItemDecoration(ProductItemDecoration())
        }
    }

    private fun setupObservers() {
        viewModel.homeUiModel.observe(this, observeHomeUiModel())
    }

    private fun observeHomeUiModel(): (t: HomeUiModel) -> Unit {
        return {
            spotlightAdapter.spotlights = it.spotlights.toMutableList()
            binding.cashHomeTitle.text = it.cash.title
            binding.bannerCashImageview.loadImage(it.cash.imageUrl)
            binding.productHomeTitle.text = it.productLabel
            productAdapter.products = it.products.toMutableList()
        }
    }
}
