package com.example.imagecollage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {

    public BlurImageView img1;
    public BlurImageView img2;
    public BlurImageView img3;
    public SeekBar seekBar1;
    public SeekBar seekBar2;
    public SeekBar seekBar3;
    public TextView txt1;
    public TextView txt2;
    public TextView txt3;
    public boolean imgClick1;
    public boolean imgClick2;
    public boolean imgClick3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        seekBar1 = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);

        seekBar1.getThumb().mutate().setAlpha(0);
        seekBar2.getThumb().mutate().setAlpha(0);
        seekBar3.getThumb().mutate().setAlpha(0);

        IMAGE();
    }
    public void IMAGE () {

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SET_Blur(img1, seekBar1);
                    txt1.setText("Eiffel Tower");

                    imgClick1 = true;

                if (imgClick2 || imgClick3) {

                    REMOVE_Blur(img2, seekBar2);
                    txt2.setText("");

                    REMOVE_Blur(img3, seekBar3);
                    txt3.setText("");

                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SET_Blur(img2, seekBar2);
                    txt2.setText("Leaning Tower Of Pisa");

                    imgClick2 = true;

                if (imgClick1 || imgClick3) {

                    REMOVE_Blur(img1, seekBar1);
                    txt1.setText("");

                    REMOVE_Blur(img3, seekBar3);
                    txt3.setText("");

                }

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SET_Blur(img3, seekBar3);
                    txt3.setText("Taj Mahal");

                    imgClick3 = true;

                if (imgClick1 || imgClick2) {

                    REMOVE_Blur(img1, seekBar1);
                    txt1.setText("");

                    REMOVE_Blur(img2, seekBar2);
                    txt2.setText("");
                }

            }
        });

    }

    public void SET_Blur (BlurImageView img, SeekBar sBar) {

        sBar.setProgress(25);
        img.setBlur(sBar.getProgress());
    }

    public void REMOVE_Blur (BlurImageView img, SeekBar sBar) {

        sBar.setProgress(0);
        img.setBlur(sBar.getProgress());
    }
