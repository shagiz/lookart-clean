package ru.shagi.lookart_clean.view.adapter;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.shagi.lookart_clean.R;
import ru.shagi.lookart_clean.model.pojo.Artist;
import ru.shagi.lookart_clean.view.MainActivity;
import ru.shagi.lookart_clean.view.fragment.ArtistInfoFragment;
import ru.shagi.lookart_clean.view.fragment.ArtistsRecyclerFragment;

public class ArtistRecyclerAdapter extends RecyclerView.Adapter<ArtistRecyclerAdapter.ViewHolder> {

    private Picasso picasso;

    private ArtistsRecyclerFragment fragment;

    private List<Artist> artists = Collections.emptyList();

    @Inject
    public ArtistRecyclerAdapter(ArtistsRecyclerFragment fragment, Picasso picasso) {
        this.fragment = fragment;
        this.picasso = picasso;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_list_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.artistName.setText(artist.name());
        holder.listAlbums.setText(artist.albums());

        StringBuilder genres = new StringBuilder();

        for (String genre : artist.genres()) {
            genres.append(genre).append(" ");
        }

        holder.listStyle.setText(genres.toString());

        picasso.load(artist.cover().small()).into(holder.smallCoverIV);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvArtistName)
        TextView artistName;

        @BindView(R.id.tvListAlbums)
        TextView listAlbums;

        @BindView(R.id.tvListStyle)
        TextView listStyle;

        @BindView(R.id.small_cover)
        ImageView smallCoverIV;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(view -> {
                ((ArtistInfoFragment) fragment.getFragmentManager().findFragmentById(R.id.pager))
                        .changeInfo(artists.get(this.getAdapterPosition()));

                ((MainActivity) fragment.getActivity()).openInfoFragment();
            });
        }

    }
}
