package br.com.example.arthur.sharewithintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shareText(View v){
        Intent sendText = new Intent();
        sendText.setAction(Intent.ACTION_SEND);
        sendText.putExtra(Intent.EXTRA_TEXT, "Cheech and Chong!");
        sendText.setType("text/plain");
        startActivity(Intent.createChooser(sendText, "Share to..."));
    }

    public void shareImage(View v){

        Uri uri = null;
        try{
            // add <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> on androidManifest
            //add image to src/main/res/drawable
            uri = Uri.parse(MediaStore.Images.Media.insertImage(this.getContentResolver(),
                    BitmapFactory.decodeResource(getResources(), R.drawable.cheech), null, null));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        Intent sendImage = new Intent();
        sendImage.setAction(Intent.ACTION_SEND);
        sendImage.putExtra(Intent.EXTRA_STREAM, uri);
        sendImage.setType("image/*");
        startActivity(Intent.createChooser(sendImage, "Share to..."));
    }

    public void shareImageText(View v){
        Uri uri = null;
        try{
            // add <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> on androidManifest
            //add image to src/main/res/drawable
            uri = Uri.parse(MediaStore.Images.Media.insertImage(this.getContentResolver(),
                    BitmapFactory.decodeResource(getResources(), R.drawable.cheechchong), null, null));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        Intent sendImageText = new Intent();
        sendImageText.setAction(Intent.ACTION_SEND);
        sendImageText.putExtra(Intent.EXTRA_TEXT, "Cheech and Chong!");
        sendImageText.putExtra(Intent.EXTRA_STREAM, uri);
        sendImageText.setType("*/*");
        startActivity(Intent.createChooser(sendImageText, "Share to..."));
    }
}
