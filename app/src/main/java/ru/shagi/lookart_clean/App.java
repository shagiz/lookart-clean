package ru.shagi.lookart_clean;

import android.app.Application;

import ru.shagi.lookart_clean.di.component.AppComponent;
import ru.shagi.lookart_clean.di.component.DaggerAppComponent;
import ru.shagi.lookart_clean.di.module.ContextModule;
import timber.log.Timber;


public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
