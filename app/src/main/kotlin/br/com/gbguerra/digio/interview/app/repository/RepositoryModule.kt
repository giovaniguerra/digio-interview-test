package br.com.gbguerra.digio.interview.app.repository

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module("RepositoryModule") {
    bind<ProductRepository>() with singleton { ProductRepository(instance()) }
    bind<UserRepository>() with singleton { UserRepository()}
}
