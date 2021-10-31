package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Band implements Serializable {

    private static final long serialVersionUID=1L;

    private String nameBand;
    private List<Album> albumList;
    private int imageId;

    public Band(String name, int imageId){
        this.nameBand = name;
        this.imageId = imageId;
        this.albumList = new ArrayList<>();
    }

}
