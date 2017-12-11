package com.example.eduisters.mvvmtemplate.di;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;

import com.example.eduisters.mvvmtemplate.ui.activity.main_activity.MainActivity;
import com.example.eduisters.mvvmtemplate.ui.activity.main_activity.MainActivitySubComponent;
import com.example.eduisters.mvvmtemplate.ui.activity.main_activity.MainActivityViewModel;

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
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainActivityViewModel viewModel);

    // Other Activities go here
}
