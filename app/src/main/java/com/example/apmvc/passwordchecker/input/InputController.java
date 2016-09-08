package com.example.apmvc.passwordchecker.input;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apmvc.passwordchecker.R;

import de.greenrobot.event.EventBus;

/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class InputController extends Fragment implements InputView.OnCheckButtonClickListener {

    InputView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        InputView view = (InputView) inflater.inflate(R.layout.input_view, container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners(this.view);
    }

    private void initListeners(InputView view) {
        view.setOnCheckButtonClicked(this);
    }

    @Override
    public void onCheckButtonClicked() {
        String providedPassword = view.getPassword();
        EventBus.getDefault().post(new CheckPasswordEvent(providedPassword));

    }

    public static class CheckPasswordEvent {
        public String providedPassword;

        public CheckPasswordEvent(String pwd) {
            this.providedPassword = pwd;
        }
    }

}
