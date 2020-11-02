package tk.divesdk.nutrifood;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import tk.divesdk.nutrifood.Objeto.ItemListView;
import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;

import com.google.analytics.tracking.android.EasyTracker;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class tela_frutas extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private AdView mAdView;
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_frutas);

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(getBaseContext(), fruta_abacate.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), fruta_abacaxi.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), fruta_acai.class);
                        startActivity(intent);
						break;
                    case 3:
                        intent = new Intent(getBaseContext(), fruta_acerola.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), fruta_ameixa.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), fruta_amora.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), fruta_banana.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), fruta_damasco.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), fruta_figo.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getBaseContext(), fruta_goiaba.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(getBaseContext(), fruta_graviola.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(getBaseContext(), fruta_kiwi.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(getBaseContext(), fruta_laranja.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(getBaseContext(), fruta_limao.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(getBaseContext(), fruta_maca.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(getBaseContext(), fruta_mamao.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(getBaseContext(), fruta_manga.class);
                        startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(getBaseContext(), fruta_mangaba.class);
                        startActivity(intent);
                        break;
                    case 18:
                        intent = new Intent(getBaseContext(), fruta_maracuja.class);
                        startActivity(intent);
                        break;
                    case 19:
                        intent = new Intent(getBaseContext(), fruta_melancia.class);
                        startActivity(intent);
                        break;
                    case 20:
                        intent = new Intent(getBaseContext(), fruta_melao.class);
                        startActivity(intent);
                        break;
                    case 21:
                        intent = new Intent(getBaseContext(), fruta_mirtilo.class);
                        startActivity(intent);
                        break;
                    case 22:
                        intent = new Intent(getBaseContext(), fruta_morango.class);
                        startActivity(intent);
                        break;
                    case 23:
                        intent = new Intent(getBaseContext(), fruta_pera.class);
                        startActivity(intent);
                        break;
                    case 24:
                        intent = new Intent(getBaseContext(), fruta_tangerina.class);
                        startActivity(intent);
                        break;
                    case 25:
                        intent = new Intent(getBaseContext(), fruta_toranja.class);
                        startActivity(intent);
                        break;
                    case 26:
                        intent = new Intent(getBaseContext(), fruta_uva.class);
                        startActivity(intent);
                        break;

                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void alerta(){
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.tela_alerta, null);

        view.findViewById(R.id.btcancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    // Analytics.
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }

    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Abacate", R.drawable.abacate);
        ItemListView item2 = new ItemListView("Abacaxi", R.drawable.abacaxi);
        ItemListView item3 = new ItemListView("Açaí", R.drawable.acai);
        ItemListView item4 = new ItemListView("Acerola", R.drawable.acerola);
        ItemListView item5 = new ItemListView("Ameixa", R.drawable.ameixa);
        ItemListView item6 = new ItemListView("Amora", R.drawable.amora);
        ItemListView item7 = new ItemListView("Banana", R.drawable.banana);
        ItemListView item8 = new ItemListView("Damasco", R.drawable.damasco);
        ItemListView item9 = new ItemListView("Figo", R.drawable.figo);
        ItemListView item10 = new ItemListView("Goiaba", R.drawable.goiaba);
        ItemListView item11 = new ItemListView("Graviola", R.drawable.graviola);
        ItemListView item12 = new ItemListView("Kiwi", R.drawable.kiwi);
        ItemListView item13 = new ItemListView("Laranja", R.drawable.laranja);
        ItemListView item14 = new ItemListView("Limão", R.drawable.limao);
        ItemListView item15 = new ItemListView("Maçã", R.drawable.maca);
        ItemListView item16 = new ItemListView("Mamão", R.drawable.mamao);
        ItemListView item17 = new ItemListView("Manga", R.drawable.manga);
        ItemListView item18 = new ItemListView("Mangaba", R.drawable.mangaba2);
        ItemListView item19 = new ItemListView("Maracujá", R.drawable.maracuja);
        ItemListView item20 = new ItemListView("Melancia", R.drawable.melancia);
        ItemListView item21 = new ItemListView("Melão", R.drawable.melao);
        ItemListView item22 = new ItemListView("Mirtilo", R.drawable.mirtilo);
        ItemListView item23 = new ItemListView("Morango", R.drawable.morango);
        ItemListView item24 = new ItemListView("Pêra", R.drawable.pera);
        ItemListView item25 = new ItemListView("Tangerina", R.drawable.tangerina);
        ItemListView item26 = new ItemListView("Toranja", R.drawable.toranja);
        ItemListView item27 = new ItemListView("Uva", R.drawable.uva);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);
        itens.add(item10);
        itens.add(item11);
        itens.add(item12);
        itens.add(item13);
        itens.add(item14);
        itens.add(item15);
        itens.add(item16);
        itens.add(item17);
        itens.add(item18);
        itens.add(item19);
        itens.add(item20);
        itens.add(item21);
        itens.add(item22);
        itens.add(item23);
        itens.add(item24);
        itens.add(item25);
        itens.add(item26);
        itens.add(item27);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();
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


