package com.example.eduisters.trakt_client.ui.activity.main_activity;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Erik Duisters on 20-12-2017.
 */

@Module(subcomponents = {/*All fragments SubComponent.class files go here*/})
public abstract class MainActivityBindingModule {
    /*
    @Binds
    @IntoMap
    @FragmentKey(Fragment1.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindMainActivityFragmentInjectorFactory<Fragment1SubComponent.Builder builder);

    @Binds
    @IntoMap
    @ViewModelKey(Fragment1ViewModel.class)
    abstract ViewModel bindFragment1ViewModel(Fragment1ViewModel viewModel);
    */
}
