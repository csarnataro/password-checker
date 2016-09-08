package com.example.apmvc.passwordchecker.input;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.apmvc.passwordchecker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class InputView extends LinearLayout {

    protected OnCheckButtonClickListener onCheckButtonClickedListener;

    @BindView(R.id.input_text)
    EditText password;

    @BindView(R.id.check_button)
    Button checkButton;

    public InputView(Context context) {
        super(context);
    }

    public InputView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }


    public String getPassword() {
        return password.getText().toString();
    }


    @OnClick(R.id.check_button)
    void onCheckButtonClicked(Button button) {
        onCheckButtonClickedListener.onCheckButtonClicked();
    }


    public void setOnCheckButtonClicked(final OnCheckButtonClickListener listener) {
        onCheckButtonClickedListener = listener;
     }

    public interface OnCheckButtonClickListener {
        void onCheckButtonClicked();
    }

}
