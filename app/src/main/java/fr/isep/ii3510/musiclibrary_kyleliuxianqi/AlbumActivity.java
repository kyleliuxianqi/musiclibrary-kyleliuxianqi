package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    private List<Album> albumList;
    private String bandName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity);

        Intent intent = getIntent();
        if(intent != null){
            Band band = (Band) intent.getSerializableExtra("band");
            albumList = band.getAlbumList();
            bandName = band.getNameBand();
        }else{
            System.out.println("intent == null");
        }

        for(Album album : albumList){
            System.out.println(album.getNameAlbum());
        }

        TextView tv_whose_album = findViewById(R.id.whose_album);
        StringBuilder head_display = new StringBuilder();
        head_display.append(getResources().getText(R.string.album_icon));
        head_display.append(bandName);
        tv_whose_album.setText(head_display);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AlbumAdapter albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
