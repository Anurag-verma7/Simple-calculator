package com.example.mycalc;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }
    TextView txtcalculations;
    TextView txtresults;
    private String currentnumber;
    private String stringatleft;
    private String stringatright;
    private OPERATOR currentoperator;
    private int calulationsresults;
    private String cals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currentnumber="";
        cals="";
        calulationsresults=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtcalculations =findViewById(R.id.txtcalulations);
        txtresults =findViewById(R.id.txtresults);
        findViewById(R.id.btnequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnzero).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnminus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnclear).setOnClickListener(MainActivity.this);

       // FloatingActionButton fab = findViewById(R.id.fab);
       // fab.setOnClickListener(new View.OnClickListener() {
          // @Override
          //  public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
            //}
        //});
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnequal:
                operatoristapped(OPERATOR.EQUAL);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btnzero:
                numberIsTapped(0);
                break;
            case R.id.btnplus:
                operatoristapped(OPERATOR.PLUS);
                cals+=" + ";
                break;
            case R.id.btnminus:
                operatoristapped(OPERATOR.SUBTRACT);
                cals+=" - ";
                break;
            case R.id.btnmultiply:
                operatoristapped(OPERATOR.MULTIPLY);
                cals+=" * ";
                break;
            case R.id.btndivide:
                operatoristapped(OPERATOR.DIVIDE);
                cals+=" / ";
                break;
            case R.id.btnclear:
                cleartxt();
                break;

        }
        txtcalculations.setText(cals);
    }
    private void numberIsTapped(int TappedNumber){
        currentnumber=currentnumber+String.valueOf(TappedNumber);
        txtresults.setText(currentnumber);
        cals=currentnumber;
        txtcalculations.setText(cals);

    }
    private void operatoristapped(OPERATOR TappedOperator){
        if(currentoperator!=null) {
            if (currentnumber != "") {
                stringatright = currentnumber;
                currentnumber = "";
                switch (currentoperator) {
                    case PLUS:
                        calulationsresults = Integer.parseInt(stringatleft) + Integer.parseInt(stringatright);
                        break;
                    case SUBTRACT:
                        calulationsresults = Integer.parseInt(stringatleft) - Integer.parseInt(stringatright);
                        break;
                    case MULTIPLY:
                        calulationsresults = Integer.parseInt(stringatleft) * Integer.parseInt(stringatright);
                        break;
                    case DIVIDE:
                        calulationsresults = Integer.parseInt(stringatleft) / Integer.parseInt(stringatright);
                        break;
                }
                stringatleft = String.valueOf(calulationsresults);
                txtresults.setText(stringatleft);
                cals = stringatleft;
            }
        }
        else{
            stringatleft=currentnumber;
            currentnumber="";
        }
        currentoperator=TappedOperator;
    }
    private void cleartxt(){
        stringatleft="";
        stringatright="";
        calulationsresults=0;
        currentnumber="";
        currentoperator=null;
        cals="";
        txtcalculations.setText("0");
        txtresults.setText("0");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
