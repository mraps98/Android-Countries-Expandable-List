package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ShowFlagActivity extends AppCompatActivity {

    public final String TAG = "Countries App";
    AssetManager assets;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flag);

        assets = getAssets();
        imageView = (ImageView)findViewById(R.id.imageView);

        String region = getIntent().getStringExtra("EXTRA_REGION");
        String fileName = getIntent().getStringExtra("EXTRA_FILENAME");
        try(InputStream is = assets.open(region+"/"+ fileName +".png")){
            Drawable flag= Drawable.createFromStream(is,fileName);
            imageView.setImageDrawable(flag);
        }catch(IOException e){
            Log.e(TAG,"Error loading " + fileName, e);
        }

    }
}
