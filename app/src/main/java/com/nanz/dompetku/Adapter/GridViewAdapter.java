package com.nanz.dompetku.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nanz.dompetku.R;

/**
 * Created by Nanz on 15/05/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private Integer[] image = {
            R.drawable.tambah, R.drawable.ktp_penduduk,
            R.drawable.sim, R.drawable.stnk,
            R.drawable.ktm, R.drawable.ktp_pelajar
    };

    public GridViewAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount(){
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(230, 230));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else{
            imageView = (ImageView) view;
        }
        imageView.setImageResource(image[i]);
        return imageView;
    }
}
