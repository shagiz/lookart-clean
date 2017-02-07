package ru.shagi.lookart_clean.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import ru.shagi.lookart_clean.App;
import ru.shagi.lookart_clean.di.module.ArtistServiceModule;
import ru.shagi.lookart_clean.di.module.PicassoModule;
import ru.shagi.lookart_clean.di.scope.AppScope;
import ru.shagi.lookart_clean.model.ArtistService;
import ru.shagi.lookart_clean.view.fragment.ArtistInfoFragment;

@AppScope
@Component(modules = {ArtistServiceModule.class, PicassoModule.class})
public interface AppComponent {

    Picasso getPicasso();

    ArtistService getArtistService();

    void inject(App app);

    void inject(ArtistInfoFragment f);
}
