package com.example.imagegallercrudwithtodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText username, userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username);
        userpassword = findViewById(R.id.userpassword);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String name = username.getText().toString().trim();
            String password = userpassword.getText().toString().trim();

            // Check credentials: must match "admin"
            if (name.equals("dharm") && password.equals("dharm")) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("USERNAME_KEY", name); // pass username to next screen
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
