package com.fox.academy_lesson1.new_list_ex;

import android.content.Context;
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
import java.util.List;


public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private static final String EXTRA_NEWS_ITEM = "ITEM_NEWS";
    private final Context context;
    private final List<NewsItem> news;
    private final LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView author;
        ImageView image;
        TextView category;
        @NonNull
        TextView previewText;
        @NonNull
        TextView textDescription;
        TextView textData;

       private ViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.news_author_txt);
            image = itemView.findViewById(R.id.news_img);
            category = itemView.findViewById(R.id.news_category);
            textData = itemView.findViewById(R.id.news_data_txt);
            previewText = itemView.findViewById(R.id.news_preview_txt);
            textDescription = itemView.findViewById(R.id.news_descriptions_txt);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onItemClick(itemView, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.new_items_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewsItem newsItem = news.get(position);
        holder.author.setText(newsItem.getAuthor());
        holder.image.setImageResource(newsItem.getImageUrl());
        holder.category.setText(newsItem.getCategory());
        holder.previewText.setText(newsItem.getPreviewText());
        holder.textData.setText(newsItem.getPublishDate().toString());
        holder.textDescription.setText(newsItem.getFullText());
        holder.itemView.setOnClickListener(v -> openNewsActivity(
                newsItem));
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
