package br.com.gbguerra.digio.interview.app.api.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ProductResponse(
    @SerialName("cash")
    val cash: CashResponse,
    @SerialName("products")
    val products: List<ProductResponse>,
    @SerialName("spotlight")
    val spotlight: List<SpotlightResponse>
) {
    @Keep
    @Serializable
    data class CashResponse(
        @SerialName("bannerURL")
        val bannerURL: String,
        @SerialName("description")
        val description: String,
        @SerialName("title")
        val title: String
    )

    @Keep
    @Serializable
    data class ProductResponse(
        @SerialName("description")
        val description: String,
        @SerialName("imageURL")
        val imageURL: String,
        @SerialName("name")
        val name: String
    )

    @Keep
    @Serializable
    data class SpotlightResponse(
        @SerialName("bannerURL")
        val bannerURL: String,
        @SerialName("description")
        val description: String,
        @SerialName("name")
        val name: String
    )
}
