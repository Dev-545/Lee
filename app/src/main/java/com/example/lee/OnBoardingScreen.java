package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class OnBoardingScreen extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotIndicator;
    ViewPageAdapter viewPageAdapter;
    Button prevbt, nxtbt, skipbt;
    TextView[] dots;

    ViewPager.OnPageChangeListener viewPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setDotIndicator(position);
            if (position>0){
                prevbt.setVisibility(View.VISIBLE);
            }
            else{
                prevbt.setVisibility(View.INVISIBLE);
            }
            if (position==2){
                nxtbt.setText(R.string.sp_nxt_btn_ch);
            }
            else{
                nxtbt.setText(R.string.sp_nxt_btn);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_boarding_screen);
        prevbt =findViewById(R.id.o_pre);
        nxtbt = findViewById(R.id.o_next);
        skipbt = findViewById(R.id.o_skip);
        prevbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(0)>0){
                    slideViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });
        nxtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) <2){
                    slideViewPager.setCurrentItem(getItem(1), true);
                }else{
                    Intent intent = new Intent(OnBoardingScreen.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        skipbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingScreen.this, LoginScreen.class);
                startActivity(intent);
                finish();

            }
        });
        slideViewPager =(ViewPager) findViewById(R.id.slideViewPager);
        dotIndicator =(LinearLayout)  findViewById(R.id.idindicator);

        viewPageAdapter = new ViewPageAdapter(this);
        slideViewPager.setAdapter(viewPageAdapter);

        setDotIndicator(0);
        slideViewPager.addOnPageChangeListener(viewPageListener);

    }

    public void setDotIndicator(int position) {
        dots = new TextView[3];
        dotIndicator.removeAllViews();
        for (int i=0; i< dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.Blue, getApplicationContext().getTheme()));
            dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.Yellow, getApplicationContext().getTheme()));
    }
    private int getItem(int i){
        return slideViewPager.getCurrentItem() + i;
    }
}
