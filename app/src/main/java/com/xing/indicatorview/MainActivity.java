package com.xing.indicatorview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xing.indicatorviewlib.IndicatorView;

public class MainActivity extends AppCompatActivity {

    private int[] resId = {R.drawable.ic_1, R.drawable.ic_3, R.drawable.ic_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IndicatorView circleIndicator = (IndicatorView) findViewById(R.id.indicator_circle);
        IndicatorView numberIndicator = (IndicatorView) findViewById(R.id.indicator_number);
        IndicatorView letterIndicator = (IndicatorView) findViewById(R.id.indicator_letter);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(this, resId));
        circleIndicator.setupViewPager(viewPager);
        numberIndicator.setupViewPager(viewPager);
        letterIndicator.setupViewPager(viewPager);
    }


    class ViewPagerAdapter extends PagerAdapter {

        private Context context;

        private int[] url;

        public ViewPagerAdapter(Context context, int[] url) {
            this.context = context;
            this.url = url;
        }

        @Override
        public int getCount() {
            return url.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(url[position]);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView(container.getChildAt(position));
        }
    }


}
