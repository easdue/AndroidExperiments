package com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment;

import com.example.eduisters.mvvmtemplate.di.FragmentScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Erik Duisters on 08-12-2017.
 */

@FragmentScope
@Subcomponent
public interface MainFragmentSubComponent extends AndroidInjector<MainFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainFragment> {}
}
