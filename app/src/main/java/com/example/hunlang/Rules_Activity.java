package com.example.hunlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Rules_Activity extends AppCompatActivity {
    private ImageButton homeButton_Rules;
    private TextView question,result;
    private Button gombUpper, gombLower, gombCenter, gombForward;
    private ImageView kep;

    String fogalmak[] = {"Névelő","Névmás","Melléknévi igenév","Főnévi igenév","Összeolvadás","Mássalhangzó rövidülés"};
    String szavak[][] = {
            {"Az","Névelő"},{"Hallgat","Mássalhangzó rövidülés"},{"Bátyja","Írásban jelöletlen teljes hasonulás"},{"Ilyen","Melléknévi mutató névmás"}
    };
    Random random = new Random();
    int szavak_arrayLength = szavak.length; // a szavakat tartalmazó tömb hosszának megállapítása
    int fogalmak_arrayLength = fogalmak.length; // a fogalmakat tartalmazó tömb hosszának megállapítása
    int randomszam,randomszo,randomfogalom;
    int randomFogalom1,randomFogalom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_);

        randomszam = random.nextInt(szavak_arrayLength); // Véletlen szó kiválasztása a SZAVAK tömbből
        randomszo = random.nextInt(3); // Melyik gombra tegyük ki az 1 helyes és 2 helytelen fogalmat.
//        randomfogalom = random.nextInt(fogalmak_arrayLength); // véletlen fogalom kválasztása
// Itt kellene keresni még 2 szót a fogalmak közül amiben nincs 2 egyforma és nem egyznek meg a kiválasztott szóhoz tartozó fogalommal
        do {
            randomFogalom1 = random.nextInt(fogalmak_arrayLength);
            randomFogalom2 = random.nextInt(fogalmak_arrayLength);
        } while (randomFogalom1 == randomFogalom2 & ( (szavak[randomszo][1].equals(fogalmak[randomFogalom1])) | (szavak[randomszo][1].equals(fogalmak[randomFogalom2]))  ));


//Szövegmezők feliratozása
        question = (TextView) findViewById(R.id.szoveg2_RulesScreen_1);
        result = (TextView) findViewById(R.id.szoveg4_RulesScreen_1);
        result.setText(randomFogalom1 + " " + randomFogalom2);
//gombok megjelenítése
        gombUpper = (Button) findViewById(R.id.button2_RulesScreen_1); // Felso gomb beallitas
        gombCenter = (Button) findViewById(R.id.button1_RulesScreen_1); // Középső gomb beallitas
        gombLower = (Button) findViewById(R.id.button4_RulesScreen_1); // Alsó gomb beallitas
        gombForward = (Button) findViewById(R.id.button3_RulesScreen_1); // Tovább gomb beallitas
        kep = (ImageView) findViewById(R.id.imageView_RulesScreen_1);
        gombForward.setEnabled(false); // A továb gomb még inaktív
        // A vissza gomb
        homeButton_Rules = (ImageButton) findViewById(R.id.imageButton);
        homeButton_Rules.setBackgroundColor(Color.WHITE);
        homeButton_Rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
// A keresett szo kiirása
        question.setText(szavak[randomszam][0]);
// ITt az jön hogy véletlenszerűen az egyik gombra kirakom a jó választ
        switch (randomszo) {
            case 0:
                gombUpper.setText(szavak[randomszam][1]);

                break;
            case 1:
                gombCenter.setText(szavak[randomszam][1]);
                break;
            case 2:
                gombLower.setText(szavak[randomszam][1]);
                break;
        }
// A többi gomb szövegének beállítása

    }
    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
