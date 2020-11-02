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


public class tela_leguminosas extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private AdView mAdView;
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_leguminosas);
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
        listView = (ListView) findViewById(R.id.list3);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {

                    case 0:
                        intent = new Intent(getBaseContext(), leguminosas_amendoim.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(getBaseContext(), leguminosas_fava.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), leguminosas_feijaobranco.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), leguminosas_feijaopreto.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), leguminosas_feijaovermelho.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), leguminosas_graodebico.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), leguminosas_lentilha.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), leguminosas_miso.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), leguminosas_soja.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getBaseContext(), leguminosas_tofu.class);
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
        ItemListView item1 = new ItemListView("Amendoim", R.drawable.amendoim);
        ItemListView item2 = new ItemListView("Fava", R.drawable.fava);
        ItemListView item3 = new ItemListView("Feijão Branco", R.drawable.feijaobranco);
        ItemListView item4 = new ItemListView("Feijão Preto", R.drawable.feijaopreto);
        ItemListView item5 = new ItemListView("Feijão Vermelho", R.drawable.feijaovermelho);
        ItemListView item6 = new ItemListView("Grão de Bico", R.drawable.graodebico);
        ItemListView item7 = new ItemListView("Lentilha", R.drawable.lentilha);
        ItemListView item8 = new ItemListView("Miso", R.drawable.miso);
        ItemListView item9 = new ItemListView("Soja", R.drawable.soja);
        ItemListView item10 = new ItemListView("Tofu", R.drawable.tofu);


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
