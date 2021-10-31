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

public class BandAdapter extends RecyclerView.Adapter<BandAdapter.ViewHolder> {

    private final List<Band> mBandList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View bandView;
        ImageView bandImage;
        TextView bandName;

        public ViewHolder(View view){
            super(view);
            bandView = view;
            bandImage = (ImageView) view.findViewById(R.id.band_image);
            bandName = (TextView) view.findViewById(R.id.band_name);
        }
    }

    public BandAdapter(List<Band> bandList){
        mBandList = bandList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.band_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Band band = mBandList.get(position);
        holder.bandImage.setImageResource(band.getImageId());
        holder.bandName.setText(band.getNameBand());

        holder.bandView.setOnClickListener(view -> {

            Intent intent = new Intent(view.getContext(), AlbumActivity.class);
            intent.putExtra("band",(Serializable) band);
            view.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount(){
        return mBandList.size();
    }

}
