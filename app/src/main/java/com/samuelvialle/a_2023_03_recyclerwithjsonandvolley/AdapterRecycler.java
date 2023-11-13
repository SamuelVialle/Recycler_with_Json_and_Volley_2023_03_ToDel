package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    private Context context;
    private ArrayList<ModelItem> arrayList;
    public AdapterRecycler() {
    }
    public AdapterRecycler(Context context, ArrayList<ModelItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler
            , parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyViewHolder holder, int position) {
        ModelItem currentItem = arrayList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creator = currentItem.getCreator();
        String likes = currentItem.getLikes();

        holder.tvCreator.setText(creator);
        holder.tvLikes.setText(likes);

        Context context1 = holder.ivImage.getContext();

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher);

        Glide.with(context1)
                .load(imageUrl)
                .apply(options)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivImage;
        private final TextView tvCreator, tvLikes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvCreator = itemView.findViewById(R.id.tv_creator);
            tvLikes = itemView.findViewById(R.id.tv_likes);
        }
    }
}
