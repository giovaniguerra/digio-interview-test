package br.com.gbguerra.digio.interview.app.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.com.gbguerra.digio.interview.app.api.model.ProductResponse
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.CashUiModel
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.HomeUiModel
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.ProductUiModel
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.SpotlightUiModel
import br.com.gbguerra.digio.interview.app.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class HomeViewModel(productRepository: ProductRepository) : ViewModel() {

    private val productResponse: Flow<ProductResponse> = productRepository.getProducts()
        .catch { exception ->
            Log.e(HomeViewModel::class.simpleName, "Coroutines error", exception)
        }

    val homeUiModel = productResponse
        .map { mapHomeUiModel(it) }
        .asLiveData(viewModelScope.coroutineContext)

    private fun mapHomeUiModel(productResponse: ProductResponse): HomeUiModel {
        with(productResponse) {
            val spotlights = spotlight.map { spotlight ->
                SpotlightUiModel(spotlight.bannerURL)
            }

            val cashUiModel = CashUiModel(
                imageUrl = cash.bannerURL,
                title = cash.title,
            )

            val productTitle = "Produtos"

            val products = products.map { product ->
                ProductUiModel(
                    imageUrl = product.imageURL
                )
            }

            return HomeUiModel(
                spotlights = spotlights,
                cash = cashUiModel,
                productLabel = productTitle,
                products = products
            )
        }
    }
}
