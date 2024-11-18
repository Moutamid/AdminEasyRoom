package com.admineasyroom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.admineasyroom.R;
import com.admineasyroom.model.FeedBackModel;
import com.bumptech.glide.Glide;

import java.util.List;


public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.MainViewHolder> {

    private final Context context;
    private final List<FeedBackModel> feedBackModelList;

    // Constructor
    public FeedbackAdapter(Context context, List<FeedBackModel> feedBackModelList) {
        this.context = context;
        this.feedBackModelList = feedBackModelList;
    }

    // ViewHolder Class
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView feedBackTv;
        ImageView personImage;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            feedBackTv = itemView.findViewById(R.id.feedBackTv);
            personImage = itemView.findViewById(R.id.personImage);
        }
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feed_back_sample_row, parent, false); // Use your custom layout here
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        FeedBackModel data = feedBackModelList.get(position);
        Glide.with(context).load(R.drawable.person).into(holder.personImage);
        holder.nameTv.setText(data.name);
        holder.feedBackTv.setText(data.feedback);
    }

    @Override
    public int getItemCount() {
        return feedBackModelList.size();
    }

}
