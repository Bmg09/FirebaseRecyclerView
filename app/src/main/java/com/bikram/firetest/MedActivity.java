package com.bikram.firetest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MedActivity extends AppCompatActivity {
    TextView medname,medmfg,meddesc;
    Bitmap bitmap;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);
        ActionBar actionBar = getSupportActionBar();
        //Actionbar title
        actionBar.setTitle("Med Detail");
        //set back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        imageView = findViewById(R.id.medimage);
        medname =findViewById(R.id.textView5);
        medmfg = findViewById(R.id.textView6);
        meddesc = findViewById(R.id.textView7);
        byte[] bytes = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        medname.setText(getIntent().getStringExtra("medname"));
        medmfg.setText(getIntent().getStringExtra("mfgname"));
        meddesc.setText(getIntent().getStringExtra("meddes"));
        imageView.setImageBitmap(bmp);
        bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();



    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}