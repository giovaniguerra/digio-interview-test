package br.com.gbguerra.digio.interview.app.api

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit

val apiModule = DI.Module("ApiModule") {
    bind<DigioApi>() with singleton { instance<Retrofit>().create(DigioApi::class.java) }
}
