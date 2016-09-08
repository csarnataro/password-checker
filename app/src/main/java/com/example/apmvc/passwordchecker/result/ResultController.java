package com.example.apmvc.passwordchecker.result;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apmvc.passwordchecker.R;
import com.example.apmvc.passwordchecker.service.PasswordCheckerService;

import butterknife.ButterKnife;

/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class ResultController extends Fragment{

    private PasswordCheckerService passwordCheckerService;

    ResultMeterView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ResultMeterView view = (ResultMeterView) inflater.inflate(R.layout.result_meter_view, container, false);
        this.view = view;
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        passwordCheckerService = new PasswordCheckerService();
        initListeners(this.view);
    }

    private void initListeners(ResultMeterView view) {
        // ... it does nothing so far
    }

    public void calculateAndShowResult(String providedPassword) {
        float strength = passwordCheckerService.getStrength(providedPassword);
        view.showResult(strength);

    }
}
