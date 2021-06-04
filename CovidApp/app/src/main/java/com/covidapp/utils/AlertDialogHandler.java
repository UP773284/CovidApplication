package com.example.covidapp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class AlertDialogHandler {
    public static void showSimpleDialog(Context context, String title, String message){
        AlertDialog alertDialog = new  AlertDialog.Builder(context).setTitle(title)
                .setMessage(message).create();
        alertDialog.show();



    }

    public static void showInfoDialoge(Context activity, String title, String message){
        AlertDialog alertDialog = new  AlertDialog.Builder(activity).setTitle(title).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("click","Yes Click");
                //Log.d("click", "No Click");
            }
        })
                .setMessage(message).create();
        alertDialog.show();



    }
}
