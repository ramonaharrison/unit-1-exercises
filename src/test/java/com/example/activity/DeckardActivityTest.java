package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class DeckardActivityTest {

    DeckardActivity mActivity;
    ActivityController<DeckardActivity> mAC;

    @Before
    public void setUp() throws Exception {
        // uncomment the following line to pass test 00
//        mActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();
//        mAC = Robolectric.buildActivity(DeckardActivity.class).create().start();
    }

    @Test
    public void test01ActivityExists() throws Exception {
        assertTrue(mActivity != null);
    }

    @Test
    public void test02AddTextViewToLayout() throws Exception {
        int textViewId = mActivity.getResources().getIdentifier("text", "id", mActivity.getPackageName());
        assertTrue("TextView(@+id/text) not found", textViewId > 0);
    }

    @Test
    public void test03SetTextViewValueToTODO() throws Exception {
        int textViewId = mActivity.getResources().getIdentifier("text", "id", mActivity.getPackageName());
        assertTrue("TextView(@+id/text) not found", textViewId > 0);
        TextView tv = (TextView) mActivity.findViewById(textViewId);
        assertEquals("Help, I'm stuck in an Android Factory!", tv.getText());
    }

    @Test
    public void test04AddImageViewToLayout() throws Exception {
        int imageViewId = mActivity.getResources().getIdentifier("image", "id", mActivity.getPackageName());
        assertTrue("ImageView(@+id/image) not found", imageViewId > 0);
    }

    @Test
    public void test05SetImageViewToHelloGreen() throws Exception {
        int imageViewId = mActivity.getResources().getIdentifier("image", "id", mActivity.getPackageName());
        assertTrue("ImageView(@+id/image) not found", imageViewId > 0);
        ImageView iv = (ImageView) mActivity.findViewById(imageViewId);

        Bitmap bm = ((BitmapDrawable) iv.getDrawable()).getBitmap();

        float deviceDensity = mActivity.getResources().getDisplayMetrics().density;

        assertEquals("actual height value: " + bm.getHeight(), (deviceDensity * 20), (float) bm.getHeight(), 0.01);
        assertEquals("actual width value: " + bm.getWidth(), (deviceDensity * 20), (float) bm.getWidth(), 0.01);

        // TODO enable later using ShadowDrawable or remove
        // http://stackoverflow.com/questions/18008044/assert-imageview-was-loaded-with-specific-drawable-resource-id
        //assertEquals(0xFF00FF00, bm.getPixel(0, 0));
    }

    @Test
    public void test06EditTextActivityExists() throws Exception {
        ClassLoader cl = this.getClass().getClassLoader();
        cl.loadClass("com.example.activity.EditTextActivity");
    }

    @Test
    public void test07EditTextActivityLayoutExists() throws Exception {
        int activity_edit_text_id = mActivity.getResources().getIdentifier("activity_edit_text", "layout", mActivity.getPackageName());
        assertTrue("res.layout.activity_edit_text not found", activity_edit_text_id > 0);
        // TODO inflate layout in some way? check robolectric docs
        View layout = mActivity.findViewById(activity_edit_text_id);
        assertTrue("res.layout.activity_edit_text should be a LinearLayout instead of RelativeLayout", layout instanceof LinearLayout);
    }

}
