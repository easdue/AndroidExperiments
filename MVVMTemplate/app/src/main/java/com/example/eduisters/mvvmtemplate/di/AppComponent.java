package com.example.eduisters.mvvmtemplate.di;

import com.example.eduisters.mvvmtemplate.MyApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Erik Duisters on 25-11-2017.
 */

@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBindingModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApplication> {
    }
}
