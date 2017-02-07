package ru.shagi.lookart_clean.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.shagi.lookart_clean.di.scope.AppScope;

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    public Context getContext() {
        return context;
    }
}
