package com.huynhtinh1997.callbackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huynhtinh1997 on 08/09/2017.
 */

/**
 * Vợ sẽ thực thi interface WifeCallback
 */
public class FragmentWife extends Fragment implements WifeCallback {

    private TextView mSalaryTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wife, container, false);
        mSalaryTextView = view.findViewById(R.id.text_salary);

        return view;
    }


    @Override
    public void onReceiveSalary(int salary) {
        updateUI(salary);
    }

    /**
     * Cập nhật lương lên UI
     */
    private void updateUI(int salary){
        String result = "Cô Bách nhận được: " + salary;
        mSalaryTextView.setText(result);
    }

}
