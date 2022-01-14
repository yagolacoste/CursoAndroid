package com.cursoandroid11.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager viewPager=findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        CovidNewsFragment covidnewsFragment=new CovidNewsFragment();
        BusinessNewsFragment businessNewsFragment=new BusinessNewsFragment();
        EntertainmentNewsFragment entertainmentNewsFragment=new EntertainmentNewsFragment();

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),0);//necesita adaptar fragment
        viewPagerAdapter.addFragment(covidnewsFragment,"Covid-19");
        viewPagerAdapter.addFragment(businessNewsFragment,"Business");
        viewPagerAdapter.addFragment(entertainmentNewsFragment,"Entertainment");
        viewPager.setAdapter(viewPagerAdapter);
    }
}


class ViewPagerAdapter extends FragmentPagerAdapter{
        List<Fragment> fragmentList=new ArrayList<Fragment>();
        List<String> fragmentTitle=new ArrayList<>();
    public  ViewPagerAdapter(FragmentManager fm, int behaviour){
        super(fm,behaviour);
    }

    void addFragment(Fragment fragment,String title){

        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

}