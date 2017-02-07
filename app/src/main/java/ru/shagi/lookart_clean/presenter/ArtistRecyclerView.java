package ru.shagi.lookart_clean.presenter;


import java.util.List;

import ru.shagi.lookart_clean.model.pojo.Artist;

public interface ArtistRecyclerView extends BaseView{
    void show(List<Artist> artists);
}
