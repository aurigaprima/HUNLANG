package com.example.hunlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Together_Activity extends AppCompatActivity {
    private TextView szoveg1;
    private Button TogetherActivityBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_together_);

        szoveg1 = (TextView) findViewById(R.id.textView_TogetherScreen_1);
        szoveg1.setText("TOOGETHER");

        TogetherActivityBackButton = (Button) findViewById(R.id.button_TogetherScreen_1);
        TogetherActivityBackButton.setOnClickListener(new View.OnClickListener() {
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
