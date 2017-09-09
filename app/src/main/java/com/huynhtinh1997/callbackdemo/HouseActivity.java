package com.huynhtinh1997.callbackdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class HouseActivity extends AppCompatActivity {

    private FragmentHusband mFragmentHusband;
    private FragmentWife mFragmentWife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        initFragments();
    }

    /**
     * khởi tạo và host 2 fragment vợ chồng vào activity nhà
     */
    private void initFragments() {
        mFragmentHusband = new FragmentHusband();
        mFragmentWife = new FragmentWife();

        mFragmentHusband.setWifeCallback(mFragmentWife);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_fragment_husband, mFragmentHusband)
                .add(R.id.container_fragment_wife, mFragmentWife)
                .commit();
    }

}
