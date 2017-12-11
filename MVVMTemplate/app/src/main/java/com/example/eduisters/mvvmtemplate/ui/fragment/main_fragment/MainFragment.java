package com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eduisters.mvvmtemplate.R;
import com.example.eduisters.mvvmtemplate.ui.BaseFragment;

import butterknife.BindView;

/**
 * Created by Erik Duisters on 08-12-2017.
 */

public class MainFragment extends BaseFragment<MainFragmentViewModel> {
    @BindView(R.id.textView) TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        textView.setText(R.string.main_fragment);

        return v;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected Class getViewModelClass() {
        return MainFragmentViewModel.class;
    }
}
