package ru.shagi.lookart_clean.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.shagi.lookart_clean.R;
import ru.shagi.lookart_clean.di.component.DaggerAppComponent;
import ru.shagi.lookart_clean.di.component.DaggerArtistRecyclerComponent;
import ru.shagi.lookart_clean.view.adapter.TabAdapter;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setUI();
    }

    private void setUI() {
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();

        TabAdapter adapter = new TabAdapter(fragmentManager, 2);

        adapter.setTitle(0, "Исполнители");
        adapter.setTitle(1, "qweqwe");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
/*
        MenuItem splashItem = menu.findItem(R.id.action_splash);
        splashItem.setChecked(preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE));

        MenuItem ask_cache = menu.findItem(R.id.do_not_ask_again);
        ask_cache.setChecked(preferenceHelper.getBoolean(PreferenceHelper.DO_NOT_ASC_AGAIN));*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*
        if (id == R.id.action_splash) {
            item.setChecked(!item.isChecked());
            preferenceHelper.putBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE, item.isChecked());
            return true;
        }

        if (id == R.id.do_not_ask_again) {
            item.setChecked(!item.isChecked());
            preferenceHelper.putBoolean(PreferenceHelper.DO_NOT_ASC_AGAIN, item.isChecked());
        }

        if (id == R.id.clean_cache) {
            preferenceHelper.putBoolean(PreferenceHelper.DO_NOT_ASC_AGAIN, false);
            preferenceHelper.putBoolean(PreferenceHelper.CACHE_DOWNLOAD_ACCEPTED, false);
            cacheHelper.clean();
        }
        */

        if (id == R.id.feedback) {
            Intent intent = new Intent(Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto", "javashagi@yandex.ru", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Re: LookArt");
            intent.putExtra(Intent.EXTRA_TEXT, "LookArt YAPP");

            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void openInfoFragment(){
        viewPager.setCurrentItem(1);
    }
}
