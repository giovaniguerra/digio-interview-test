package br.com.gbguerra.digio.interview.app.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.com.gbguerra.digio.interview.app.api.model.ProductResponse
import br.com.gbguerra.digio.interview.app.feature.home.uimodel.mapHomeUiModel
import br.com.gbguerra.digio.interview.app.repository.ProductRepository
import br.com.gbguerra.digio.interview.app.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.zip

class HomeViewModel(
    productRepository: ProductRepository,
    userRepository: UserRepository
) : ViewModel() {

    private val productResponse: Flow<ProductResponse> = productRepository.getProducts()
        .catch { exception ->
            Log.e(HomeViewModel::class.simpleName, "Coroutines error", exception)
        }

    val homeUiModel = productResponse
        .zip(userRepository.getUser()) { product, userName ->
            mapHomeUiModel(product, userName)
        }.asLiveData(viewModelScope.coroutineContext)
}
