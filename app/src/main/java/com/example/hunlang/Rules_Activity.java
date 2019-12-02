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
//START
    private ImageButton homeButton_Rules;
    private TextView question,result;
    private Button gombUpper, gombLower, gombCenter, gombForward;
    private ImageView kep;

    String fogalmak[] = {"Névelő","Névmás","Melléknévi igenév","Főnévi igenév","Összeolvadás","Mássalhangzó rövidülés","Mássalhangzó kiesés",
            "Írásban jelöletlen teljes hasonulás","Írásban jelölt teljes hasonulás","Részleges hasonulás - Zöngétlenné válás","Részleges hasonulás - Zöngéssé válás",
            "Részleges hasonulás - Képzés helye szerinti","Főnévi mutató névmás","Melléknévi mutató névmás","Számnévi mutató névmás"
    };
    String fogalmak2[] = new String[fogalmak.length-1];
    String szavak[][] = {
            {"Az","Névelő"},{"Hallgat","Mássalhangzó rövidülés"},{"Bátyja","Írásban jelöletlen teljes hasonulás"},{"Ilyen","Melléknévi mutató névmás"},
            {"Virággal","Írásban jelölt teljes hasonulás"},{"Anyja","Írásban jelöletlen teljes hasonulás"},{"Éljen","Írásban jelöletlen teljes hasonulás"},
            {"Egészség","Írásban jelöletlen teljes hasonulás"},{"Átcipel","Írásban jelöletlen teljes hasonulás"},{"Álljunk","Írásban jelöletlen teljes hasonulás"},
            {"Szálljunk","Írásban jelöletlen teljes hasonulás"},{"Utca","Írásban jelöletlen teljes hasonulás"},{"Otthon","Mássalhangzó rövidülés"},{"Játszik","Összeolvadás"},
            {"Látszik","Összeolvadás"},{"Tetszik","Összeolvadás"},{"Játszik","Összeolvadás"},{"Barátság","Összeolvadás"},{"Költség","Összeolvadás"},{"Családja","Összeolvadás"},
            {"Játszik","Összeolvadás"},{"Dobszó","Részleges hasonulás - Zöngétlenné válás"},{"Vízpart","Részleges hasonulás - Zöngétlenné válás"},{"Szívtelen","Részleges hasonulás - Zöngétlenné válás"},
            {"Hegytető","Részleges hasonulás - Zöngétlenné válás"},{"Népdal","Részleges hasonulás - Zöngéssé válás"},{"Versben","Részleges hasonulás - Zöngéssé válás"},{"Patakban","Részleges hasonulás - Zöngéssé válás"},
            {"Színpad","Részleges hasonulás - Képzés helye szerinti"},{"Különben","Részleges hasonulás - Képzés helye szerinti"},{"Azonban","Részleges hasonulás - Képzés helye szerinti"},
            {"Szénpor","Részleges hasonulás - Képzés helye szerinti"},{"Öngyújtó","Részleges hasonulás - Képzés helye szerinti"},
            {"Ez","Főnévi mutató névmás"},{"Emez","Főnévi mutató névmás"},{"Amaz","Főnévi mutató névmás"},{"Ugyanez","Főnévi mutató névmás"},{"Ugyanaz","Főnévi mutató névmás"},
            {"Ily","Melléknévi mutató névmás"},{"Oly","Melléknévi mutató névmás"},{"Ilyen","Melléknévi mutató névmás"},{"Olyan","Melléknévi mutató névmás"},{"Ekkora","Melléknévi mutató névmás"},{"Akkora","Melléknévi mutató névmás"},
            {"Efféle","Melléknévi mutató névmás"},{"Olyanféle","Melléknévi mutató névmás"},{"Emilyen","Melléknévi mutató névmás"},{"Olyasmi","Melléknévi mutató névmás"},{"Ugyanilyen","Melléknévi mutató névmás"},
            {"Ennyi","Számnévi mutató névmás"},{"Amannyi","Számnévi mutató névmás"},{"Ugyananyi","Számnévi mutató névmás"},
    };
    Random random = new Random();
    int szavak_arrayLength = szavak.length; // a szavakat tartalmazó tömb hosszának megállapítása
    int randomszam,randomszo,randomFogalom1,randomFogalom2,goodanswer,wronganswer;
    String str1 = "Eredmény: ";
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_);
//Szövegmezők feliratozása
        question = (TextView) findViewById(R.id.szoveg2_RulesScreen_1);
        result = (TextView) findViewById(R.id.szoveg4_RulesScreen_1);
//gombok megjelenítése
        gombUpper = (Button) findViewById(R.id.button2_RulesScreen_1); // Felso gomb beallitas
        gombCenter = (Button) findViewById(R.id.button1_RulesScreen_1); // Középső gomb beallitas
        gombLower = (Button) findViewById(R.id.button4_RulesScreen_1); // Alsó gomb beallitas
        gombForward = (Button) findViewById(R.id.button3_RulesScreen_1); // Tovább gomb beallitas
        kep = (ImageView) findViewById(R.id.imageView_RulesScreen_1);
        gombForward.setEnabled(false); // A továb gomb még inaktív
        result.setText(str1);
// A vissza gomb
        homeButton_Rules = (ImageButton) findViewById(R.id.imageButton);
        homeButton_Rules.setBackgroundColor(Color.WHITE);
        homeButton_Rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
//
        randomNumberGenerator();
/*
        randomszam = random.nextInt(szavak_arrayLength); // Véletlen szó kiválasztása a SZAVAK tömbből
        randomszo = random.nextInt(3); // Melyik gombra tegyük ki az 1 helyes és 2 helytelen fogalmat
// A keresett szo megjelenitese
        question.setText(szavak[randomszam][0]);
// Itt az jön hogy csinálok egy másik tömböt amiben már nincs benne az a fogalom amit kirakok az egyik gombra. Így csak ebbeől kell 2 egymással nem egyenlő számot véletlen egnerálni
        for (int i=0;i<fogalmak.length;i++) {
            if(!szavak[randomszam][1].equals(fogalmak[i])) {
                fogalmak2[j] = fogalmak[i];
                j++;
            }
        }
//1 veletlen szo a röviditett tömbből
        randomFogalom1 = random.nextInt(fogalmak2.length);
// Itt kellene keresni még 1 szót a fogalmak közül amiben nincs 2 egyforma és nem egyeznek meg a kiválasztott szóhoz tartozó fogalommal
        do {
            randomFogalom2 = random.nextInt(fogalmak2.length);
    } while (randomFogalom2 == randomFogalom1);
*/


//result.setText(fogalmak2[0] + "//" + randomFogalom1 + ":" + fogalmak2[randomFogalom1] + " " + randomFogalom2 + ":" + fogalmak2[randomFogalom2]);
        goodanswer = 0;
        wronganswer = 0;

// ITt az jön hogy véletlenszerűen az egyik gombra kirakom a jó választ
        switch (randomszo) {
            case 0:
                gombUpper.setText(szavak[randomszam][1]);
                gombCenter.setText(fogalmak2[randomFogalom1]);
                gombLower.setText(fogalmak2[randomFogalom2]);
                break;
            case 1:
                gombUpper.setText(fogalmak2[randomFogalom1]);
                gombCenter.setText(szavak[randomszam][1]);
                gombLower.setText(fogalmak2[randomFogalom2]);
                break;
            case 2:
                gombUpper.setText(fogalmak2[randomFogalom1]);
                gombCenter.setText(fogalmak2[randomFogalom2]);
                gombLower.setText(szavak[randomszam][1]);
                break;
        }
// Felső gomb click esemény beállítás
        gombUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gombUpper.getText() == szavak[randomszam][1]) { // megnézem hogy a kivalasztott szópr elem megegyezik-e a helyes elsõ szóval
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    gombUpper.setBackgroundColor(Color.GREEN);
                    result.setText(str1+(goodanswer+wronganswer)+"/"+goodanswer+"/"+wronganswer+"/"+(goodanswer/(goodanswer+wronganswer))*100);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    gombUpper.setBackgroundColor(Color.RED);
                    result.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer+"/"+(goodanswer/(goodanswer+wronganswer))*100);
                }
                gombCenter.setEnabled(false);
                gombLower.setEnabled(false);
                gombForward.setEnabled(true);
            } });
// Középső gomb click esemény beállítás
        gombCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gombCenter.getText() == szavak[randomszam][1]) { // megnézem hogy a kivalasztott szópr elem megegyezik-e a helyes elsõ szóval
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    gombCenter.setBackgroundColor(Color.GREEN);
                    result.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    gombCenter.setBackgroundColor(Color.RED);
                    result.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gombUpper.setEnabled(false);
                gombLower.setEnabled(false);
                gombForward.setEnabled(true);
            } });
// Alsó gomb click esemény beállítás
        gombLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gombLower.getText() == szavak[randomszam][1]) { // megnézem hogy a kivalasztott szópr elem megegyezik-e a helyes elsõ szóval
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    gombLower.setBackgroundColor(Color.GREEN);
                    result.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    gombLower.setBackgroundColor(Color.RED);
                    result.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gombUpper.setEnabled(false);
                gombCenter.setEnabled(false);
                gombForward.setEnabled(true);
            } });
//Tovább gomb események
        gombForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            randomNumberGenerator();
/*                int j = 0;
                randomszam = random.nextInt(szavak_arrayLength); // Véletlen szó kiválasztása a SZAVAK tömbből
                randomszo = random.nextInt(3); // Melyik gombra tegyük ki az 1 helyes és 2 helytelen fogalmat
// A keresett szo megjelenitese
                question.setText(szavak[randomszam][0]);

// Itt az jön hogy csinálok egy másik tömböt amiben már nincs benne az a fogalom amit kirakok az egyik gombra. Így csak ebbeől kell 2 egymással nem egyenlő számot véletlen egnerálni
                for (int i=0;i<fogalmak.length;i++) {
                    if(!szavak[randomszam][1].equals(fogalmak[i])) {
                        fogalmak2[j] = fogalmak[i];
                        j++;
                    }
                }

//1 veletlen szo a röviditett tömbből
                randomFogalom1 = random.nextInt(fogalmak2.length);
// Itt kellene keresni még 1 szót a fogalmak közül amiben nincs 2 egyforma és nem egyeznek meg a kiválasztott szóhoz tartozó fogalommal
                do {
                    randomFogalom2 = random.nextInt(fogalmak2.length);
                } while (randomFogalom2 == randomFogalom1);
*/
// ITt az jön hogy véletlenszerűen az egyik gombra kirakom a jó választ, a másik 2-re pedig rosszakat
                switch (randomszo) {
                    case 0:
                        gombUpper.setText(szavak[randomszam][1]);
                        gombCenter.setText(fogalmak2[randomFogalom1]);
                        gombLower.setText(fogalmak2[randomFogalom2]);
                        break;
                    case 1:
                        gombUpper.setText(fogalmak2[randomFogalom1]);
                        gombCenter.setText(szavak[randomszam][1]);
                        gombLower.setText(fogalmak2[randomFogalom2]);
                        break;
                    case 2:
                        gombUpper.setText(fogalmak2[randomFogalom1]);
                        gombCenter.setText(fogalmak2[randomFogalom2]);
                        gombLower.setText(szavak[randomszam][1]);
                        break;
                }
                //gombok kattinthatóvá tétele
                gombUpper.setEnabled(true);
                gombCenter.setEnabled(true);
                gombLower.setEnabled(true);
                //Gombok színek
                gombUpper.setBackgroundColor(Color.LTGRAY);
                gombCenter.setBackgroundColor(Color.LTGRAY);
                gombLower.setBackgroundColor(Color.LTGRAY);
                // Tovább gomb inaktív
                gombForward.setEnabled(false);
                kep.setImageResource(R.drawable.question);
            } });
    }
    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    void randomNumberGenerator() {
        int j = 0;
        randomszam = random.nextInt(szavak_arrayLength); // Véletlen szó kiválasztása a SZAVAK tömbből
        randomszo = random.nextInt(3); // Melyik gombra tegyük ki az 1 helyes és 2 helytelen fogalmat
        // A keresett szo megjelenitese
        question.setText(szavak[randomszam][0]);

        // Itt az jön hogy csinálok egy másik tömböt amiben már nincs benne az a fogalom amit kirakok az egyik gombra. Így csak ebbeől kell 2 egymással nem egyenlő számot véletlen egnerálni
        for (int i=0;i<fogalmak.length;i++) {
            if(!szavak[randomszam][1].equals(fogalmak[i])) {
                fogalmak2[j] = fogalmak[i];
                j++;
            }
        }
        //1 veletlen szo a röviditett tömbből
        randomFogalom1 = random.nextInt(fogalmak2.length);
        // Itt kellene keresni még 1 szót a fogalmak közül amiben nincs 2 egyforma és nem egyeznek meg a kiválasztott szóhoz tartozó fogalommal
        do {
            randomFogalom2 = random.nextInt(fogalmak2.length);
        } while (randomFogalom2 == randomFogalom1);
    }
    void randomWordDisplay() {

    }
//END
}
