package com.fox.academy_lesson1.new_list_ex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
import java.util.ArrayList;
import java.util.List;


public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private static final String EXTRA_NEWS_ITEM = "ITEM_NEWS";
    private final List<NewsItem> news = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private final OnItemClickListener clickListener;


    public NewsListAdapter(List<NewsItem> context, @NonNull Context clickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.new_items_list, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("holder.getAdapterPosition", String.valueOf(holder.getAdapterPosition()));
                /*openNewsActivity(holder.getAdapterPosition());*/
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(news.get(position));

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView author;
        private ImageView image;
        private TextView category;
        private TextView previewText;
        private TextView textDescription;
        private TextView textData;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.news_author_txt);
            image = itemView.findViewById(R.id.news_img);
            category = itemView.findViewById(R.id.news_category);
            textData = itemView.findViewById(R.id.news_data_txt);
            previewText = itemView.findViewById(R.id.news_preview_txt);
            textDescription = itemView.findViewById(R.id.news_descriptions_txt);
        }

        public void bind(NewsItem newsItem){
            author.setText(newsItem.getAuthor());
            image.setImageResource(newsItem.getImageUrl());
            category.setText(newsItem.getCategory());
            previewText.setText(newsItem.getPreviewText());
            textData.setText(newsItem.getPublishDate().toString());
            textDescription.setText(newsItem.getFullText());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
    public void replaceItems(@NonNull List<NewsItem> newItems) {
        news.clear();
        news.addAll(newItems);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(@NonNull NewsItem newsItem);
    if (clickListener != null) clickListener.onItemClick(itemView, getAdapterPosition());
        }
    }

    private void openNewsActivity(NewsItem newsSeItem) {
        Intent intent = new Intent(context, NewsItemsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_NEWS_ITEM, newsSeItem);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    NewsItem getItem(int id) {
        return news.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    NewsListAdapter(List<NewsItem> news, Context context) {
        this.news = news;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
}
