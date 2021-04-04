package com.example.startintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final static String TEXT = "PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Uri uri= Uri.parse("example://intent");
            Intent runIntent = new Intent(Intent.ACTION_VIEW, uri);
            runIntent.putExtra(TEXT, editText.getText().toString());
            ActivityInfo activityInfo =
                    runIntent.resolveActivityInfo(getPackageManager(), runIntent.getFlags());
            if(activityInfo !=null) {
                startActivity(runIntent);
            }
            });
    }

}