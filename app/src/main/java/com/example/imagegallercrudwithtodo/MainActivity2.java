package com.example.imagegallercrudwithtodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button button2;
    private TextView titleView, descView, categoryView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button2 = findViewById(R.id.button2);
        titleView = findViewById(R.id.titleText);
        descView = findViewById(R.id.descText);
        categoryView = findViewById(R.id.categoryText);
        imageView = findViewById(R.id.categoryImage);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // Get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String category = intent.getStringExtra("category");

        // Show text
        titleView.setText("Title: " + (title != null ? title : "N/A"));
        descView.setText("Description: " + (description != null ? description : "N/A"));
        categoryView.setText("Category: " + (category != null ? category : "N/A"));

        // Show image based on category
        if (category != null) {
            switch (category) {
                case "Nature":
                    imageView.setImageResource(R.drawable.e1);
                    break;
                case "Technology":
                    imageView.setImageResource(R.drawable.e2);
                    break;
                case "People":
                    imageView.setImageResource(R.drawable.e3);
                    break;
                case "Animals":
                    imageView.setImageResource(R.drawable.e4);
                    break;
                default:
                    imageView.setImageResource(R.drawable.e1); // fallback
                    break;
            }
        }
    }
}
