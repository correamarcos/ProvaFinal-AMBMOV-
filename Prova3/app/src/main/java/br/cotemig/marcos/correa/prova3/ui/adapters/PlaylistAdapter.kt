package br.cotemig.marcos.correa.prova3.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.cotemig.marcos.correa.prova3.R
import br.cotemig.marcos.correa.prova3.models.Music
import coil.load

class PlaylistAdapter(var context: Context, var list: List<Music>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.music_playlist, null)

        var titleMusic = view.findViewById<TextView>(R.id.titleMusic)
        titleMusic.text = list[p0].title

        var imageAlbum = view.findViewById<ImageView>(R.id.imageAlbum)
        imageAlbum.load(list[p0].thumb)

        var artist = view.findViewById<TextView>(R.id.artistMusic)
        artist.text = list[p0].artist

        var length = view.findViewById<TextView>(R.id.musicSize)
        length.text = list[p0].length

        return view;
    }
}