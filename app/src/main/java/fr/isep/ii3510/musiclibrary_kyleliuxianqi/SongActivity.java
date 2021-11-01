package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongActivity extends AppCompatActivity {

    private List<Song> songList;
    private int albumImageId;
    private String albumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_activity);

        Intent intent = getIntent();
        if(intent != null){
            Album album = (Album) intent.getSerializableExtra("album");
            songList = album.getSongList();
            albumImageId = album.getImageId();
            albumName = album.getNameAlbum();
        }else{
            System.out.println("intent == null");
        }

        for(Song song : songList){
            System.out.println(song.getNameSong());
        }

        ImageView albumImage = (ImageView) findViewById(R.id.album_image_head);
        albumImage.setImageResource(albumImageId);
        TextView whichAlbum = (TextView) findViewById(R.id.which_album);
        whichAlbum.setText(albumName);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SongAdapter songAdapter = new SongAdapter(songList);
        recyclerView.setAdapter(songAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        this, DividerItemDecoration.VERTICAL));

    }
}
