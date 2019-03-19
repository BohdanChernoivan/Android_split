package com.example.dz_15.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dz_15.R;
import com.example.dz_15.dataPhoto.LinksPhoto;
import com.example.dz_15.logic.TakePhoto;

public class MainActivity extends AppCompatActivity {


    Button sf, pe, hi, sc;
    Button giveBreed;
    static TakePhoto takePhoto;

    static String[] emptyArray = null;
    LinksPhoto linksPhoto = new LinksPhoto();
    private int str;
    ImageView imageView;
    ImageButton imageButton;
    TextView textView;
    Button butNewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sf = findViewById(R.id.sfinksB);
        pe = findViewById(R.id.persianB);
        hi = findViewById(R.id.himalayanB);
        sc = findViewById(R.id.scottishFoldB);
        giveBreed = findViewById(R.id.button5);

        imageView = findViewById(R.id.imageVie3w);
        imageButton = findViewById(R.id.imageButton);
        textView = findViewById(R.id.textView2);
        butNewCat = findViewById(R.id.textView3);


        if (takePhoto != null) {
            takePhoto.givePicture(imageView);
        }

        sf.setOnClickListener(sfinks);
        pe.setOnClickListener(persian);
        hi.setOnClickListener(himalayan);
        sc.setOnClickListener(scottishFold);

        giveBreed.setOnClickListener(givingBreed);
        butNewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (takePhoto != null)
                    takePhoto.getNextPicture();
            }
        });


    }

    View.OnClickListener sfinks = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            emptyArray = linksPhoto.getSfinks();
            str = R.string.Sfinks;
        }
    };

    View.OnClickListener persian = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            emptyArray = linksPhoto.getPersian();
            str = R.string.Persian;
        }
    };

    View.OnClickListener himalayan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            emptyArray = linksPhoto.getHimalayan();
            str = R.string.Himalayan;
        }
    };

    View.OnClickListener scottishFold = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            emptyArray = linksPhoto.getScottlish();
            str = R.string.ScottishFold;
        }
    };

    View.OnClickListener givingBreed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (emptyArray != null) {
                takePhoto = new TakePhoto(imageView, emptyArray);
                textView.setText(str);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("STR", str);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        str = savedInstanceState.getInt("STR");
        if (emptyArray != null) {
            takePhoto = new TakePhoto(imageView, emptyArray);
            textView.setText(str);
        }
    }
}
