package com.pt2121.delayedbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;


/**
 * Created by pt2121 on 7/25/2014.
 */
public class DelayedButton extends Button {

    public DelayedButton(Context context) {
        super(context);
        init(context, null);
    }

    public DelayedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DelayedButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setEnabled(false);

        if(attrs == null) return;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DelayedButton,
                0, 0);
        final int milliSecond;
        try {
            milliSecond = a.getInt(R.styleable.DelayedButton_delay, 0);
        } finally {
            a.recycle();
        }

        postDelayed(new Runnable() {
            @Override
            public void run() {
                setEnabled(true);
                invalidate();
            }
        }, milliSecond);
    }
}
