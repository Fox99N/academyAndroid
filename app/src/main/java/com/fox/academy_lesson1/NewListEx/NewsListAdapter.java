package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fox on 25.10.18.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder>  {
    private static final String EXTRA_NEWS_ITEM = "ITEM_NEWS";
    private final Context context;
    private final List<NewsItem> news;
    private final LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    NewsListAdapter(List<NewsItem> news, Context context) {
        this.news = news;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.new_items_list, parent, false);

        return new ViewHolder(view);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   openNewsActivity(news.get(getAdapterPosition()));
                }
            });
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
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    NewsItem getItem(int id) {
        return news.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(NewsItem newsItem);

        void onItemClick(View view, int position);
    }

    private void openNewsActivity(NewsItem newsSeItem) {
        Intent intent = new Intent(context, NewsItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_NEWS_ITEM, newsSeItem);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}