package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongActivity extends AppCompatActivity {

    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_activity);

        Intent intent = getIntent();
        if(intent != null){
            Album album = (Album) intent.getSerializableExtra("album");
            songList = album.getSongList();
        }else{
            System.out.println("intent == null");
        }

        for(Song song : songList){
            System.out.println(song.getNameSong());
        }

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
