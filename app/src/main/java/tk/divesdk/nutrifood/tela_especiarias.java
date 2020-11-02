package tk.divesdk.nutrifood;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import tk.divesdk.nutrifood.Objeto.ItemListView;


public class tela_especiarias extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private AdView mAdView;
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_especiarias);

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
        listView = (ListView) findViewById(R.id.list6);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(getBaseContext(), especiarias_acafrao.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), especiarias_canela.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), especiarias_cominho.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), especiarias_cravo.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), especiarias_gengibre.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), especiarias_pimentacaiena.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), especiarias_pimentadoreino.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), especiarias_pimentamalagueta.class);
                        startActivity(intent);
                        break;

                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        ItemListView item1 = new ItemListView("Açafrão", R.drawable.acaf);
        ItemListView item2 = new ItemListView("Canela", R.drawable.canela);
        ItemListView item3 = new ItemListView("Cominho", R.drawable.cominho);
        ItemListView item4 = new ItemListView("Cravo", R.drawable.cravo);
        ItemListView item5 = new ItemListView("Gengibre", R.drawable.gengibre);
        ItemListView item6 = new ItemListView("Pimenta Caiena", R.drawable.pimentadecaiena);
        ItemListView item7 = new ItemListView("Pimenta do Reino", R.drawable.pimentadoreino);
        ItemListView item8 = new ItemListView("Pimenta Malagueta", R.drawable.pimentamalagueta);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);


        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista � selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostra��o
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