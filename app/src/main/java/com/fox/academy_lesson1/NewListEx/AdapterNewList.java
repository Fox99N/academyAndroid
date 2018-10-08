package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fox.academy_lesson1.R;

import java.util.List;

/**
 * Created by fox on 30.09.18.
 */

public class AdapterNewList extends RecyclerView.Adapter<AdapterNewList.ViewHolder> {
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    public AdapterNewList(List<NewsItem> news, Context context) {
        this.news = news;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView author;
        TextView textHeader;
        TextView textDescription;
        TextView textData;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.news_img);
            author = itemView.findViewById(R.id.news_author_txt);
            textHeader = itemView.findViewById(R.id.news_header_txt);
            textDescription = itemView.findViewWithTag(R.id.news_descriptions_txt);
            textData = itemView.findViewById(R.id.news_data_txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onItemClick(itemView, getAdapterPosition());

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.new_items_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsItem newsItem = news.get(position);
        holder.image.setImageResource(Integer.parseInt(newsItem.getImageUrl()));
        holder.author.setText((CharSequence) newsItem.getCategory()); //FIXME скорее всего некорретно откастует, опнять почему к чару
        holder.textHeader.setText(newsItem.getTitle());
        holder.textDescription.setText(newsItem.getFullText());
        holder.textData.setText((CharSequence) newsItem.getPublishDate());

    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    NewsItem getItem(int id){
        return news.get(id);
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    //TODO доделать holder и все под ресайкл с 100 страницы
}
