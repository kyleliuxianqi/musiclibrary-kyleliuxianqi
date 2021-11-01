package fr.isep.ii3510.musiclibrary_kyleliuxianqi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private final List<Album> mAlbumList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View albumView;
        ImageView albumImage;
        TextView albumName;

        public ViewHolder(View view){
            super(view);
            albumView = view;
            albumImage = (ImageView) view.findViewById(R.id.album_image);
            albumName = (TextView) view.findViewById(R.id.album_name);
        }
    }

    public AlbumAdapter(List<Album> albumList){
        mAlbumList = albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Album album = mAlbumList.get(position);
        holder.albumImage.setImageResource(album.getImageId());
        holder.albumName.setText(album.getNameAlbum());

        holder.albumView.setOnClickListener(view -> {

            Intent intent = new Intent(view.getContext(), SongActivity.class);
            intent.putExtra("album", (Serializable) album);
            view.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount(){
        return mAlbumList.size();
    }
}
