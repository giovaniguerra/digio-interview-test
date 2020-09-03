package br.com.gbguerra.digio.interview.app.core.di

import android.app.Application
import br.com.gbguerra.digio.interview.app.DigioInterviewApp
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun appModule(application: Application) = DI.Module("AppModule") {
    bind() from singleton { application as DigioInterviewApp }
}
