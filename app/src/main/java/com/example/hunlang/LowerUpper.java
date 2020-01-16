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

public class LowerUpper extends AppCompatActivity {
    private ImageButton imageButton_LowerUpper;
    private TextView szovegmezo2;
    private Button gomb1, gomb2, gomb3;
    private ImageView kep;

    String szavak[][] = {
            {"Velencei-tó","velencei-tó"},{"Észak-Afrika","észak-afrika"},{"Egri Csillagok","egri csillagok"},{"Csepel-szigeti","csepel-szigeti"},
            {"Balaton-felvidéki","balaton-felvidéki"},{"Oslói","oslói"},{"Moszkvai","moszkvai"},{"Nemzeti dal","nemzeti dal"},{"A kőszívű ember fiai","A Kőszívű Ember Fiai"},
            {"Keleti pályaudvar","keleti pályaudvar"},{"Pénzügyminisztérium","pénzügyminisztérium"},{"pénzügyminisztériumi","Pénzügyminisztériumi"},{"Dél-budai","dél-budai"},
            {"Váci utca","váci utca"},{"Váci utcai","váci utcai"},{"Március 15. tér","március 15. tér"},{"Március 15. téri","március 15. téri"},
            {"Magyar Tudományos Akadémia","Magyar tudományos akadémia"},{"Holt-Tisza","Holt Tisza"},{"Magas-Tátra","Magas-tátra"},{"Szent Anna-tó","Szent Anna tó"},{"Csepel-sziget","Csepel Sziget"},{"Dunántúli-középhegység ","Dunántúli Középhegység "},{"Sváb-hegy","Sváb hegy"},{"Velencei-tó","Velencei tó"},
            {"Nemzeti Múzeum","Nemzeti múzeum"},{"Szegedi Nemzeti Színház.","szegedi nemzeti színház."},{"József Attila Gimnázium","József Attila gimnázium"},{"Országos Széchényi Könyvtár","Országos Széchényi könyvtár"}
    };
    Random random = new Random();
    int arrayLength = szavak.length;
    int randomInteger,randomszo,wordIndex1,wordIndex2,goodanswer,wronganswer;
    String str1 = "Összes kérdés/Jó/Rossz válaszok száma: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_upper);


// veletlen szópár kiválasztésa
        randomInteger = random.nextInt(arrayLength);
        randomszo = random.nextInt(2);
//változók inicializálása
        goodanswer = 0;
        wronganswer = 0;
        wordIndex1 = 0;
        wordIndex2 = 1;
//Szövegmezők feliratozása
        szovegmezo2 = (TextView) findViewById(R.id.szoveg2_LowerUpperScreen_1);
        szovegmezo2.setText(str1);
//gombok feliratozása
        gomb1 = (Button) findViewById(R.id.button1_LowerUpperScreen_1); // Felso gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb2 = (Button) findViewById(R.id.button2_LowerUpperScreen_1); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb3 = (Button) findViewById(R.id.button3_LowerUpperScreen_1); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        kep = (ImageView) findViewById(R.id.imageView_LowerUpperScreen_1);

        imageButton_LowerUpper = (ImageButton) findViewById(R.id.imageButton);
        imageButton_LowerUpper.setBackgroundColor(Color.WHITE);
        imageButton_LowerUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        gomb3.setEnabled(false);

        gomb1.setText(szavak[randomInteger][wordIndex1]); // Kivalasztok egy szópárelemet véletlenül, ez a kiinduló állapot
        gomb2.setText(szavak[randomInteger][wordIndex2]);
        gomb3.setText("Tovább");
        //Felső gomb események
        gomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gomb1.getText() == szavak[randomInteger][0]) { // megnézem hogy a kivalasztott szópr elem megegyezik-e a helyes elsõ szóval
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    gomb1.setBackgroundColor(Color.GREEN);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    gomb1.setBackgroundColor(Color.RED);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gomb2.setEnabled(false);
                gomb3.setEnabled(true);
            } });
//Alsó gomb események
        gomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gomb2.getText() == szavak[randomInteger][1]) {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    gomb2.setBackgroundColor(Color.RED);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    gomb2.setBackgroundColor(Color.GREEN);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gomb1.setEnabled(false);
                gomb3.setEnabled(true);
            } });
//Tovább gomb események
        gomb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Új véletlen szópár kiválasztása a tömbből
                randomInteger = random.nextInt(arrayLength);
                randomszo = random.nextInt(2);
                //Az adott szópáron belül véletlenszerűen jelenjenek meg a szavak a felső és alsó gombon
                if ( randomszo == 1 ) { wordIndex1 = 0;wordIndex2 = 1;} //Itt azt állítom be hogyha kiválasztottunk egy szópárból egy elemet akkor a különbözõ gpombokon a különbözõ szópár elemek jelenlenek meg
                else {wordIndex1 = 1; wordIndex2 = 0;}
                //gombok kattinthatóvá tétele
                gomb1.setEnabled(true);
                gomb2.setEnabled(true);
                //Véletlenszavak kiszedése a tömbböl és a gombfeliratozás beállítása
                gomb1.setText(szavak[randomInteger][wordIndex1]);
                gomb2.setText(szavak[randomInteger][wordIndex2]);
                //Gomok újra kattinthatóvá tétele
                gomb1.setBackgroundColor(Color.LTGRAY);
                gomb2.setBackgroundColor(Color.LTGRAY);
                gomb3.setEnabled(false);
                kep.setImageResource(R.drawable.question);
            } });

    }
    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



}
