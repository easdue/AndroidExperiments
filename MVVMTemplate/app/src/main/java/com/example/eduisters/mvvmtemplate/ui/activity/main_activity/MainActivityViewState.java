package com.example.eduisters.mvvmtemplate.ui.activity.main_activity;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.example.eduisters.mvvmtemplate.util.MyMenuItem;

import java.util.List;

/**
 * Created by Erik Duisters on 19-12-2017.
 */

final class MainActivityViewState {
    final @DrawableRes int navHeaderDrawableId;
    final @StringRes int navHeaderTitleId;
    final @StringRes int navheaderSubTitleId;
    final List<MyMenuItem> navigationItems;
    final List<MyMenuItem> optionsMenu;

    private MainActivityViewState(Builder builder) {
        navHeaderDrawableId = builder.navHeaderDrawable;
        navHeaderTitleId = builder.navHeaderTitle;
        navheaderSubTitleId = builder.navheaderSubTitle;
        navigationItems = builder.navigationItems;
        optionsMenu = builder.optionsMenu;
    }

    public static final class Builder {
        private @DrawableRes int navHeaderDrawable;
        private @StringRes int navHeaderTitle;
        private @StringRes int navheaderSubTitle;
        private List<MyMenuItem> navigationItems;
        private List<MyMenuItem> optionsMenu;

        public Builder() {
        }

        public Builder(MainActivityViewState from) {
            this.navHeaderDrawable = from.navHeaderDrawableId;
            this.navHeaderTitle = from.navHeaderTitleId;
            this.navheaderSubTitle = from.navheaderSubTitleId;
            this.navigationItems = from.navigationItems;
            this.optionsMenu = from.optionsMenu;
        }

        public Builder navHeaderDrawable(@DrawableRes int drawableResId) {
            navHeaderDrawable = drawableResId;
            return this;
        }

        public Builder navHeaderTitle(@StringRes int titleResId) {
            navHeaderTitle = titleResId;
            return this;
        }

        public Builder navheaderSubTitle(@StringRes int subTitleResId) {
            navheaderSubTitle = subTitleResId;
            return this;
        }

        public Builder navigationItems(List<MyMenuItem> menu) {
            navigationItems = menu;
            return this;
        }

        public Builder optionsMenu(List<MyMenuItem> menu) {
            optionsMenu = menu;
            return this;
        }

        public MainActivityViewState build() {
            return new MainActivityViewState(this);
        }
    }
}
