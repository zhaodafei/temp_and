package com.fei.myfei.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fei.myfei.entity.PhoneInfo;
import com.fei.myfei.fragment.Fei14DynamicFragment;

import java.util.List;

public class MobilePagerAdapter extends FragmentPagerAdapter {

    private final List<PhoneInfo> myPhoneList;

    public MobilePagerAdapter(@NonNull FragmentManager fm, List<PhoneInfo> phoneList) {
        // 会将当前fragment设置为Resume的状态,把上个fragment设置成Start的状态
        // 从而可以通过fragment的OnResume()来懒加载数据
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.myPhoneList = phoneList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        PhoneInfo info = myPhoneList.get(position);
        return Fei14DynamicFragment.newInstance(position, info.pic, info.description);
    }

    @Override
    public int getCount() {
        return myPhoneList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myPhoneList.get(position).name;
    }
}
