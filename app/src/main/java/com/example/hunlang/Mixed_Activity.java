package com.example.hunlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mixed_Activity extends AppCompatActivity {
    private TextView szoveg1;
    private Button MixedActivitBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixed_);

        szoveg1 = (TextView) findViewById(R.id.textView_MixedScreen_1);
        szoveg1.setText("MIXEDD");

        MixedActivitBackButton = (Button) findViewById(R.id.button_MixedScreen_1);
        MixedActivitBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });


    }
    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
