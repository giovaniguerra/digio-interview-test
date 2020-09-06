package br.com.gbguerra.digio.interview.app.feature.home

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.gbguerra.digio.interview.app.R
import br.com.gbguerra.digio.interview.app.core.ui.AbstractActivity
import br.com.gbguerra.digio.interview.app.databinding.ActivityHomeBinding
import br.com.gbguerra.digio.interview.app.extension.loadImage
import br.com.gbguerra.digio.interview.app.extension.setColorSpan
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
        setSupportActionBar(binding.homeToolbar)

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
            title = createGreetings(it.userName)
            spotlightAdapter.spotlights = it.spotlights.toMutableList()
            binding.cashHomeTitle.text = createCashHomeTitle(it.cash.title)
            binding.bannerCashImageview.loadImage(it.cash.imageUrl)
            productAdapter.products = it.products.toMutableList()
        }
    }

    private fun createGreetings(userName: String): String {
        return getString(R.string.greetings_home_title, userName)
    }

    private fun createCashHomeTitle(title: String): Spannable {
        val (part1, part2) = title.split(" ")
        val blueColor = ContextCompat.getColor(this, R.color.blue)
        val grayColor = ContextCompat.getColor(this, R.color.gray)

        return SpannableStringBuilder().apply {
            append(part1.setColorSpan(blueColor))
            append(" ")
            append(part2.setColorSpan(grayColor))
        }.toSpannable()
    }
}
