package ru.shagi.lookart_clean.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import ru.shagi.lookart_clean.App;
import ru.shagi.lookart_clean.R;
import ru.shagi.lookart_clean.model.pojo.Artist;

public class ArtistInfoFragment extends BaseFragment {

    @BindView(R.id.bigCover)
    ImageView bigCover;

    @Inject
    Picasso picasso;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selected_artist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void changeInfo(Artist artist) {
        picasso.load(artist.cover().big()).into(bigCover);
    }
}
