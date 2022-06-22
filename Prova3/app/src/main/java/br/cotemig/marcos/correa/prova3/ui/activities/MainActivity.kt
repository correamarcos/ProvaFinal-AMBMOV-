package br.cotemig.marcos.correa.prova3.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import br.cotemig.marcos.correa.prova3.R
import br.cotemig.marcos.correa.prova3.models.Music
import br.cotemig.marcos.correa.prova3.services.RetrofitInitializer
import br.cotemig.marcos.correa.prova3.ui.adapters.PlaylistAdapter
import coil.load
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

                        var image = findViewById<ImageView>(R.id.imageMusicPlayed)
                        var title = findViewById<TextView>(R.id.nameMusicPlayed)
                        var artist = findViewById<TextView>(R.id.artistMusicPlayed)

                        title.text = it[0].title
                        image.load(it[0].thumb)
                        artist.text = it[0].artist

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

        listMusic.setOnItemClickListener { parent, view, i, l ->
            loadMusic(list[i])
        }
    }

    fun loadMusic(music: Music) {
        var intent = Intent(this, DetailMusicActivity::class.java)
        intent.putExtra("title", music.title)
        intent.putExtra("artist", music.artist)
        intent.putExtra("thumb", music.thumb)
        intent.putExtra("length", music.length)
        startActivity(intent)
    }
}