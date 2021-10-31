package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BandActivity extends AppCompatActivity {

    private Map<String,Band> bandMap;
    private List<List<String>> lineList;

    private final List<Band> bandList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.band_activity);

        readFile();
        System.out.println(Arrays.toString(lineList.toArray()));
        initialize();

        for(Band band:bandList){
            System.out.println(band.getNameBand());
            System.out.println(band.getAlbumList().size());
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BandAdapter adapter = new BandAdapter(bandList);
        recyclerView.setAdapter(adapter);

    }

    private void readFile() {
        Scanner sc = new Scanner(getResources().openRawResource(R.raw.library));

        if (lineList==null) {
            lineList = new ArrayList<>();
        }

        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            StringTokenizer lineObj = new StringTokenizer(line,",");

            List<String> lineTemp = new ArrayList<>();
            while (lineObj.hasMoreTokens()){
                lineTemp.add(lineObj.nextToken());
            }
            lineList.add(lineTemp);
        }
        sc.close();
    }

    private void initialize() {
        if (bandMap == null) {
            bandMap = new HashMap<>();
        }
        for (List<String> list : lineList) {
            String bandName = list.get(0);
            if(!bandMap.containsKey(bandName)){
                bandMap.put(bandName, new Band(bandName,0));
            }
        }

        for (String bandName : bandMap.keySet()) {
            List<String> albumList = new ArrayList<>();
            for (List<String> list : lineList) {
                if (bandName.equals(list.get(0))) {
                    String albumName = list.get(1);
                    if(!albumList.contains(albumName)){
                        albumList.add(albumName);
                        Objects.requireNonNull(bandMap.get(bandName)).getAlbumList().add(new Album(albumName));
                    }
                }
            }

            for (List<String> list : lineList) {
                for (Album album : Objects.requireNonNull(bandMap.get(bandName)).getAlbumList() ) {
                    if (album.getNameAlbum().equals(list.get(1))) {
                        String songName = list.get(2);
                        album.getSongList().add(new Song(songName));
                    }
                }
            }
        }

        for(String bandName: bandMap.keySet()){
            switch (bandName) {
                case "Pink Floyd": {
                    Objects.requireNonNull(bandMap.get(bandName)).setImageId(R.drawable.pinkfloyd);
                    bandList.add(bandMap.get(bandName));
                    break;
                }
                case "Queen": {
                    Objects.requireNonNull(bandMap.get(bandName)).setImageId(R.drawable.queen);
                    bandList.add(bandMap.get(bandName));
                    break;
                }
                case "Radiohead": {
                    Objects.requireNonNull(bandMap.get(bandName)).setImageId(R.drawable.radiohead);
                    bandList.add(bandMap.get(bandName));
                    break;
                }
            }
        }

    }

    private void testPrint(){
        //Test
        for(String bandName : bandMap.keySet()){
            System.out.println(bandName);
            List<Album> albumList = Objects.requireNonNull(bandMap.get(bandName)).getAlbumList();
            for(Album album : albumList){
                System.out.println(album.getNameAlbum());
                for(Song song : album.getSongList()){
                    System.out.print(song.getNameSong()+",");
                }
                System.out.println();
            }
        }
    }

}