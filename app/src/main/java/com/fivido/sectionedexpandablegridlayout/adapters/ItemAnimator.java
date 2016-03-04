package com.fivido.sectionedexpandablegridlayout.adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by bpncool on 2/27/2016.
 */
public class ItemAnimator extends DefaultItemAnimator {

    private static final DecelerateInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();


    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        if (holder.getItemViewType() == SectionedExpandableGridAdapter.VIEW_TYPE_ITEM) {
            runEnterAnimation(holder);
        }
        dispatchAddFinished(holder);
        return false;
    }

    private void runEnterAnimation(final RecyclerView.ViewHolder holder) {
        holder.itemView.setAlpha(0);
        holder.itemView.animate()
                .alpha(1)
                .setInterpolator(DECELERATE_INTERPOLATOR)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        dispatchAddFinished(holder);
                    }
                })
                .start();
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        if (holder.getItemViewType() == SectionedExpandableGridAdapter.VIEW_TYPE_SECTION) {
            runRemoveAnimation(holder);
        }
        dispatchRemoveFinished(holder);
        return false;
    }

    private void runRemoveAnimation(final RecyclerView.ViewHolder holder) {
        holder.itemView.animate()
                .alpha(0)
                .setInterpolator(ACCELERATE_INTERPOLATOR)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                       dispatchAddFinished(holder);
                    }
                })
                .start();
    }
}
