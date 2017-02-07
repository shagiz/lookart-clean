package ru.shagi.lookart_clean.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ru.shagi.lookart_clean.R;
import ru.shagi.lookart_clean.di.component.DaggerArtistRecyclerComponent;
import ru.shagi.lookart_clean.di.module.ArtistRecyclerModule;
import ru.shagi.lookart_clean.model.pojo.Artist;
import ru.shagi.lookart_clean.presenter.ArtistRecyclerPresenter;
import ru.shagi.lookart_clean.presenter.ArtistRecyclerView;
import ru.shagi.lookart_clean.view.adapter.ArtistRecyclerAdapter;

public class ArtistsRecyclerFragment extends BaseFragment implements ArtistRecyclerView {

    @Inject
    ArtistRecyclerPresenter presenter;

    @Inject
    ArtistRecyclerAdapter adapter;

    @BindView(R.id.rvArtists)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        presenter.getArtist();
    }

    @Override
    protected void resolveDependency() {
        DaggerArtistRecyclerComponent.builder()
                .appComponent(getApplicationComponent())
                .artistRecyclerModule(new ArtistRecyclerModule(this))
                .build().inject(this);
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void show(List<Artist> artists) {
        adapter.setArtists(artists);
    }
}
