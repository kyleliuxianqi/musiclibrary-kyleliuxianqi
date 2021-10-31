package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private final List<Song> mSongList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View songView;
        TextView songName;

        public ViewHolder(View view){
            super(view);
            songView = view;
            songName = (TextView) view.findViewById(R.id.song_name);
        }
    }

    public SongAdapter(List<Song> songList) {
        mSongList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public  void onBindViewHolder(ViewHolder holder, int position){
        Song song = mSongList.get(position);
        holder.songName.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
    }

}
