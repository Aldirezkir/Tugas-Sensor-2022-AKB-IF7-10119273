package com.example.a10119273_daytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
/** * 10119273
 * ALDI REZEKI RAMDANI
 * IF-7 **/
public class SlideActivity extends AppCompatActivity {
    ViewPager viewPager;
    Slide_Viewpager_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        viewPager=findViewById(R.id.viewPager);
        adapter=new Slide_Viewpager_Adapter(this);
        viewPager.setAdapter(adapter);
    }
}