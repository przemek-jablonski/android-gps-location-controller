package com.android.szparag.gpslocationcontroller.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.szparag.gpslocationcontroller.R;
import com.android.szparag.gpslocationcontroller.backend.models.Region;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ciemek on 02/11/2016.
 */

public class RegionRecyclerViewAdapter extends BaseRecyclerViewAdapter<Region> {


    public RegionRecyclerViewAdapter(@Nullable RecyclerOnPosClickListener listener) {
        super(listener);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RegionViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(
                                R.layout.item_recycler_region_icon,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindRegionViewHolder(((RegionViewHolder) holder), position);
    }

    private void onBindRegionViewHolder(RegionViewHolder holder, int position) {
        Region region = items.get(position);

        Picasso.with(holder.imageView.getContext())
                .load(region.getPolicy().getIcon())
                .into(holder.imageView);

        holder.textRegionName.setText(region.getName());
        holder.textPolicyName.setText(region.getPolicy().getName());
    }

    public class RegionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_recycler_region_imageview)
        ImageView   imageView;

        @BindView(R.id.item_recycler_region_name)
        TextView    textRegionName;

        @BindView(R.id.item_recycler_region_policy)
        TextView    textPolicyName;


        public RegionViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            if (recyclerOnPosClickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recyclerOnPosClickListener.OnPosClick(view, getLayoutPosition());
                    }
                });
            }
        }
    }

}
