package com.example.eduisters.trakt_client.di;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;

import com.example.eduisters.trakt_client.ui.activity.main_activity.MainActivity;
import com.example.eduisters.trakt_client.ui.activity.main_activity.MainActivitySubComponent;
import com.example.eduisters.trakt_client.ui.activity.main_activity.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Erik Duisters on 25-11-2017.
 */

@Module
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindHomeActivity(MainActivitySubComponent.Builder builder);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMailActivityViewModel(MainActivityViewModel viewModel);

    // Other Activities go here
}
