package com.example.credpriyank;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Context;
import android.view.View;
public class Fx {

    public static void slide_down(Context ctx, View v){
        int initialHeight = v.getMeasuredHeight();
        v.setVisibility(View.VISIBLE);
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        a.setDuration(600);//(int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }

    }

    public static void slide_up(Context ctx, View v){
        int initialHeight = v.getMeasuredHeight();
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
        v.setVisibility(View.GONE);
    }
}
