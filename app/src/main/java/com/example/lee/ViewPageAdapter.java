package com.example.lee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

public class ViewPageAdapter extends PagerAdapter {

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    Context context;

    int[] sliderAllAnimation ={R.raw.splash1, R.raw.splash2,R.raw.splash3};
    int[] sliderAllTitle ={R.string.sp_title1, R.string.sp_title2, R.string.sp_title3};
    int[] sliderAllDesc ={R.string.sp_desc1, R.string.sp_desc2, R.string.sp_desc3};


    @Override
    public int getCount() {
        return sliderAllTitle.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout) object;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view  = layoutInflater.inflate(R.layout.slider_screen, container, false);

        LottieAnimationView sliderAnimation = (LottieAnimationView) view.findViewById(R.id.slideAnimate);
        TextView sliderTitle = (TextView) view.findViewById(R.id.slideTitle);
        TextView sliderDesc = (TextView) view.findViewById(R.id.slideDesc);

        sliderAnimation.setAnimation(sliderAllAnimation[position]);
        sliderTitle.setText(this.sliderAllTitle[position]);
        sliderDesc.setText(this.sliderAllDesc[position]);
        container.addView(view);

        return view;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
