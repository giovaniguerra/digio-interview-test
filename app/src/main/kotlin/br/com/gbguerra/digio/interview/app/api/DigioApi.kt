package br.com.gbguerra.digio.interview.app.api

import br.com.gbguerra.digio.interview.app.api.model.ProductResponse
import retrofit2.http.GET

interface DigioApi {

    @GET("sandbox/products")
    suspend fun getProducts(): ProductResponse
}
