package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ShowFlagActivity extends AppCompatActivity {

    public final String TAG = "Countries App";
    private AssetManager assets;
    private ImageView imageView;
    private TextView textViewTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flag);

        assets = getAssets();
        imageView = (ImageView)findViewById(R.id.imageView);
        textViewTitle = (TextView)findViewById(R.id.textViewTitle);

        String region = getIntent().getStringExtra("EXTRA_REGION");
        String fileName = getIntent().getStringExtra("EXTRA_FILENAME");
        String country = getIntent().getStringExtra("EXTRA_COUNTRY");

        textViewTitle.setText(country);

        try(InputStream is = assets.open(region+"/"+ fileName +".png")){
            Drawable flag= Drawable.createFromStream(is,fileName);
            imageView.setImageDrawable(flag);
        }catch(IOException e){
            Log.e(TAG,"Error loading " + fileName, e);
        }

    }
}
