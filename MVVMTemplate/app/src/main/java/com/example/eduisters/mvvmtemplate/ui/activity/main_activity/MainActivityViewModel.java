package com.example.eduisters.mvvmtemplate.ui.activity.main_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.eduisters.mvvmtemplate.R;
import com.example.eduisters.mvvmtemplate.di.ActivityScope;
import com.example.eduisters.mvvmtemplate.util.MyMenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Erik Duisters on 03-12-2017.
 */

@ActivityScope
public final class MainActivityViewModel extends ViewModel {
    private MutableLiveData<MainActivityViewState> viewState;

    @Inject
    public MainActivityViewModel() {
        MainActivityViewState.Builder builder = new MainActivityViewState.Builder();
        builder.navHeaderDrawable(R.mipmap.ic_launcher_round);
        builder.navHeaderTitle(R.string.nav_header_title);
        builder.navheaderSubTitle(R.string.nav_header_sub_title);

        List<MyMenuItem> navigationItems = new ArrayList<>();
        navigationItems.add(new MyMenuItem(R.id.nav_camera, true, true));
        navigationItems.add(new MyMenuItem(R.id.nav_gallery, true, true));
        navigationItems.add(new MyMenuItem(R.id.nav_slideshow, true, true));
        navigationItems.add(new MyMenuItem(R.id.nav_manage, true, true));
        navigationItems.add(new MyMenuItem(R.id.nav_share, false, true));
        navigationItems.add(new MyMenuItem(R.id.nav_send, false, true));

        builder.navigationItems(navigationItems);

        List<MyMenuItem> optionsMenu = new ArrayList<>();
        optionsMenu.add(new MyMenuItem(R.id.action_settings, false, true));

        builder.optionsMenu(optionsMenu);

        viewState = new MutableLiveData<>();
        viewState.setValue(builder.build());
    }

    LiveData<MainActivityViewState> getViewState() {
        return viewState;
    }
}
