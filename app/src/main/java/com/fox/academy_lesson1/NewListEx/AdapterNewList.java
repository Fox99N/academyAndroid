package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fox.academy_lesson1.R;

import java.util.List;

/**
 * Created by fox on 30.09.18.
 */

public class AdapterNewList extends BaseAdapter{
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public AdapterNewList(List<NewsItem> news, Context context) {
        this.news = news;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        ;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public NewsItem getItem(int position) {
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowItem = layoutInflater.inflate(R.layout.new_items_list, parent, false);
        ImageView image = rowItem.findViewById(R.id.news_img);
        TextView author = rowItem.findViewById(R.id.news_author_txt);
        TextView textHeader = rowItem.findViewById(R.id.news_header_txt);
        TextView textDescription = rowItem.findViewWithTag(R.id.news_descriptions_txt);
        TextView textData = rowItem.findViewById(R.id.news_data_txt);

        NewsItem newsItem= news.get(position);
        image.setImageResource(Integer.parseInt(newsItem.getImageUrl()));
        author.setText((CharSequence) newsItem.getCategory()); //FIXME скорее всего некорретно откастует, опнять почему к чару
        textHeader.setText(newsItem.getTitle());
        textDescription.setText(newsItem.getFullText());
        textData.setText((CharSequence) newsItem.getPublishDate());
        return rowItem;
    }

}
