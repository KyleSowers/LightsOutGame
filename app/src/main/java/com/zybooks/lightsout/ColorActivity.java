package com.zybooks.lightsout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "com.zybooks.lightsout.color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void onColorSelected(View view) {
        int colorId = R.color.yellow;
        if (view.getId() == R.id.radio_red) {
            colorId = R.color.red;
        } else if (view.getId() == R.id.radio_orange) {
            colorId = R.color.orange;
        } else if (view.getId() == R.id.radio_green) {
            colorId = R.color.green;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_COLOR, colorId);
        setResult(RESULT_OK, intent);
        finish();
    }

}