package com.example.eduisters.mvvmtemplate.ui.activity.main_activity;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import com.example.eduisters.mvvmtemplate.di.ViewModelKey;
import com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment.MainFragment;
import com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment.MainFragmentSubComponent;
import com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment.MainFragmentViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Erik Duisters on 08-12-2017.
 */

@Module(subcomponents = {MainFragmentSubComponent.class})
public abstract class MainActivityBindingModule {
    @Binds
    @IntoMap
    @FragmentKey(MainFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindMainActivityFragmentInjectorFactory(MainFragmentSubComponent.Builder builder);

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel.class)
    abstract ViewModel bindMainFragmentViewModel(MainFragmentViewModel viewModel);
}
