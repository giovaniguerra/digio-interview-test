package br.com.gbguerra.digio.interview.app.feature.home.uimodel

data class HomeUiModel(
    val spotlights: List<SpotlightUiModel>,
    val cash: CashUiModel,
    val productLabel: String,
    val products: List<ProductUiModel>,
)
