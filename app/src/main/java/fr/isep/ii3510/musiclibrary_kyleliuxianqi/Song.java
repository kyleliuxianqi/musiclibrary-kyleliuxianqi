package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Song implements Serializable {

    private static final long serialVersionUID=1L;

    private String nameSong;

    public Song(String name){
        this.nameSong = name;
    }

}
