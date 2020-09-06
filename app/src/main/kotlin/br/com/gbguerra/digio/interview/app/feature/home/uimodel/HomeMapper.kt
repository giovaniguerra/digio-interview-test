package br.com.gbguerra.digio.interview.app.feature.home.uimodel

import br.com.gbguerra.digio.interview.app.api.model.ProductResponse

fun mapHomeUiModel(productResponse: ProductResponse, userName: String): HomeUiModel {
    with(productResponse) {
        val spotlights = spotlight.map { spotlight ->
            SpotlightUiModel(spotlight.bannerURL)
        }

        val cashUiModel = CashUiModel(
            imageUrl = cash.bannerURL,
            title = cash.title,
        )

        val products = products.map { product ->
            ProductUiModel(
                imageUrl = product.imageURL
            )
        }

        return HomeUiModel(
            userName = userName,
            spotlights = spotlights,
            cash = cashUiModel,
            products = products
        )
    }
}
