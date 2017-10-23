package com.bagicode.www.bagisliderview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bagicode.www.bagisliderview._sliders.FragmentSlider;
import com.bagicode.www.bagisliderview._sliders.SliderIndicator;
import com.bagicode.www.bagisliderview._sliders.SliderPagerAdapter;
import com.bagicode.www.bagisliderview._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();
    }


    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/boliyohutuo.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/bugisa.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/airterjun_taludaa.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/botutonuo.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/pulau_cinta.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/otanaha.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/olele.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/pulau_saronde.jpg"));



        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
