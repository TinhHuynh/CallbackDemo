package com.huynhtinh1997.callbackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by huynhtinh1997 on 08/09/2017.
 */

public class FragmentHusband extends Fragment {

    private EditText mSalaryEditText;

    private WifeCallback mWifeCallback;

    /**
     * Nhận diện vợ để gọi
     */
    public void setWifeCallback(WifeCallback wifeCallback) {
        mWifeCallback = wifeCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_husband, container, false);
        mSalaryEditText = view.findViewById(R.id.input_salary);

        mSalaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            /**
             * khi nhập từng con số nhập lương, gọi vợ và đưa lương
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    if (!charSequence.toString().isEmpty()) {
                        int salary = Integer.parseInt(charSequence.toString());
                        callWifeAndGiveSalary(salary);
                    } else {
                        callWifeAndGiveSalary(0);
                    }
                } catch (NumberFormatException e) {
                    mSalaryEditText.setError("Lương nhiều quá, vợ không dám nhận :v");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;

    }

    private void callWifeAndGiveSalary(int salary) {
        mWifeCallback.onReceiveSalary(salary);
    }

}
