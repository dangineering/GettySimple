package com.example.dangineering.gettyair.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.gettyair.R;
import com.example.dangineering.gettyair.network.respmodel.Image;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemHolder extends RecyclerView.ViewHolder{

    Context context;

    // ui
    @Bind(R.id.floating_text)
    TextView textView;

    @Bind(R.id.imageview)
    ImageView imageView;

    @Bind(R.id.title_text)
    TextView titleText;

    public ItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();
    }

    public void bind(Image i){

        Picasso.with(context).load(i.getDisplaySizes().get(0).getUri()).fit().centerCrop().into(imageView);

        textView.setText(i.getLicenseModel());

        titleText.setText(i.getTitle());
    }
}
