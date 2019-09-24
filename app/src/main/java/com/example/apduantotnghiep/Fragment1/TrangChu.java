package com.example.apduantotnghiep.Fragment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apduantotnghiep.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TrangChu extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    private Tab1 tab1;
    private Tab2 tab2;
    private Tab3 tab3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Nỗi bật");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_trang_chu, container, false);
        tabLayout = (TabLayout) v.findViewById(R.id.tabs1);
        viewPager = (ViewPager) v.findViewById(R.id.view_pager1);
        tab1 = new Tab1();
        tab3 = new Tab3();
        tab2 = new Tab2();
        setFragment(tab1);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new Tab1(), "Tin mới");
        adapter.addFragment(new Tab2(), "Đánh giá");
        adapter.addFragment(new Tab3(), "Mẹo hay");


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }
    private void setFragment(Fragment fragmentHome) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.view_pager1, fragmentHome);
        fragmentTransaction.commit();
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
