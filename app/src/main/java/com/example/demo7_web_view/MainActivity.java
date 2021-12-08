package com.example.demo7_web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    SeekBar seekBar;
    Button btn,btn1;
    TextView tv,tv1;
    TimePicker timePicker;
    DatePicker datePicker;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=(SeekBar)findViewById(R.id.seekbar);
        ratingBar=(RatingBar)findViewById(R.id.ratingbar);
        btn=(Button)findViewById(R.id.btn_time);
        btn1=(Button)findViewById(R.id.btn_showtime);
        webView=(WebView)findViewById(R.id.web_view);
        datePicker=(DatePicker)findViewById(R.id.date_picker);
        timePicker=(TimePicker)findViewById(R.id.time_picker);
        tv=(TextView)findViewById(R.id.text_view);
        tv1=(TextView)findViewById(R.id.textview_date);

        ratingBar.setRating(5);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                     Toast.makeText(MainActivity.this, "Progress: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Started...", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Stopped", Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(MainActivity.this, "Rating : "+v, Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hour=String.valueOf(timePicker.getCurrentHour());
                String minute=String.valueOf(timePicker.getCurrentMinute());

                tv.setText(hour+" : "+minute);
                tv.setVisibility(View.VISIBLE);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day=String.valueOf(datePicker.getDayOfMonth());
                String month=String.valueOf(datePicker.getMonth()+1);
                String year=String.valueOf(datePicker.getYear());

                tv.setText(day+"/"+month+"/"+year);
                tv1.setVisibility(View.VISIBLE);
            }
        });

        webView.loadUrl("https://www.google.com/");
    }
}