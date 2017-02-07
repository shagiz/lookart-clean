package ru.shagi.lookart_clean.di.module;

import dagger.Module;
import dagger.Provides;
import ru.shagi.lookart_clean.di.scope.ArtistRecyclerScope;
import ru.shagi.lookart_clean.presenter.ArtistRecyclerView;
import ru.shagi.lookart_clean.view.fragment.ArtistsRecyclerFragment;

@Module
public class ArtistRecyclerModule {
    private ArtistRecyclerView view;

    public ArtistRecyclerModule(ArtistRecyclerView view) {
        this.view = view;
    }

    @ArtistRecyclerScope
    @Provides
    ArtistRecyclerView artistRecyclerView() {
        return view;
    }

    @ArtistRecyclerScope
    @Provides
    ArtistsRecyclerFragment artistsRecyclerFragment() {
        return (ArtistsRecyclerFragment) view;
    }
}
