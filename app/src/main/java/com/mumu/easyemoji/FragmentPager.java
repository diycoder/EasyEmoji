package com.mumu.easyemoji;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by MuMu on 2016/11/2/0002.
 */

public class FragmentPager extends FragmentStatePagerAdapter {
    private final List<EmoJiFragment> fragments;

    public FragmentPager(FragmentManager fm, List<EmoJiFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
