package com.example.apmvc.passwordchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apmvc.passwordchecker.input.InputController;
import com.example.apmvc.passwordchecker.result.ResultController;
import com.example.apmvc.passwordchecker.service.PasswordCheckerService;

import de.greenrobot.event.EventBus;

public class PasswordCheckerActivity extends AppCompatActivity {

    InputController inputController;
    ResultController resultController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_checker_activity);

        inputController = (InputController) getSupportFragmentManager().findFragmentById(R.id.input_fragment);
        resultController = (ResultController) getSupportFragmentManager().findFragmentById(R.id.result_fragment);

    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(InputController.CheckPasswordEvent event) {
        // pass provided password to result controller
        resultController.calculateAndShowResult(event.providedPassword);
    }

}

