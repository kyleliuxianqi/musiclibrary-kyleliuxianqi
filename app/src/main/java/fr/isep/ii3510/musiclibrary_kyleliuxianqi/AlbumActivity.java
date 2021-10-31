package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity);

        Intent intent = getIntent();
        if(intent != null){
            Band band = (Band) intent.getSerializableExtra("band");
            albumList = band.getAlbumList();
        }else{
            System.out.println("intent == null");
        }

        for(Album album : albumList){
            System.out.println(album.getNameAlbum());
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AlbumAdapter albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
