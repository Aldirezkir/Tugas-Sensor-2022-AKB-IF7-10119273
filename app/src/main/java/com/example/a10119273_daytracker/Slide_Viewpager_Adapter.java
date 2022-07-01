package com.example.a10119273_daytracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
/** * 10119273
 * ALDI REZEKI RAMDANI
 * IF-7 **/

public class Slide_Viewpager_Adapter extends PagerAdapter {
    Context ctx;

    public Slide_Viewpager_Adapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);

        ImageView logo=view.findViewById(R.id.logo);
        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);

        TextView tittle=view.findViewById(R.id.tittle_splash);
        TextView desc=view.findViewById(R.id.desc_splash);

        ImageView next=view.findViewById(R.id.next);
        ImageView back=view.findViewById(R.id.back);

        Button btn_start=view.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ctx,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });


        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.img_splash1);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);

                tittle.setText("Day Tracker");
                desc.setText("Find Your Location");
                back.setVisibility(view.GONE);
                next.setVisibility(view.VISIBLE);
                break;

            case 1:
                logo.setImageResource(R.drawable.img_splash2);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);

                tittle.setText("");
                desc.setText("Membantu anda Melacak Lokasi");
                back.setVisibility(view.VISIBLE);
                next.setVisibility(view.VISIBLE);
                break;

            case 2:
                logo.setImageResource(R.drawable.img_splash3);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);

                tittle.setText("");
                desc.setText("Temukan Lokasi anda Sekarang");
                back.setVisibility(view.VISIBLE);
                next.setVisibility(view.GONE);
                break;

        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
