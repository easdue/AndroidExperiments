package com.example.eduisters.mvvmtemplate.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Erik Duisters on 04-12-2017.
 */

public abstract class BaseFragment<VM extends ViewModel> extends Fragment {
    //TODO: ?inject childFragmentManager?
    //TODO: Call viewModel.start() somewhere
    @Nullable
    Unbinder unbinder;

    @Inject
    VM viewModel;

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this);
        }

        super.onAttach(context);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this);
        }

        super.onAttach(activity);
    }

    protected void bind(View view) {
        unbinder = ButterKnife.bind(view);
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
    }
}
