package com.example.activity;

import com.example.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class DeckardActivityTest {

    DeckardActivity mActivity;

    @Test
    public void testSomething() throws Exception {
        mActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();
        assertTrue(mActivity != null);
    }

    @Test
    public void testOtherThing() throws Exception {
        System.out.println(R.id.text);
        //TextView tv = mActivity.findViewById(R.id.text);
        assertTrue(true);
    }

}
