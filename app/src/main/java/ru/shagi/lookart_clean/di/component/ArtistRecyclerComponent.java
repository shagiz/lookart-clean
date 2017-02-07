package ru.shagi.lookart_clean.di.component;

import dagger.Component;
import ru.shagi.lookart_clean.di.module.ArtistRecyclerModule;
import ru.shagi.lookart_clean.di.scope.ArtistRecyclerScope;
import ru.shagi.lookart_clean.view.fragment.ArtistsRecyclerFragment;

@ArtistRecyclerScope
@Component(modules = ArtistRecyclerModule.class, dependencies = AppComponent.class)
public interface ArtistRecyclerComponent {

    void inject(ArtistsRecyclerFragment fragment);
}
