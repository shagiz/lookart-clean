package ru.shagi.lookart_clean.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.shagi.lookart_clean.di.scope.AppScope;
import ru.shagi.lookart_clean.model.ArtistService;
import ru.shagi.lookart_clean.model.AutoValueAdapterFactory;

@Module(includes = NetworkModule.class)
public class ArtistServiceModule {

    @AppScope
    @Provides
    public ArtistService artistService(Retrofit retrofit) {
        return retrofit.create(ArtistService.class);
    }

    @AppScope
    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new AutoValueAdapterFactory());
        return gsonBuilder.create();
    }

    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient,
                             Gson gson,
                             RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
                .baseUrl("http://cache-default02f.cdn.yandex.net/")
                .build();
    }

    @AppScope
    @Provides
    public RxJavaCallAdapterFactory rxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }
}
