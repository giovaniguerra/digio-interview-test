package br.com.gbguerra.digio.interview.app.core.di

import android.app.Application
import br.com.gbguerra.digio.interview.app.api.apiModule
import br.com.gbguerra.digio.interview.app.repository.repositoryModule
import kotlinx.serialization.ExperimentalSerializationApi
import org.kodein.di.DI
import org.kodein.di.on

@ExperimentalSerializationApi
class DISetup(application: Application) {

    val container by lazy {
        DI.lazy {
            modules.forEach {
                import(it)
            }
        }.on(application)
    }

    private val modules = listOf(
        appModule(application),
        networkModule,
        repositoryModule,
        apiModule
    )
}
