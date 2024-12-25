package com.admineasyroom.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.icu.lang.UCharacter;
import com.admineasyroom.R;
import java.util.Objects;


public class DialogUtils {
   public static Dialog showProgressBar(Context context){
        Dialog lodingbar = new Dialog(context);
        lodingbar.setContentView(R.layout.loading);
        Objects.requireNonNull(lodingbar.getWindow()).setBackgroundDrawable(new ColorDrawable(UCharacter.JoiningType.TRANSPARENT));
        lodingbar.setCancelable(false);
        lodingbar.show();
        return lodingbar;
    }
}
