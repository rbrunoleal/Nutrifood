package tk.divesdk.nutrifood;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class tela_nutrientes extends ActionBarActivity {

    private AdView mAdView;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_nutrientes);
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

        String[] atividades = new String[]{"Vitamina A", "Vitaminas (Complexo B)", "Vitamina C",
                "Vitamina D", "Vitamina E","Vitamina H", "Vitamina K","Calcio","Cobre","Cromo","Ferro","Fósforo","Iodo","Magnésio",
                "Manganês","Molibdênio","Potássio","Selênio","Sódio","Zinco"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, atividades);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(chamaAtividades());

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

    public OnItemClickListener chamaAtividades(){
        return(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                Intent intent;

                switch(position){
                    case 0:
                        intent = new Intent(getBaseContext(), nutricao_vitaminaa.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), nutricao_complexob.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), nutricao_vitaminac.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), nutricao_vitaminad.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), nutricao_vitaminae.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), nutricao_vitaminah.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), nutricao_vitaminak.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), nutricao_calcio.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), nutricao_cobre.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getBaseContext(), nutricao_cromo.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(getBaseContext(), nutricao_ferro.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(getBaseContext(), nutricao_fosforo.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(getBaseContext(), nutricao_iodo.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(getBaseContext(), nutricao_magnesio.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(getBaseContext(), nutricao_manganes.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(getBaseContext(), nutricao_molibdenio.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(getBaseContext(), nutricao_potassio.class);
                        startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(getBaseContext(), nutricao_selenio.class);
                        startActivity(intent);
                        break;
                    case 18:
                        intent = new Intent(getBaseContext(), nutricao_sodio.class);
                        startActivity(intent);
                        break;
                    case 19:
                        intent = new Intent(getBaseContext(), nutricao_zinco.class);
                        startActivity(intent);
                        break;

                }
            }

        });
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