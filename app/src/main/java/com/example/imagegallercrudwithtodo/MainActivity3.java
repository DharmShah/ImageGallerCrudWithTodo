package com.example.imagegallercrudwithtodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Button button3;
    private EditText titleimg, descriptionimg;
    private Spinner dropdownimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button3 = findViewById(R.id.button3);
        titleimg = findViewById(R.id.titleimg);
        descriptionimg = findViewById(R.id.descriptionimg);
        dropdownimg = findViewById(R.id.dropdownimg);

        // Category options
        String[] categories = {"Nature", "Technology", "People", "Animals"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dropdownimg.setAdapter(adapter);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleimg.getText().toString();
                String description = descriptionimg.getText().toString();
                String category = dropdownimg.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });
    }
}
