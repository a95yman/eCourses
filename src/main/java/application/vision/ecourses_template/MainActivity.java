package application.vision.ecourses_template;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Point p;
    LinearLayout topics, parr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu);
        parr2 = findViewById(R.id.parr2);
        p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);
        topics = findViewById(R.id.topics);
        findViewById(R.id.page1).animate().translationY(p.y);
        findViewById(R.id.item_COURSES).animate().translationX(p.x);
        menu.animate().translationX(-p.x);
        for(int i=0;i<topics.getChildCount();i++){
            int finalI = i;
            topics.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j=0;j<topics.getChildCount();j++){
                        topics.getChildAt(j).setBackgroundResource(R.drawable.shape2);
                        ((TextView)((LinearLayout)topics.getChildAt(j)).getChildAt(1)).setTextColor(Color.parseColor("#333333"));
                        ((ImageView)((LinearLayout)topics.getChildAt(j)).getChildAt(0)).setBackgroundResource(R.drawable.category_dark);
                    }
                    topics.getChildAt(finalI).setBackgroundResource(R.drawable.shape1);
                    ((TextView)((LinearLayout)topics.getChildAt(finalI)).getChildAt(1)).setTextColor(Color.parseColor("#FFFFFF"));
                    ((ImageView)((LinearLayout)topics.getChildAt(finalI)).getChildAt(0)).setBackgroundResource(R.drawable.category_light);
                    AddCourse();
                }
            });
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.page1).setVisibility(View.VISIBLE);
                findViewById(R.id.item_COURSES).setVisibility(View.VISIBLE);
                findViewById(R.id.get_started).animate().alpha(1).setDuration(500);
                menu.setVisibility(View.VISIBLE);
                findViewById(R.id.get_started).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findViewById(R.id.page0).animate().translationY(-p.y).setDuration(500);
                        findViewById(R.id.page1).animate().translationY(0).setDuration(500);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                parent1 = findViewById(R.id.parr1);
                                AddCats(0);
                            }
                        }, 600);
                    }
                });
            }
        }, 1000);
        nav = findViewById(R.id.nav);
        for(int i=0; i<nav.getChildCount();i++){
            LinearLayout item = (LinearLayout) nav.getChildAt(i);
            int finalI = i;
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j=0; j<nav.getChildCount();j++) {
                        ((LinearLayout) nav.getChildAt(j)).getChildAt(0).setBackgroundResource(R.drawable.shape_null);
                        ((LinearLayout) ((LinearLayout) nav.getChildAt(j)).getChildAt(0)).getChildAt(1).setVisibility(View.GONE);
                        if(j==0){
                            ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(j)).getChildAt(0)).getChildAt(0))
                                    .setBackgroundResource(R.drawable.home_dark);
                        }
                        else if(j==1){
                            ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(j)).getChildAt(0)).getChildAt(0))
                                    .setBackgroundResource(R.drawable.book_dark);
                        }
                        else if(j==2){
                            ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(j)).getChildAt(0)).getChildAt(0))
                                    .setBackgroundResource(R.drawable.settings_dark);
                        }
                    }
                    item.getChildAt(0).setBackgroundResource(R.drawable.shape1);
                    ((LinearLayout)item.getChildAt(0)).getChildAt(1).setVisibility(View.VISIBLE);
                    if(finalI==0){
                        menuItemClicked=0;
                        ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(finalI)).getChildAt(0)).getChildAt(0))
                                .setBackgroundResource(R.drawable.home_light);
                        findViewById(R.id.item_HOME).animate().translationX(0).setDuration(500);
                        findViewById(R.id.item_COURSES).animate().translationX(p.x).setDuration(500);
                    }
                    else if(finalI==1){
                        menuItemClicked=1;
                        ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(finalI)).getChildAt(0)).getChildAt(0))
                                .setBackgroundResource(R.drawable.book_light);
                        findViewById(R.id.item_HOME).animate().translationX(-p.x).setDuration(500);
                        findViewById(R.id.item_COURSES).animate().translationX(0).setDuration(500);
                    }
                    else if(finalI==2){
                        ((ImageView)((LinearLayout) ((LinearLayout) nav.getChildAt(finalI)).getChildAt(0)).getChildAt(0))
                                .setBackgroundResource(R.drawable.settings_light);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                findViewById(R.id.cover).animate().alpha(1).setDuration(500);
                                menu.animate().translationX(0).setDuration(500);
                                findViewById(R.id.page1).animate().translationX(p.x-200).setDuration(500);
                                findViewById(R.id.page1).animate().scaleX(0.8f).setDuration(500);
                                findViewById(R.id.page1).animate().scaleY(0.8f).setDuration(500);
                                cs=1;
                            }
                        }, 100);
                    }
                }
            });
        }
        cat1 = findViewById(R.id.cat1);
        cat2 = findViewById(R.id.cat2);
        cat3 = findViewById(R.id.cat3);
        cat4 = findViewById(R.id.cat4);
        int cat_index=0;
        for(LinearLayout item: new LinearLayout[]{cat1, cat2, cat3, cat4}){
            int tmp=cat_index;
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(LinearLayout tmp: new LinearLayout[]{cat1, cat2, cat3, cat4}){
                        tmp.setBackgroundResource(R.drawable.shape2);
                        ((ImageView)tmp.getChildAt(0)).setBackgroundResource(R.drawable.category_dark);
                        ((TextView)tmp.getChildAt(1)).setTextColor(Color.parseColor("#333333"));
                    }
                    item.setBackgroundResource(R.drawable.shape1);
                    ((ImageView)item.getChildAt(0)).setBackgroundResource(R.drawable.category_light);
                    ((TextView)item.getChildAt(1)).setTextColor(Color.parseColor("#FFFFFF"));
                    AddCats(tmp);
                }
            });
            cat_index++;
        }
        findViewById(R.id.ret).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });
        AddCourse();
    }

    void AddCourse(){
        parr2.removeAllViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Course_Item item;
                for(int i=0;i<60;i++){
                    item = new Course_Item(MainActivity.this);
                    parr2.addView(item);
                    item.Show();
                }
            }
        }, 200);
    }

    void AddCats(int _case) {
        String name = _case == 0 ? "All Topics" : _case == 1 ? "Popular" : _case == 2 ? "Newest" : "Advance";
        parent1.removeAllViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Category_Item item;
                for(int i=0;i<20;i++){
                    item = new Category_Item(MainActivity.this, name);
                    parent1.addView(item);
                    item.Show();
                }
            }
        }, 200);
    }
    LinearLayout parent1;
    void Return(){
        if(menuItemClicked==0) {
            ((LinearLayout) nav.getChildAt(0)).getChildAt(0).setBackgroundResource(R.drawable.shape1);
            ((LinearLayout) ((LinearLayout) nav.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(View.VISIBLE);
            ((ImageView) ((LinearLayout) ((LinearLayout) nav.getChildAt(0)).getChildAt(0)).getChildAt(0))
                    .setBackgroundResource(R.drawable.home_light);
        }
        else if(menuItemClicked==1) {
            ((LinearLayout) nav.getChildAt(1)).getChildAt(0).setBackgroundResource(R.drawable.shape1);
            ((LinearLayout) ((LinearLayout) nav.getChildAt(1)).getChildAt(0)).getChildAt(1).setVisibility(View.VISIBLE);
            ((ImageView) ((LinearLayout) ((LinearLayout) nav.getChildAt(1)).getChildAt(0)).getChildAt(0))
                    .setBackgroundResource(R.drawable.book_light);
        }
        ((LinearLayout) nav.getChildAt(2)).getChildAt(0).setBackgroundResource(R.drawable.shape_null);
        ((LinearLayout) ((LinearLayout) nav.getChildAt(2)).getChildAt(0)).getChildAt(1).setVisibility(View.GONE);
        ((ImageView) ((LinearLayout) ((LinearLayout) nav.getChildAt(2)).getChildAt(0)).getChildAt(0))
                .setBackgroundResource(R.drawable.settings_dark);
        findViewById(R.id.cover).animate().alpha(0).setDuration(500);
        menu.animate().translationX(-p.x).setDuration(500);
        findViewById(R.id.page1).animate().translationX(0).setDuration(500);
        findViewById(R.id.page1).animate().scaleX(1f).setDuration(500);
        findViewById(R.id.page1).animate().scaleY(1f).setDuration(500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cs=0;
            }
        }, 500);
    }

    @Override
    public void onBackPressed() {
        if(cs==1){
            Return();
        }
        else if(cs==0){
            finish();
        }
    }
    int menuItemClicked=0;
    int cs =0;
    LinearLayout nav, menu;
    LinearLayout cat1, cat2, cat3, cat4;
}