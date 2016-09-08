package com.example.apmvc.passwordchecker.result;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apmvc.passwordchecker.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class ResultTextualView extends LinearLayout {

    @BindView(R.id.result)
    TextView result;

    @BindString(R.string.textual_result)
    String resultMessage;

    public ResultTextualView(Context context) {
        super(context);
    }

    public ResultTextualView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResultTextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void showResult(float result) {
        this.result.setText(String.format(resultMessage, result));
    }

}
