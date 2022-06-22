package br.cotemig.marcos.correa.prova3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import br.cotemig.marcos.correa.prova3.R
import coil.load

class DetailMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_music)

        var titleMusic = findViewById<TextView>(R.id.titleMusic)
        var imageMusic = findViewById<ImageView>(R.id.imageMusic)
        var nameMusic = findViewById<TextView>(R.id.nameMusic)
        var artistMusic = findViewById<TextView>(R.id.artistMusic)

        titleMusic.text = intent.getStringExtra("title").toString()
        imageMusic.load(intent.getStringExtra("thumb"))
        nameMusic.text = intent.getStringExtra("title").toString()
        artistMusic.text = intent.getStringExtra("artist").toString()

        var btnBack = findViewById<ImageButton>(R.id.arrowBack)
        btnBack.setOnClickListener {
            backPlaylist()
        }
    }

    fun backPlaylist(){
        finish()
    }
}