package com.example.eduisters.mvvmtemplate.ui.activity.main_activity;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eduisters.mvvmtemplate.R;
import com.example.eduisters.mvvmtemplate.ui.BaseActivity;
import com.example.eduisters.mvvmtemplate.ui.fragment.main_fragment.MainFragment;
import com.example.eduisters.mvvmtemplate.util.MenuUtil;
import com.example.eduisters.mvvmtemplate.util.MyMenuItem;

import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

//TODO: Save state in case the activity is destroyed because of limited resources
public class MainActivity extends BaseActivity<MainActivityViewModel>
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG_MAIN_FRAGMENT = MainFragment.class.getSimpleName();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.fragmentPlaceholder) FrameLayout fragmentPlaceHolder;
    ImageView headerImageView;
    TextView headerTitle;
    TextView headerSubTitle;

    List<MyMenuItem> optionsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        headerImageView = headerView.findViewById(R.id.nav_header_image);
        headerTitle = headerView.findViewById(R.id.nav_header_title);
        headerSubTitle = headerView.findViewById(R.id.nav_header_sub_title);

        Fragment frag = getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);

        if ( frag == null ) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentPlaceholder, new MainFragment(), TAG_MAIN_FRAGMENT)
                    .commit();
        }

        Observer<MainActivityViewState> observer = new Observer<MainActivityViewState>() {
            @Override
            public void onChanged(@Nullable MainActivityViewState mainActivityViewState) {
                render(mainActivityViewState);
            }
        };

        viewModel.getViewState().observe(this, observer);
    }

    private void render(MainActivityViewState viewState) {
        Timber.i("render(%s)", viewState);

        headerImageView.setImageResource(viewState.navHeaderDrawableId);
        headerTitle.setText(viewState.navHeaderTitleId);
        headerSubTitle.setText(viewState.navheaderSubTitleId);

        MenuUtil.updateMenu(navigationView.getMenu(), viewState.navigationItems);

        optionsMenu = viewState.optionsMenu;
        invalidateOptionsMenu();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainActivityViewModel> getViewModelClass() {
        return MainActivityViewModel.class;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuUtil.updateMenu(menu, optionsMenu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
