package br.com.gbguerra.digio.interview.app.feature.home.uimodel

data class HomeUiModel(
    val userName: String,
    val spotlights: List<SpotlightUiModel>,
    val cash: CashUiModel,
    val products: List<ProductUiModel>,
)
