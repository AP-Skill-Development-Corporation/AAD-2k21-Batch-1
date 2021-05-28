package com.example.dummywhtsup;

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
TabLayout tab;
ViewPager viewPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.mytab);
        viewPage=findViewById(R.id.myViewPager);
        viewPage.setAdapter(new MyFragementPagerAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPage);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "TabSelected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();

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
    public class MyFragementPagerAdapter extends FragmentPagerAdapter{
        String titles[]={"Chats","Status","Calls"};
        public MyFragementPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new ChatsFragment();
            }
            if (position==1){
                return new StatusFragment();
            }
            if (position==2){
                return  new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
        /*if you get the error then tap the alt+enter on the redline*/
    }
}