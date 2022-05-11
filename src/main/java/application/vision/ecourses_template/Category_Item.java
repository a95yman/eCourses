package application.vision.ecourses_template;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Category_Item extends RelativeLayout {
    LayoutInflater inflater;
    public Category_Item(Context context, String name) {
        super(context);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.course, this, true);
        ((TextView) findViewById(R.id.category_name)).setText(name);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, CourseOverview.class));
            }
        });
    }
    public void Show(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.parr).animate().alpha(1).setDuration(300);
            }
        }, 100);
    }
}
