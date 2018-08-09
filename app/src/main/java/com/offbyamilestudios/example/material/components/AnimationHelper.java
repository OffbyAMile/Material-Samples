package com.offbyamilestudios.example.material.components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;

import com.google.android.material.animation.AnimationUtils;

public class AnimationHelper extends AnimationUtils {

    private static final AnimatorSet animatorSet = new AnimatorSet();
    private static boolean isHidden = false;

    public AnimationHelper() {

        animatorSet.addListener(

                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("Anim", "onAnimationStart");

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("Anim", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }
        );

    }


    public static void animateFabShow(View view) {
        isHidden = !isHidden;

        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        animatorSet.setDuration(200)
                .playTogether(

                        ObjectAnimator.ofFloat(view, View.SCALE_X, 0f, 1f),
                        ObjectAnimator.ofFloat(view, View.SCALE_Y, 0f, 1f)

                );

        animatorSet.addListener(

                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("Anim", "onAnimationStart");

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("Anim", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }
        );

        new AnimatorSet();

    }

}
