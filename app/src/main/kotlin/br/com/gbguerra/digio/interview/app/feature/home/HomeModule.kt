package br.com.gbguerra.digio.interview.app.feature.home

import androidx.lifecycle.ViewModelProvider
import br.com.gbguerra.digio.interview.app.core.di.DIViewModelFactory
import br.com.gbguerra.digio.interview.app.extension.bindViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val homeModule = DI.Module("HomeModule") {
    bindViewModel<HomeViewModel>() with provider {
        HomeViewModel(instance())
    }

    bind<ViewModelProvider.Factory>() with provider { DIViewModelFactory(di) }
}
