package br.cotemig.marcos.correa.prova3.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    val URL = "https://apiv2.radiola.app/v1/"

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPlaylist(): ServiceMusic{
        return retrofit.create(ServiceMusic::class.java)
    }
}