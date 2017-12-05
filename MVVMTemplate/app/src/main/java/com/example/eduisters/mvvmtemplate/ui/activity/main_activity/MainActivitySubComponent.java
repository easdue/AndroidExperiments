package com.example.eduisters.mvvmtemplate.ui.activity.main_activity;

import com.example.eduisters.mvvmtemplate.di.ActivityBindingModule;
import com.example.eduisters.mvvmtemplate.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Erik Duisters on 04-12-2017.
 */

@Subcomponent(modules = ActivityBindingModule.class)
@ActivityScope
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
