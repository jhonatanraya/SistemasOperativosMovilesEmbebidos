package com.example.hito3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CuartaActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView TituCalcuCus;
    public Button limpiar,tangente,resta,igual,suma,poten,poten3,btSumN,btSumFibo,factorial,CloseApp;
    public double numeros[]=new double[8], resultado;
    public Button cero, uno, dos, tres, cuatro;
    public Boolean shiftEnabled=false,decimal=false,parentesis=false,rest=false,sum=false,div=false,multi=false,pot=false,consec=false, raiz=false,tange=false,cos=false,seno=false,pocen=false, facto=false;
    public TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta);
        InitializeComponents();
    }

    public void InitializeComponents(){
        TituCalcuCus = findViewById(R.id.textView3);
        String username= getIntent().getStringExtra("USERNAME");

        display=findViewById(R.id.txvResultado);
        limpiar= findViewById(R.id.btnlimpiar);
        limpiar.setOnClickListener(this);

        Button multi= (Button) findViewById(R.id.btnmultiplicar);
        multi.setOnClickListener(this);
        Button div=(Button) findViewById(R.id.btndividir);
        div.setOnClickListener(this);
        resta= findViewById(R.id.btnrestar);
        resta.setOnClickListener(this);
        igual= findViewById(R.id.btnigual);
        igual.setOnClickListener(this);
        factorial= findViewById(R.id.btnfactorial);
        factorial.setOnClickListener(this);
        suma= findViewById(R.id.btnsumar);
        suma.setOnClickListener(this);
        poten= findViewById(R.id.btnpotencia2);
        poten.setOnClickListener(this);
        poten3= findViewById(R.id.btnpotencia3);
        poten3.setOnClickListener(this);
        Button shift=(Button) findViewById(R.id.btnshift) ;
        shift.setOnClickListener(this);
        btSumN= findViewById(R.id.SumConsec);
        btSumN.setOnClickListener(this);
        btSumFibo = findViewById(R.id.btnfactorial);
        btSumFibo.setOnClickListener(this);
        CloseApp=findViewById(R.id.CloseApp);
        CloseApp.setOnClickListener(this);

        cero= findViewById(R.id.btn0);
        cero.setOnClickListener(this);
        uno=findViewById(R.id.btn1);
        uno.setOnClickListener(this);
        dos= findViewById(R.id.btn2);
        dos.setOnClickListener(this);
        tres= findViewById(R.id.btn3);
        tres.setOnClickListener(this);
        cuatro= findViewById(R.id.btn4);
        cuatro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int seleccion=v.getId();
        String a=display.getText().toString();
        try{
            switch (seleccion) {
                case R.id.btnshift:
                    shiftEnabled=!shiftEnabled;
                    if(!shiftEnabled) {
                        poten.setText("X2");
                    }else
                    {
                        poten.setText("X3");
                    }
                    if(!shiftEnabled) {
                        btSumN.setText("Ʃn");
                    }else
                    {
                        btSumN.setText("Ʃnxy");
                    }

                    if(!shiftEnabled) {
                        factorial.setText("N!");
                    }else
                    {
                        factorial.setText("ƩFibo");
                    }


                    break;
                case R.id.CloseApp:
                    Intent salida=new Intent( Intent.ACTION_MAIN); //Llamando a la activity principal
                    finish();


                    break;
                case R.id.btn0:
                    display.setText(a + "0");
                    break;
                case R.id.btn1:
                    display.setText(a + "1");
                    break;
                case R.id.btn2:
                    display.setText(a + "2");
                    break;
                case R.id.btn3:
                    display.setText(a + "3");
                    break;
                case R.id.btn4:
                    display.setText(a + "4");
                    break;
                case R.id.btnrestar:
                    rest = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btnsumar:
                    sum = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btnmultiplicar:
                    multi = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btndividir:
                    div = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.SumConsec:
                    consec=true;
                    numeros[0] = Double.parseDouble(a);
                    resultado=0;
                    //numeros[1]=Double.parseDouble(a);
                    for(int i=0;i<=numeros[0];i++){
                        resultado=resultado+i;
                    }
                    display.setText(String.valueOf(resultado));
                    decimal = false;
                    parentesis = false;


                    break;



                case R.id.btnigual:
                    numeros[1] = Double.parseDouble(a);
                    if (sum == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] + numeros[1];
                        }
                        display.setText(String.valueOf(resultado));

                    } else if (rest == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] - numeros[1];
                        }
                        display.setText(String.valueOf(resultado));
                    } else if (multi == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] * numeros[1];
                        }
                        display.setText(String.valueOf(resultado));

                    } else if (div == true) {
                        if(numeros[0]==0){
                            Toast.makeText(this,"Math ERROR", Toast.LENGTH_LONG).show();
                        }else
                            for (int i = 0; i < 8; i++) {
                                resultado = numeros[0] / numeros[1];
                            }
                        display.setText(String.valueOf(resultado));
                    }


                    break;
                case R.id.btnlimpiar:
                    display.setText("");
                    decimal=false;
                    parentesis=false;
                    break;
                case R.id.btnpotencia2:
                    pot = true;
                    if(shiftEnabled){
                        numeros[0] = Double.parseDouble(a);
                        //numeros[1]=Double.parseDouble(a);
                        resultado = Math.pow(numeros[0], 3);
                        display.setText(String.valueOf(resultado));
                        decimal = false;
                        parentesis = false;
                    }else{
                        numeros[0] = Double.parseDouble(a);
                        //numeros[1]=Double.parseDouble(a);
                        resultado = Math.pow(numeros[0], 2);
                        display.setText(String.valueOf(resultado));
                        decimal = false;
                        parentesis = false;
                    }

                    break;
                case R.id.btnpotencia3:
                    pot = true;
                    numeros[0] = Double.parseDouble(a);
                    //numeros[1]=Double.parseDouble(a);
                    resultado = Math.pow(numeros[0], 3);
                    display.setText(String.valueOf(resultado));
                    decimal = false;
                    parentesis = false;
                    break;
                case  R.id.btnfactorial:
                    facto=true;
                    if(shiftEnabled){
                        numeros[0] = Double.parseDouble(a);
                        int t1=0;
                        int t2=1;
                        int c=0;
                        resultado=1;
                        for(int i = 1;i<=numeros[0] - 2 ;++i){
                            c = t1 + t2;
                            t1 = t2;
                            t2 = c;
                            resultado = resultado + t2;
                        }
                        display.setText(String.valueOf(resultado));
                    }else {
                        numeros[0]=Double.parseDouble(a);
                        resultado=1;
                        for(int i=2;i<=numeros[0];i++){
                            resultado=resultado*i;
                        }
                        display.setText(String.valueOf(resultado));
                    }

                    break;
            }
        }catch (Exception e){
            display.setText("SintaxError");
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
