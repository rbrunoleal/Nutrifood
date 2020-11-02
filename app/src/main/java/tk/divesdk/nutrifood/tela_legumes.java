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

public class tela_legumes extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private AdView mAdView;
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_legumes);
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
        listView = (ListView) findViewById(R.id.list2);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(getBaseContext(), legume_abobora.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), legume_abobrinha.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), legume_aipo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), legume_alface.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), legume_alho.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), legume_alhofrances.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), legume_azeitona.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), legume_batata.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), legume_batatadoce.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getBaseContext(), legume_beringela.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(getBaseContext(), legume_beterraba.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(getBaseContext(), legume_brocolis.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(getBaseContext(), legume_cebola.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(getBaseContext(), legume_cenoura.class);
                        startActivity(intent);
                        break;

                    case 14:
                        intent = new Intent(getBaseContext(), legume_chuchu.class);
                        startActivity(intent);
                        break;

                    case 15:
                        intent = new Intent(getBaseContext(), legume_cogumeloshiitake.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(getBaseContext(), legume_couve.class);
                        startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(getBaseContext(), legume_couvedebruxelas.class);
                        startActivity(intent);
                        break;
                    case 18:
                        intent = new Intent(getBaseContext(), legume_couveflor.class);
                        startActivity(intent);
                        break;
                    case 19:
                        intent = new Intent(getBaseContext(), legume_ervilha.class);
                        startActivity(intent);
                        break;
                    case 20:
                        intent = new Intent(getBaseContext(), legume_espinafre.class);
                        startActivity(intent);
                        break;
                    case 21:
                        intent = new Intent(getBaseContext(), legume_inhame.class);
                        startActivity(intent);
                        break;
                    case 22:
                        intent = new Intent(getBaseContext(), legume_nabo.class);
                        startActivity(intent);
                        break;
                    case 23:
                        intent = new Intent(getBaseContext(), legume_pepino.class);
                        startActivity(intent);
                        break;
                    case 24:
                        intent = new Intent(getBaseContext(), legume_pimentao.class);
                        startActivity(intent);
                        break;
                    case 25:
                        intent = new Intent(getBaseContext(), legume_tomate.class);
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
        ItemListView item1 = new ItemListView("Abobora", R.drawable.abobora);
        ItemListView item2 = new ItemListView("Abobrinha", R.drawable.abobrinha);
        ItemListView item3 = new ItemListView("Aipo", R.drawable.aipo);
        ItemListView item4 = new ItemListView("Alface", R.drawable.alface);
        ItemListView item5 = new ItemListView("Alho", R.drawable.alho);
        ItemListView item6 = new ItemListView("Alho Francês", R.drawable.alhofrances);
        ItemListView item7 = new ItemListView("Azeitona", R.drawable.azeitona);
        ItemListView item8 = new ItemListView("Batata", R.drawable.batata);
        ItemListView item9 = new ItemListView("Batata Doce", R.drawable.batatadoce);
        ItemListView item10 = new ItemListView("Beringela", R.drawable.beringela);
        ItemListView item11= new ItemListView("Beterraba", R.drawable.beterraba);
        ItemListView item12= new ItemListView("Brócolis", R.drawable.brocolis);
        ItemListView item13= new ItemListView("Cebola", R.drawable.cebola);
        ItemListView item14 = new ItemListView("Cenoura", R.drawable.cenoura);
        ItemListView item15 = new ItemListView("Chuchu", R.drawable.chuchu);
        ItemListView item16 = new ItemListView("Cogumelo Shiitake", R.drawable.cogumeloshiitake);
        ItemListView item17 = new ItemListView("Couve", R.drawable.couve);
        ItemListView item18 = new ItemListView("Couve de Bruxelas", R.drawable.couvedebruxelas);
        ItemListView item19 = new ItemListView("Couve Flor", R.drawable.couveflor);
        ItemListView item20 = new ItemListView("Ervilha", R.drawable.ervilhas);
        ItemListView item21 = new ItemListView("Espinafre", R.drawable.espinafres);
        ItemListView item22 = new ItemListView("Inhame", R.drawable.inhame);
        ItemListView item23 = new ItemListView("Nabo", R.drawable.nabo);
        ItemListView item24 = new ItemListView("Pepino", R.drawable.pepino);
        ItemListView item25 = new ItemListView("Pimentão", R.drawable.pimentao);
        ItemListView item26 = new ItemListView("Tomate", R.drawable.tomate);


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
