package com.example.festival;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.WindowManager;
import android.widget.EditText;

import fragment.CallMeFragment;
import fragment.FestivalCategoryFragment;
import fragment.SmsHistoryFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] mTitle=new String[]{"节日短信","发送记录","你若安好"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        initviews();
    }

    private void initviews() {
        mTabLayout= (TabLayout) findViewById(R.id.id_tabLayout);
        mViewPager= (ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 1) return new SmsHistoryFragment();//当滑到第二个  显示第二个Fragment
                if (position == 2) return new CallMeFragment();
                return new FestivalCategoryFragment();
            }

            @Override
            public int getCount() {
                return mTitle.length;
            }

            //重写
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position];
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);//mTabLayout与mViewPager关联

    }



}
