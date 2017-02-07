package ru.shagi.lookart_clean.presenter;


import android.util.Log;

import javax.inject.Inject;

import ru.shagi.lookart_clean.model.ArtistService;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ArtistRecyclerPresenter extends BasePresenter<ArtistRecyclerView> {

    @Inject
    ArtistService artistService;

    @Inject
    ArtistRecyclerPresenter() {
    }

    public void getArtist() {
        subscription = artistService.getArtistInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        artists -> view.show(artists),
                        error -> Log.d("LookArt", error.getMessage(), error),
                        () -> Log.d("TAG", "end")
                );
    }
}
