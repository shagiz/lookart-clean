package ru.shagi.lookart_clean.di.module;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.shagi.lookart_clean.di.scope.AppScope;
import timber.log.Timber;


@Module(includes = ContextModule.class)
public class NetworkModule {

    @AppScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        return new HttpLoggingInterceptor(msg -> Timber.i("LookArt", msg));
    }

    @AppScope
    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor interceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public Cache cache(File file){
        file.mkdirs();
        return new Cache(file, 10 * 1000 * 1000); // 10MB cache
    }

    @AppScope
    @Provides
    public File file(Context context){
        return new File(context.getCacheDir(), "okhhtp_cache");
    }
}
