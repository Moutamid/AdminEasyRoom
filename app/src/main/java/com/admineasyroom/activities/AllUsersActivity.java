package com.admineasyroom.activities;

import static com.admineasyroom.utils.Constants.APPNODE;
import static com.admineasyroom.utils.Constants.FEEDBACKNODE;
import static com.admineasyroom.utils.Constants.USERNODE;
import static com.admineasyroom.utils.DialogUtils.showProgressBar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.admineasyroom.R;
import com.admineasyroom.adapters.FeedbackAdapter;
import com.admineasyroom.adapters.UsersAdapter;
import com.admineasyroom.model.FeedBackModel;
import com.admineasyroom.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AllUsersActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private Dialog lodingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.lavender));

        ArrayList<UserModel> list=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference();


        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        ImageView backImg=findViewById(R.id.backImg);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lodingbar=showProgressBar(AllUsersActivity.this);

        databaseReference.child(USERNODE).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot childSnapshot : snapshot.getChildren()){
                    UserModel model=childSnapshot.getValue(UserModel.class);
                    if (model!=null){
                        list.add(model);
                    }
                    UsersAdapter adapter = new UsersAdapter(AllUsersActivity.this,list);
                    recyclerView.setAdapter(adapter);
                    lodingbar.dismiss();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AllUsersActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                lodingbar.dismiss();
            }
        });

    }
}