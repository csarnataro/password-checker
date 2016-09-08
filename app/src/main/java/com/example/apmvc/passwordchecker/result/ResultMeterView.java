package com.example.apmvc.passwordchecker.result;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apmvc.passwordchecker.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import pl.pawelkleczkowski.customgauge.CustomGauge;

/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class ResultMeterView extends LinearLayout {

    @BindView(R.id.gauge3)
    CustomGauge gauge;

    @BindView(R.id.value)
    TextView value;

    @BindString(R.string.meter_result)
    String resultMessage;

    public ResultMeterView(Context context) {
        super(context);
    }

    public ResultMeterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResultMeterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void showResult(float result) {
        this.gauge.setValue((int) result);
        this.value.setText(String.format(resultMessage, result));
    }

}
