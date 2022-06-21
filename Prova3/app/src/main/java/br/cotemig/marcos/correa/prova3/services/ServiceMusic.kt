package br.cotemig.marcos.correa.prova3.services

import br.cotemig.marcos.correa.prova3.models.Music
import retrofit2.Call
import retrofit2.http.GET

interface ServiceMusic {
    @GET("playlist/top10")
    fun getPlaylist(): Call<List<Music>>
}