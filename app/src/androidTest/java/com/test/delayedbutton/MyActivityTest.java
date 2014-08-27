package com.test.delayedbutton;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pt2121.delayedbutton.DelayedButton;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by prt2121 on 8/26/14.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

    private Activity mActivity;
    private DelayedButton mButton;
    private Button mButton2;

    @Before
    public void setup() {
        ActivityController<MyActivity> activityController = Robolectric.buildActivity(MyActivity.class)
                .create()
                .start()
                .resume()
                .visible();
        mActivity = activityController.get();
        //RelativeLayout layout = (RelativeLayout) LayoutInflater.from(mActivity).inflate(R.layout.activity_my, null);
        mButton = (DelayedButton) mActivity.findViewById(R.id.button);  //layout.findViewById(R.id.button);
        mButton2 = (Button) mActivity.findViewById(R.id.button2);
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(mActivity);
    }

    @Test
    public void testButtonsNotNull() {
        assertNotNull(mButton);
        assertNotNull(mButton2);
    }

    @Test
    public void testButtonNotEnable() {
        assertThat(mButton.isEnabled(), equalTo(false));
        assertThat(mButton.getVisibility(), equalTo(View.INVISIBLE));
        assertThat(mButton.isEnabled(), equalTo(false));
    }


}
