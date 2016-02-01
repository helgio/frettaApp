package com.trainstation.frettirtest2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Helgi on 17/01/16.
 */
public class ViewPageAdapter extends FragmentStatePagerAdapter{
    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new MyViewPagerFragment();
            case 1:
            default:
                return new MyViewPagerFragment2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
