package tk.divesdk.nutrifood;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

/**
 * Created by clovisgrj on 28/11/15.
 */
public class tela_gcorp extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_gcorp);
        calculos();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


   }
        public void calculos() {


            final EditText textpeso = (EditText) findViewById(R.id.editpeso);
            final EditText textaltura = (EditText) findViewById(R.id.editalt);
            final TextView textresultado = (TextView) findViewById(R.id.resposta);
            final TextView textpeside = (TextView) findViewById(R.id.peside);
            final TextView textobesidade = (TextView) findViewById(R.id.obesidade1);
            final TextView textsobre = (TextView) findViewById(R.id.sobre1);
            final TextView textabaixo = (TextView) findViewById(R.id.abaixo);
            final TextView textobm = (TextView) findViewById(R.id.obesidadem1);
            final TextView textnormal1 = (TextView) findViewById(R.id.normal1);

            Button calcular = (Button) findViewById(R.id.calcular);
            calcular.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    double num = Double.parseDouble(textpeso.getText().toString());
                    double num2 = Double.parseDouble(textaltura.getText().toString());
                    if (num / (num2 * num2) < 18.5) {
                        textabaixo.setTextColor(Color.MAGENTA);
                        textnormal1.setTextColor(Color.BLACK);
                        textobm.setTextColor(Color.BLACK);
                        textsobre.setTextColor(Color.BLACK);
                        textobesidade.setTextColor(Color.BLACK);

                    } else if (num / (num2 * num2) >= 18.5 && (num / (num2 * num2) < 25.0)) {
                        textnormal1.setTextColor(Color.MAGENTA);
                        textabaixo.setTextColor(Color.BLACK);
                        textobm.setTextColor(Color.BLACK);
                        textsobre.setTextColor(Color.BLACK);
                        textobesidade.setTextColor(Color.BLACK);
                    } else if (num / (num2 * num2) >= 25.0 && (num / (num2 * num2) < 30.0)) {
                        textnormal1.setTextColor(Color.BLACK);
                        textabaixo.setTextColor(Color.BLACK);
                        textobm.setTextColor(Color.BLACK);
                        textsobre.setTextColor(Color.MAGENTA);
                        textobesidade.setTextColor(Color.BLACK);
                    } else if (num / (num2 * num2) >= 30.0 && (num / (num2 * num2) < 40.0)) {
                        textnormal1.setTextColor(Color.BLACK);
                        textabaixo.setTextColor(Color.BLACK);
                        textobm.setTextColor(Color.BLACK);
                        textsobre.setTextColor(Color.BLACK);
                        textobesidade.setTextColor(Color.MAGENTA);
                    } else {
                        textnormal1.setTextColor(Color.BLACK);
                        textabaixo.setTextColor(Color.BLACK);
                        textobm.setTextColor(Color.MAGENTA);
                        textsobre.setTextColor(Color.BLACK);
                        textobesidade.setTextColor(Color.BLACK);
                    }


                    double imc = num / (num2 * num2);
                    DecimalFormat df = new DecimalFormat("0.#");
                    String imcv = df.format(imc);
                    textresultado.setText("" + imcv);
                    double peside1 = (num2 * num2 * 18.5), peside2 = (num2 * num2 * 25.0);
                    String pi1 = df.format(peside1);
                    String pi2 = df.format(peside2);
                    textpeside.setText("" + (pi1) + "  a  " + (pi2));
                }
            });
        }

    public void clickt(View v) {
        Intent it = new Intent(getBaseContext(), tela_imc.class);
        startActivity(it);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }



    }
