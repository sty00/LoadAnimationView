package com.alextam.android.loadanimationview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Alex.Tam on 2015/3/13.
 */
public class RotateTrigonLoadView extends RelativeLayout
{
    private ImageView im_right,im_left,im_center;


    public RotateTrigonLoadView(Context context)
    {
        this(context, null);
    }

    public RotateTrigonLoadView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public RotateTrigonLoadView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(context,R.layout.rotate_radar_view_main,this);

        im_center = (ImageView)view.findViewById(R.id.im_rotate_rd_center);

        setAnimators(context);

    }

    private void setAnimators(Context context)
    {
        Animation rotateAnimation = AnimationUtils.loadAnimation(context,R.anim.anim_rotate);
        im_center.setAnimation(rotateAnimation);

        //设置X轴
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(im_center,"scaleX",1.0f,1.5f);
        scaleXAnimator.setDuration(1000);
        scaleXAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        scaleXAnimator.setRepeatMode(ObjectAnimator.REVERSE);

        //设置Y轴i
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(im_center,"scaleY",1.0f,1.2f);
        scaleYAnimator.setDuration(1500);
        scaleYAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        scaleYAnimator.setRepeatMode(ObjectAnimator.REVERSE);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleXAnimator,scaleYAnimator);
        rotateAnimation.start();
        set.start();

    }




}
