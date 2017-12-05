package com.example.eduisters.trakt_client.di;

import android.app.Application;
import android.content.Context;

import com.example.eduisters.trakt_client.MyApplication;
import com.example.eduisters.trakt_client.ui.activity.main_activity.MainActivitySubComponent;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Erik Duisters on 04-12-2017.
 */

@Module(subcomponents = MainActivitySubComponent.class)
public abstract class AppModule {
    @Binds
    @Singleton
    abstract Application application(MyApplication myApplication);

    @Provides
    @ApplicationContext
    static Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }
}
