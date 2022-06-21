package br.cotemig.marcos.correa.prova3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.cotemig.marcos.correa.prova3.R
import br.cotemig.marcos.correa.prova3.models.Music
import br.cotemig.marcos.correa.prova3.services.RetrofitInitializer
import br.cotemig.marcos.correa.prova3.services.ServiceMusic
import br.cotemig.marcos.correa.prova3.ui.adapters.PlaylistAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPlaylist();
    }

    fun getPlaylist(){
        var s = RetrofitInitializer().getPlaylist()
        var call = s.getPlaylist()

        call.enqueue(object : retrofit2.Callback<List<Music>>{
            override fun onResponse(call: Call<List<Music>>, response: Response<List<Music>>) {
                if (response.code() == 200){

                    response.body()?.let {
                        showPlaylist(it)
                    }

                }
            }

            override fun onFailure(call: Call<List<Music>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showPlaylist(list: List<Music>){
        var listMusic = findViewById<ListView>(R.id.playList)
        listMusic.adapter = PlaylistAdapter(this, list)
    }
}