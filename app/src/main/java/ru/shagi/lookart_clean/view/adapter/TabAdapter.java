package ru.shagi.lookart_clean.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.shagi.lookart_clean.view.fragment.ArtistInfoFragment;
import ru.shagi.lookart_clean.view.fragment.ArtistsRecyclerFragment;


public class TabAdapter extends FragmentStatePagerAdapter {

    private static final int ARTISTS_RECYCLER_FRAGMENT = 0;
    private static final int ARTIST_INFO_FRAGMENT = 1;

    private final int count;
    private final List<String> titles = new ArrayList<>(Arrays.asList(null, null, null));


    public TabAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ARTISTS_RECYCLER_FRAGMENT: {
                return new ArtistsRecyclerFragment();
            }
            case ARTIST_INFO_FRAGMENT: {
                return new ArtistInfoFragment();
            }
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setTitle(int position, String name) {
        titles.set(position, name);
    }
}
