package application.vision.ecourses_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;

public class CourseOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_overview);
        for(int i=0;i<((LinearLayout)findViewById(R.id.parr1)).getChildCount(); i++){
            ((LinearLayout)findViewById(R.id.parr1)).getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                }
            });
        }
        p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);
        findViewById(R.id.scroll1).animate().translationY(p.y);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.scroll1).setVisibility(View.VISIBLE);
                findViewById(R.id.scroll1).animate().translationY(0).setDuration(500);
            }
        }, 400);
    }
    Point p;
}