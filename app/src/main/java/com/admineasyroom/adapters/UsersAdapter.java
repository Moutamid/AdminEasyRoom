package com.admineasyroom.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.admineasyroom.R;
import com.admineasyroom.model.FeedBackModel;
import com.admineasyroom.model.UserModel;
import com.bumptech.glide.Glide;
import java.util.List;



public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MainViewHolder> {

    private final Context context;
    private final List<UserModel> userModelList;

    // Constructor
    public UsersAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
    }

    // ViewHolder Class
    public static class MainViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView phoneNumberTv;
        TextView emailTv;
        TextView dobTv;
        ImageView personImage;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            personImage = itemView.findViewById(R.id.personImage);
            emailTv = itemView.findViewById(R.id.emailTv);
            dobTv = itemView.findViewById(R.id.dobTv);
            phoneNumberTv = itemView.findViewById(R.id.phoneNumberTv);
        }
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_sample_row, parent, false); // Use your custom layout here
        return new MainViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        UserModel data = userModelList.get(position);
        if (!data.first_name.isEmpty() &&
                !data.last_name.isEmpty() &&
                !data.phone_number.isEmpty() &&
                !data.dob.isEmpty() &&
                !data.email.isEmpty() &&
                !data.user_type.isEmpty()
        ) {
            Glide.with(context).load(R.drawable.person).into(holder.personImage);
            holder.nameTv.setText(data.first_name+" "+data.last_name);
            holder.phoneNumberTv.setText("Phone Number: "+data.phone_number);
            holder.emailTv.setText("Email: "+data.email);
            holder.dobTv.setText("DOB"+data.dob);
        }
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

}
