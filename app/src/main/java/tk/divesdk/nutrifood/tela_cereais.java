package tk.divesdk.nutrifood;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import tk.divesdk.nutrifood.Objeto.ItemListView;
import java.util.ArrayList;


public class tela_cereais extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private AdView mAdView;
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cereais);

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
        listView = (ListView) findViewById(R.id.list4);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(getBaseContext(), cereal_arrozintegral.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), cereal_aveia.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), cereal_centeio.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), cereal_cevada.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), cereal_milho.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), cereal_milhete.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), cereal_quinoa.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), cereal_trigo.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), cereal_trigosarraceno.class);
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
        ItemListView item1 = new ItemListView("Arroz Integral", R.drawable.arrozintegral);
        ItemListView item2 = new ItemListView("Aveia", R.drawable.aveia);
        ItemListView item3 = new ItemListView("Centeio", R.drawable.centeio);
        ItemListView item4 = new ItemListView("Cevada", R.drawable.cevada);
        ItemListView item5 = new ItemListView("Milho", R.drawable.milho);
        ItemListView item6 = new ItemListView("Milhete", R.drawable.milhete);
        ItemListView item7 = new ItemListView("Quinoa", R.drawable.quinoa);
        ItemListView item8 = new ItemListView("Trigo", R.drawable.trigo);
        ItemListView item9 = new ItemListView("Trigo Sarraceno", R.drawable.trigosarraceno);



        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);





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
