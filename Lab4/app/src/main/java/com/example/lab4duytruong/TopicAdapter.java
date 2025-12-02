package com.example.lab4duytruong;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private List<TopicItem> topicItems;
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(TopicItem item);
    }
    public TopicAdapter(List<TopicItem> topicItems, OnItemClickListener listener) {
        this.topicItems = topicItems;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_topic, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopicItem item = topicItems.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return topicItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemText;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemText = itemView.findViewById(R.id.itemText);
        }
        void bind(final TopicItem item, final OnItemClickListener listener) {
            itemImage.setImageResource(item.getImageResId());
            itemText.setText(item.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(item);
                    }
                }
            });
        }
    }
}
