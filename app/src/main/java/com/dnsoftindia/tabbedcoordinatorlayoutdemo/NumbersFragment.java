package com.dnsoftindia.tabbedcoordinatorlayoutdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ganesha on 2/22/2016.
 */
public class NumbersFragment extends Fragment {

    private LinearLayout llViews;

    public NumbersFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_numbers, container, false);
        llViews = (LinearLayout) v.findViewById(R.id.llViews);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i=0; i<=9; i++) {
            TextView tv = new TextView(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, (int) convertDpToPixel(40, getActivity())
            );
            lp.setMargins((int) convertDpToPixel(10, getActivity()),
                    (int) convertDpToPixel(10, getActivity()),
                    (int) convertDpToPixel(10, getActivity()),
                    (int) convertDpToPixel(10, getActivity()));
            tv.setLayoutParams(lp);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setBackgroundColor(Color.parseColor("#4CAF50"));
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
            tv.setText(i+"");

            llViews.addView(tv);
        }
    }

    /**
     * This method convets dp unit to equivalent device specific value in
     * pixels.
     *
     * @param dp
     *            A value in dp(Device independent pixels) unit. Which we need
     *            to convert into pixels
     * @param context
     *            Context to get resources and device specific display metrics
     * @return A float value to represent Pixels equivalent to dp according to
     *         device
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        // Log.i(tag, "DP : " + dp + " converted to " + px + " pixels");
        return px;
    }
}
