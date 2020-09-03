package br.com.gbguerra.digio.interview.app.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.instance

inline fun <reified T : ViewModel> DI.Builder.bindViewModel(overrides: Boolean? = null): DI.Builder.TypeBinder<T> {
    return bind<T>(overrides = overrides)
}

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : DIAware, T : FragmentActivity {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : DIAware, T : Fragment {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}
