package com.example.sample;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.start);
        Button button2 = findViewById(R.id.stop);
        ImageView  imageView = findViewById(R.id.pinwheel);
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 360);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.cancel();
            }
        });



    }
}