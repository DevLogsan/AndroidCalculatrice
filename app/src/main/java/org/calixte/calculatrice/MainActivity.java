package org.calixte.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAddition, buttonSubtraction, buttonDivision, buttonMultiplication;
    Button buttonClear, buttonEgal, buttonPoint;
    EditText ecran;

    private double nombre1, nombre2;
    private boolean calculPossible = false;                     // devient true au premier clic sur un opérateur
    private boolean premierChiffreSaisi = false;
    private String operateur= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisations();
    }

    public void initialisations() {

        //On récupère tout les éléments de notre interface graphique grâce aux ID

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSubtraction = (Button) findViewById(R.id.buttonSoustraction);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);

        ecran = (EditText) findViewById(R.id.editTextAffichage);
        //On attribut un écouteur d'évènement à tout les boutons
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurClick("+");
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurClick("-");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurClick("/");
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurClick("*");
            }
        });



        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
    }  // fin de la fonction Initialisations

    //voici la méthode qui est exécutée lorsque l'on clique sur un bouton chiffre
    public void chiffreClick(String unCaractere) {
        String lesCaracteresAffiches = "";
        if(premierChiffreSaisi == false|| ecran.getText ().equals ("0")){
            premierChiffreSaisi = true;
            lesCaracteresAffiches = unCaractere;
        }else{
            lesCaracteresAffiches = ecran.getText() + unCaractere;
        }
        ecran.setText(lesCaracteresAffiches);
    }

    //voici la méthode qui est exécutée lorsque l'on clique sur un des 4 opérateurs
    public void operateurClick(String unOperateur){
        if(calculPossible){
            calcul();
            ecran.setText(String.valueOf(nombre1));
        }else{
            nombre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            calculPossible = true;
        }
        operateur = unOperateur;
        premierChiffreSaisi = false;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton =

    public void egalClick(){
        calcul();
        premierChiffreSaisi = false;
        calculPossible = false;
    }
    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton C (Clear)

    public void resetClick(){
        calculPossible = false;
        premierChiffreSaisi = false;
        nombre1 = 0;
        operateur = "";
        ecran.setText("");
    }

    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur

    private void calcul(){
        nombre2 = Double.valueOf(ecran.getText().toString());
        if(operateur.equals("+")){
            nombre1 = nombre1 + nombre2;
            ecran.setText(String.valueOf(nombre1));
        }
        if(operateur.equals("-")){
            nombre1 = nombre1 - nombre2;
            ecran.setText(String.valueOf(nombre1));
        }
        if(operateur.equals("*")){
            nombre1 = nombre1 * nombre2;
            ecran.setText(String.valueOf(nombre1));
        }
        if(operateur.equals("/")){
            try{
                nombre1 = nombre1 / nombre2;
                ecran.setText(String.valueOf(nombre1));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }
}