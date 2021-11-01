package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Album implements Serializable {

    private static final long serialVersionUID=1L;

    private String nameAlbum;
    private List<Song> songList;
    private int imageId;

    public Album(String name, int imageId){
        this.nameAlbum = name;
        this.imageId = imageId;
        this.songList = new ArrayList<>();
    }

}
