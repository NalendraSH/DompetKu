package com.nanz.dompetku.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nanz.dompetku.Fragments.IdentitasFragment;
import com.nanz.dompetku.Fragments.UangFragment;

/**
 * Created by Nanz on 11/05/2017.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter{
    String title[] = new String[]{
            "Identitas", "Keuangan"
    };

    public TabFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new IdentitasFragment();
                break;
            case 1:
                fragment = new UangFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return title[position];
    }

    @Override
    public int getCount(){
        return title.length;
    }
}
