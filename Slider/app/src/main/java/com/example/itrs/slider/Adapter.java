package com.example.itrs.slider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by itrs on 4/11/2018.
 */

public class Adapter extends BaseAdapter {
    Context context;
    final String[] offertitle;
    final String[] OfferDes;
    final  int [] testImages;
    final int [] Price;
    LayoutInflater inflter;
    static AdapterViewFlipper adapterViewFlipper;

    public Adapter(Context applicationContext, String[] offertitle,String [] OfferDes, int[] testImages, int[] Price, AdapterViewFlipper adapterViewFlipper) {
        this.context = applicationContext;
        this.offertitle = offertitle;
        this.OfferDes = OfferDes;
        this.testImages = testImages;
        this.Price=Price;
        this.adapterViewFlipper=adapterViewFlipper;

        inflter = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return offertitle.length;
    }

    @Override
    final public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.activity_main, null);
       final TextView title = (TextView) view.findViewById(R.id.offername);
        final  TextView desc = (TextView) view.findViewById(R.id.desc);
        final  TextView price = (TextView) view.findViewById(R.id.price);
        final ImageView testImage = (ImageView) view.findViewById(R.id.Imageview);

        Button right = (Button) view.findViewById(R.id.btnRight);
        Button left = (Button) view.findViewById(R.id.btnLeft);

        title.setText(String.valueOf(offertitle[position]));
        testImage.setImageResource(testImages[position]);
        desc.setText(String.valueOf(OfferDes[position]));
        price.setText(String.valueOf(Price[position]));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Data.class);
                context.startActivity(i);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterViewFlipper.showNext();

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterViewFlipper.showPrevious();

            }
        });


        return view;
    }
}