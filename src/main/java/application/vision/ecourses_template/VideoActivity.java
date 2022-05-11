package application.vision.ecourses_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video =findViewById(R.id.videoview1);
        findViewById(R.id.cover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.videoview1).setVisibility(View.VISIBLE);
                String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
                video.setVideoURI(Uri.parse(path));
                started=1;
                video.start();
            }
        });
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                video.start();
            }
        });
        findViewById(R.id.readmore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(choice==0) {
                    ((TextView)findViewById(R.id.readmore)).setText("Show Less");
                    choice=1;
                    findViewById(R.id.txt).setVisibility(View.VISIBLE);
                }
                else{
                    ((TextView)findViewById(R.id.readmore)).setText("Read More");
                    choice=0;
                    findViewById(R.id.txt).setVisibility(View.GONE);
                }
            }
        });
        findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empty();
                dislike=0;
                love=0;
                if(like==0) {
                    like=1;
                    ((LinearLayout)findViewById(R.id.like)).getChildAt(0).setBackgroundResource(R.drawable.like_fill);
                    ((TextView)((LinearLayout)findViewById(R.id.like)).getChildAt(1)).setTextColor(Color.parseColor("#03A9F4"));
                }
                else{
                    like=0;
                    ((LinearLayout)findViewById(R.id.like)).getChildAt(0).setBackgroundResource(R.drawable.like_empty);
                    ((TextView)((LinearLayout)findViewById(R.id.like)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
                }
            }
        });
        findViewById(R.id.love).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empty();
                like=0;
                dislike=0;
                if(love==0) {
                    love=1;
                    ((LinearLayout)findViewById(R.id.love)).getChildAt(0).setBackgroundResource(R.drawable.love_fill);
                    ((TextView)((LinearLayout)findViewById(R.id.love)).getChildAt(1)).setTextColor(Color.parseColor("#FF4646"));
                }
                else{
                    love=0;
                    ((LinearLayout)findViewById(R.id.love)).getChildAt(0).setBackgroundResource(R.drawable.love_empty);
                    ((TextView)((LinearLayout)findViewById(R.id.love)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
                }
            }
        });
        findViewById(R.id.dislike).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empty();
                like=0;
                love=0;
                if(dislike==0) {
                    dislike=1;
                    ((LinearLayout)findViewById(R.id.dislike)).getChildAt(0).setBackgroundResource(R.drawable.dislike_fill);
                    ((TextView)((LinearLayout)findViewById(R.id.dislike)).getChildAt(1)).setTextColor(Color.parseColor("#03A9F4"));
                }
                else{
                    dislike=0;
                    ((LinearLayout)findViewById(R.id.dislike)).getChildAt(0).setBackgroundResource(R.drawable.dislike_empty);
                    ((TextView)((LinearLayout)findViewById(R.id.dislike)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
                }
            }
        });
        parent1 = findViewById(R.id.parr1);
        AddCats(0);
    }
    LinearLayout parent1;
    void AddCats(int _case) {
        String name = _case == 0 ? "All Topics" : _case == 1 ? "Popular" : _case == 2 ? "Newest" : "Advance";
        parent1.removeAllViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Category_Item item;
                for(int i=0;i<50;i++){
                    item = new Category_Item(VideoActivity.this, name);
                    parent1.addView(item);
                    item.Show();
                }
            }
        }, 200);
    }
    void Empty(){
        ((LinearLayout)findViewById(R.id.like)).getChildAt(0).setBackgroundResource(R.drawable.like_empty);
        ((LinearLayout)findViewById(R.id.love)).getChildAt(0).setBackgroundResource(R.drawable.love_empty);
        ((LinearLayout)findViewById(R.id.dislike)).getChildAt(0).setBackgroundResource(R.drawable.dislike_empty);
        ((TextView)((LinearLayout)findViewById(R.id.love)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
        ((TextView)((LinearLayout)findViewById(R.id.dislike)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
        ((TextView)((LinearLayout)findViewById(R.id.like)).getChildAt(1)).setTextColor(Color.parseColor("#666666"));
    }
    int like =0, love=0,dislike=0;
    int choice=0;
    int started=0;
    @Override
    protected void onResume() {
        super.onResume();
        if(video!=null && started==1)
            video.start();
    }
}