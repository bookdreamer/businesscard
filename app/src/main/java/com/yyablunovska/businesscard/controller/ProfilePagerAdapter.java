package com.yyablunovska.businesscard.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yyablunovska.businesscard.R;
import com.yyablunovska.businesscard.views.AboutFragment;
import com.yyablunovska.businesscard.views.ContactsFragment;
import com.yyablunovska.businesscard.views.ExperienceFragment;
import com.yyablunovska.businesscard.views.AchievementsFragment;

/**
 * @author yuliia.yablunovska on 1/20/18.
 */

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private static final int TABS_COUNT = 4;

    private static final int TAB_POSITION_ABOUT = 0;
    private static final int TAB_POSITION_EXPERIENCE = 1;
    private static final int TAB_POSITION_ACHIEVEMENTS = 2;
    private static final int TAB_POSITION_CONTACTS = 3;

    private Context mContext;

    public ProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB_POSITION_ABOUT:
                return new AboutFragment();
            case TAB_POSITION_EXPERIENCE:
                return new ExperienceFragment();
            case TAB_POSITION_ACHIEVEMENTS:
                return new AchievementsFragment();
            case TAB_POSITION_CONTACTS:
                return new ContactsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int titleRes = 0;
        switch (position) {
            case TAB_POSITION_ABOUT:
                titleRes = R.string.about_title;
                break;
            case TAB_POSITION_EXPERIENCE:
                titleRes = R.string.experience_title;
                break;
            case TAB_POSITION_ACHIEVEMENTS:
                titleRes = R.string.achievements_title;
                break;
            case TAB_POSITION_CONTACTS:
                titleRes = R.string.contacts_title;
                break;
        }
        return mContext.getString(titleRes);
    }
}
