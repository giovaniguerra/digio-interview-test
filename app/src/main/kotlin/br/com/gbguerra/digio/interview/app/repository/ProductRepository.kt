package br.com.gbguerra.digio.interview.app.repository

import br.com.gbguerra.digio.interview.app.api.DigioApi
import br.com.gbguerra.digio.interview.app.api.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductRepository(private val digioApi: DigioApi) {

    fun getProducts(): Flow<ProductResponse> = flow {
        val products = digioApi.getProducts()
        emit(products)
    }.flowOn(Dispatchers.IO)
}
