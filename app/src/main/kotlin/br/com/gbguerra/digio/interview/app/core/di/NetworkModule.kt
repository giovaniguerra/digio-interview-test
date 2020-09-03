package br.com.gbguerra.digio.interview.app.core.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Converter
import retrofit2.Retrofit

@ExperimentalSerializationApi
val networkModule = DI.Module("NetworkModule") {

    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/")
            .client(instance())
            .addConverterFactory(instance())
            .build()
    }

    bind() from singleton {
        OkHttpClient.Builder()
            .addInterceptor(instance<Interceptor>())
            .build()
    }

    bind<Interceptor>() with singleton {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    bind<Converter.Factory>() with singleton {
        Json.asConverterFactory(instance())
    }

    bind() from singleton {
        "application/json".toMediaType()
    }
}
