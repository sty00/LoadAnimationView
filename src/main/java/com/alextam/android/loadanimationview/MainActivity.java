package com.alextam.android.loadanimationview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity
{
    private ImageView imgViewAlp;
    private FloatTroopsLoadView floatTroopsLoadView;
    private RotateTrigonLoadView hitBallsView;
    private Button btn_ft_tps,btn_ap_scal,btn_rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewAlp = (ImageView)findViewById(R.id.im_alpha_scale);
        floatTroopsLoadView =
                (FloatTroopsLoadView)findViewById(R.id.view_float_troops);
        hitBallsView =
                (RotateTrigonLoadView)findViewById(R.id.view_hit_balls);

        btn_ft_tps = (Button)findViewById(R.id.btn_float_troops);
        btn_ap_scal = (Button)findViewById(R.id.btn_alpha_scale);
        btn_rotate = (Button)findViewById(R.id.btn_rotate_trigon);

        btn_ft_tps.setOnClickListener(new MyOnClickListener());
        btn_ap_scal.setOnClickListener(new MyOnClickListener());
        btn_rotate.setOnClickListener(new MyOnClickListener());

    }


    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            if(v == btn_ft_tps)
            {
                hitBallsView.setVisibility(View.GONE);
                imgViewAlp.setVisibility(View.GONE);
                floatTroopsLoadView.setVisibility(View.VISIBLE);
                floatTroopsLoadView.startAnimation();
            }
            else if(v == btn_ap_scal)
            {
                hitBallsView.setVisibility(View.GONE);
                floatTroopsLoadView.setVisibility(View.GONE);
                imgViewAlp.setVisibility(View.VISIBLE);
                setAlphaScaleLoad(imgViewAlp);
            }
            else if(v == btn_rotate)
            {
                imgViewAlp.setVisibility(View.GONE);
                floatTroopsLoadView.setVisibility(View.GONE);
                hitBallsView.setVisibility(View.VISIBLE);

            }

        }
    }

    //设置透明度渐变和大小渐变同时启动的动画
    private void setAlphaScaleLoad(View view)
    {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"alpha",0.0f,1.0f);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view,"scaleX",1.0f,2.5f);
        animatorX.setDuration(2000);
        animatorX.setObjectValues();
        animatorX.setRepeatMode(ObjectAnimator.REVERSE);
        animatorX.setRepeatCount(ObjectAnimator.INFINITE);

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view,"scaleY",1.0f,2.5f);
        animatorY.setDuration(2000);
        animatorY.setObjectValues();
        animatorY.setRepeatMode(ObjectAnimator.REVERSE);
        animatorY.setRepeatCount(ObjectAnimator.INFINITE);

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator[] animators = {animatorX,animatorY,objectAnimator};
        //playTogether() 设置同时启动数组中的所有动画
        set.playTogether(animators);
        set.start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
