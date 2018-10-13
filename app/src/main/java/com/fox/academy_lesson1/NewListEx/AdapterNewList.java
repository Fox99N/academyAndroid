package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fox.academy_lesson1.R;

import java.text.DateFormat;
import java.util.List;
import java.util.zip.DataFormatException;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by fox on 30.09.18.
 */

public class AdapterNewList extends RecyclerView.Adapter<AdapterNewList.ViewHolder> {
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater layoutInflater;
    private ItemClickListener clickListener;
    private final String ITEM_MESSAGE = "ITEM_MESSAGE";

    public AdapterNewList(List<NewsItem> news, Context context) {
        this.news = news;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView author;
        ImageView image;
        TextView category;
        TextView previewText;
        TextView textDescription;
        TextView textData;

        public ViewHolder(View itemView) {
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final NewsItem newsItem = news.get(position);

        holder.author.setText(newsItem.getAuthor());
        holder.image.setBackground(newsItem.getImageUrl());
        holder.category.setText(newsItem.getCategory());
        holder.previewText.setText(newsItem.getPreviewText());
        holder.textData.setText(newsItem.getPublishDate().toString());
        holder.textDescription.setText(newsItem.getFullText());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewsActivity(position);

            }
        });

    }


    public void openNewsActivity(int position) {
        Intent intent = new Intent(context, NewActivity2.class);
        NewsItem newsItem = news.get(position);
        Toast.makeText(context, " show " + newsItem, Toast.LENGTH_LONG).show();
        intent.putExtra(ITEM_MESSAGE, (Parcelable) newsItem);
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


}
