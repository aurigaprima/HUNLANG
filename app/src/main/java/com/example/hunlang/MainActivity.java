package com.example.hunlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button TogetherButton,MixedButton,RulesButton,WithOrWithoutButton,UpperLowerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TogetherButton = (Button) findViewById(R.id.button2);
        TogetherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTogetherActivity();
            }
        });

        MixedButton = (Button) findViewById(R.id.button3);
        MixedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMixedActivity();
            }
        });

        RulesButton = (Button) findViewById(R.id.button1);
        RulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRulesActivity();
            }
        });

        WithOrWithoutButton = (Button) findViewById(R.id.button4);
        WithOrWithoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWithOrWithoutActivity();
            }
        });

        UpperLowerButton = (Button) findViewById(R.id.button5);
        UpperLowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLowerUpperActivity();
            }
        });
    }

    private void openTogetherActivity() {
        Intent intent = new Intent(this,Together_Activity.class);
        startActivity(intent);
    }
    private void openRulesActivity() {
        Intent intent = new Intent(this,Rules_Activity.class);
        startActivity(intent);
    }
    private void openMixedActivity() {
        Intent intent = new Intent(this,Mixed_Activity.class);
        startActivity(intent);
    }
    private void openWithOrWithoutActivity() {
        Intent intent = new Intent(this,WithOrWithout_Activity.class);
        startActivity(intent);
    }
    private void openLowerUpperActivity() {
        Intent intent = new Intent(this,LowerUpper.class);
        startActivity(intent);
    }

}