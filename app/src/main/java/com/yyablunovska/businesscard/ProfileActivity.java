package com.yyablunovska.businesscard;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yyablunovska.businesscard.controller.ProfilePagerAdapter;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private static final String CONTACT_URI = "tel:+18885553333";

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mPager = findViewById(R.id.view_pager);
        mPager.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager(), this));

        final TabLayout tabs = findViewById(R.id.tab_layout);
        tabs.setupWithViewPager(mPager);

        final Button callButton = findViewById(R.id.contact_btn);
        callButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.contact_btn) {
            final Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(CONTACT_URI));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.e(TAG, "No activity to open Uri: " + CONTACT_URI);
            }
        }
    }
}
