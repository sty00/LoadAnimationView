package com.alextam.android.loadanimationview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Alex.Tam on 2015/3/13.
 */
public class FloatTroopsLoadView extends LinearLayout{
    private Bitmap bmRound;
    private ImageView imgOne,imgTwo,imgThree;
    private View view;
    private Animator animatorA,animatorB,animatorC;


    public FloatTroopsLoadView(Context context)
    {
        this(context, null);
    }

    public FloatTroopsLoadView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public FloatTroopsLoadView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        view = View.inflate(context,R.layout.float_troops_view_main,this);

        setBackgroundColor(Color.TRANSPARENT);

        imgOne = (ImageView)view.findViewById(R.id.imOne_float_troops);
        imgTwo = (ImageView)view.findViewById(R.id.imTwo_float_troops);
        imgThree = (ImageView)view.findViewById(R.id.imThree_float_troops);

        setAnimatorLoad(context);
    }

    private void setAnimatorLoad(Context context)
    {
        //通过XML文件创建属性动画
        animatorA = AnimatorInflater.loadAnimator(context,R.animator.animator_scalexy);
        animatorB = AnimatorInflater.loadAnimator(context,R.animator.animator_scalexy);
        animatorC = AnimatorInflater.loadAnimator(context,R.animator.animator_scalexy);

        //设置该属性动画的目标
        animatorA.setTarget(imgOne);
        //设置插值器,此处是先加速后减速的线性插值器
        animatorA.setInterpolator(new AccelerateDecelerateInterpolator());

        animatorB.setTarget(imgTwo);
        //设置动画延迟启动的时间为300ms
        animatorB.setStartDelay(300);
        animatorB.setInterpolator(new AccelerateDecelerateInterpolator());

        animatorC.setTarget(imgThree);
        animatorC.setStartDelay(800);
        animatorC.setInterpolator(new AccelerateDecelerateInterpolator());

        //启动动画
        startAnimation();

    }

    /**
     *  Cancel Animators取消动画
      */
    public void cancelAnimation()
    {
        if(animatorA != null) animatorA.cancel();
        if(animatorB != null) animatorB.cancel();
        if(animatorC != null) animatorC.cancel();
    }

    /**
     * start animation开始动画
     */
    public void startAnimation()
    {
        if(animatorA != null && !animatorA.isRunning())
        {
            animatorA.start();
            animatorB.start();
            animatorC.start();
        }
    }




















}
