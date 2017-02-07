package ru.shagi.lookart_clean.model;

import java.util.List;

import retrofit2.http.GET;
import ru.shagi.lookart_clean.model.pojo.Artist;
import rx.Observable;

public interface ArtistService {

    // change url and String income
    @GET("/download.cdn.yandex.net/mobilization-2016/artists.json")
    Observable<List<Artist>> getArtistInfo();
}
