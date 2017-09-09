package com.huynhtinh1997.callbackdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class HouseActivity extends AppCompatActivity {

    private HusbandFragment mHusbandFragment;
    private WifeFragment mWifeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        initFragments();
    }

    /**
     * Khởi tạo và host 2 fragment vợ chồng vào activity nhà
     */
    private void initFragments() {
        mHusbandFragment = new HusbandFragment();
        mWifeFragment = new WifeFragment();

        mHusbandFragment.setWifeCallback(mWifeFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_fragment_husband, mHusbandFragment)
                .add(R.id.container_fragment_wife, mWifeFragment)
                .commit();
    }

}
