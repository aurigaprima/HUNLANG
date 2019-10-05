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

public class Together_Activity extends AppCompatActivity {
    private ImageButton imageButton_Together;
    private TextView szovegmezo1,szovegmezo2;
    private Button gomb1, gomb2, gomb3;
    private ImageView kep;

    String szavak[][] = {
            {"Egybeolvad","Egybe olvad"},{"Egybevág","Egybe vág"},{"Félreért","Félre ért"},{"Félreolvas","Félre olvas"},{"Felülemelkedik","Felül emelkedik"},{"Felülbírál","Felül bírál"},
            {"Fenntart","Fenn tart"},{"Fennmarad","Fenn marad"},{"Hazamegy","Haza megy"},{"Helyrejön","Helyre jön"},{"Jóvátesz","Jóvá tesz"},{"Kettéágazik","Ketté ágazik"},
            {"Kölcsönad","Kölcsön ad"},{"Körbejár","Körbe jár"},{"Különválaszt","Külön választ"},{"Létrehoz","Létre hoz"},{"Mellétalál","Mellé talál"},{"Odanéz","Oda néz"},
            {"Rajtaüt","Rajta üt"},{"Szembekerül","Szembe kerül"},{"Szerteszór","Szerte szór"},{"Továbbfejleszt","Tovább fejleszt"},{"Tönkretesz","Tönkre tesz"},
            {"Túlél","Túl él"},{"Újjászületik","Újjá születik"},{"Újrakezd","Újrakezd"},{"Utánakérdez","Utána kérdez"},{"Végbemegy","Végbe megy"},{"Végigmér","Végig mér"},
            {"Csődöt mond","Csődötmond"},{"Dugába dől","Dugábadől"},{"Cserbenhagy","Cserben hagy"},{"Egyetért","Egyet ért"},{"Együttműködik","Együtt működik"},
            {"Ellentmond","Ellent mond"},{"Előrejelez","Előre jelez"},{"Észrevesz","Észre vesz"},{"Helybenhagy","Helyben hagy"},{"Helytálló","Helyt álló"},
            {"Jólesik","Jól esik"},{"Jóllakik","Jól lakik"},{"Karbantart","Karban tart"},{"Kétségbeesik","Kétségbe esik"},{"Közzéteszt","Közzé tesz"},{"Közread","Közre ad"},
            {"Nagyothall","Nagyot hall"},{"Nyilvántart","Nyilván tart"},{"Rendreutasít","Rendre utasít"},{"Szemrevételez","Szemre vételez"},{"Útbaigazít","Útba igazít"},
            {"Véghez visz","Véghez visz"},{"Végrehajt","Végre hajt"},{"Bele szeretett volna szólni","Beleszeretett volna szólni"},{"Ajánlólevél","Ajánló levél"},
            {"Néhányszor","Néhány szor"},{"Akadálymentesítés","Akadály mentesítés"},{"Magánfelhasználó","Magán felhasználó"},{"Nemesacél","Nemes acél"},{"Kaszáscsillag","Kaszás-csillag"},
            {"Légi forgalmi társaság","Légiforgalmi társaság"},{"Idejétmúlt","Idejét múlt"},{"Semmirekellő","Semmire kellő"},{"Barátfüle","Barát füle"},{"Bolondokháza","Bolondok háza"},
            {"Ágrólszakadt","Ágról szakadt"},{"Bokor mögötti","Bokormögötti"},{"Föld alatti","Földalatti"},{"Idő előtti","Időelőtti"},{"Délelőtt","Dél előtt"},{"Holnapután","Holnap után"},
            {"Munkanélküli","Munka nélküli"},{"Félig kész","Féligkész"},{"Félkész","Fél kész"},{"Napsugár","Nap sugár"},{"Vitamindús","Vitamin dús"},{"Autómentő","Autó mentő"},
            {"Szélvédett","Szél védett"},{"Tizenöt méteres","Tizenötméteres"},{"Halvány kékeszöld","Halványkékeszöld"},{"Üljünk bele","Üljünkbele"},{"El ne késs","Elnekéss"},{"Meg fogom nézni","Megfogom nézni"},
            {"Hozzájárul","Hozzá járul"},{"Hozzá ment feleségül","Hozzáment feleségül"},{"E szerint","Eszerint"},{"A nélkül","Anélkül"},{"Házhoz szállít","Házhozszállít"}
    };
    Random random = new Random();
    int arrayLength = szavak.length;
    int randomInteger,randomszo,wordIndex1,wordIndex2,goodanswer,wronganswer;
    String str1 = "Összes kérdés/Jó/Rossz válaszok száma: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_together_);
// veletlen szópár kiválasztésa
        randomInteger = random.nextInt(arrayLength);
        randomszo = random.nextInt(2);
//változók inicializálása
        goodanswer = 0;
        wronganswer = 0;
        wordIndex1 = 0;
        wordIndex2 = 1;
//Szövegmezők feliratozása
        szovegmezo2 = (TextView) findViewById(R.id.szoveg2_TogetherScreen_1);
        szovegmezo2.setText(str1);
//gombok feliratozása
        gomb1 = (Button) findViewById(R.id.button1_TogetherScreen_1); // Felso gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb2 = (Button) findViewById(R.id.button2_TogetherScreen_1); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb3 = (Button) findViewById(R.id.button3_TogetherScreen_1); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        kep = (ImageView) findViewById(R.id.imageView_TogetherScreen_1);

        imageButton_Together = (ImageButton) findViewById(R.id.imageButton);
        imageButton_Together.setBackgroundColor(Color.WHITE);
        imageButton_Together.setOnClickListener(new View.OnClickListener() {
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
                    //szovegmezo1.setText("Helyes");
                    gomb1.setBackgroundColor(Color.GREEN);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    //szovegmezo1.setText("helytelen");
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
                    //szovegmezo1.setText("helytelen");
                    gomb2.setBackgroundColor(Color.RED);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    //szovegmezo1.setText("Helyes");
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
