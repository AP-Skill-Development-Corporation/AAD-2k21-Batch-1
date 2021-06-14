package com.example.mywhtsupapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout myTab;
ViewPager myViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTab=findViewById(R.id.tab);
        myViewPager=findViewById(R.id.viewPage);
        myViewPager.setAdapter(new MyFragmentpager(getSupportFragmentManager()));
        myTab.setupWithViewPager(myViewPager);
        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Selected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "UnSelected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "ReSelected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class MyFragmentpager extends FragmentPagerAdapter{

String tabTitles[]={"Chats","Status","Calls"};
        public MyFragmentpager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new ChatsFragment();
            }if (position==1)
            {
                return new StatusFragment();
            }
            if (position==2){
                return new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }

}