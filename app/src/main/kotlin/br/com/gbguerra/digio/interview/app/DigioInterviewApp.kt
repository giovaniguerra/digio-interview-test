package br.com.gbguerra.digio.interview.app

import android.app.Application
import br.com.gbguerra.digio.interview.app.core.di.DISetup
import kotlinx.serialization.ExperimentalSerializationApi
import org.kodein.di.DI
import org.kodein.di.DIAware

class DigioInterviewApp : Application(), DIAware {

    @ExperimentalSerializationApi
    override val di: DI = DISetup(this).container
}
