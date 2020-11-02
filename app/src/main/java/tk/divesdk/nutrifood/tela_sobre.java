package tk.divesdk.nutrifood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class tela_sobre extends AppCompatActivity  {
    //private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sobre);
        /* Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);*/

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

    /*public void Clickgoogleplay(View v){
        EasyTracker tracker = EasyTracker.getInstance(tela_sobre.this);
        tracker.send(MapBuilder.createEvent("Botão", "Click", "GooglePlay", 10L).build());
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.facebook.katana&hl=pt_BR");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }*/

    public void Clickformulario(View v){
        EasyTracker tracker = EasyTracker.getInstance(tela_sobre.this);
        tracker.send(MapBuilder.createEvent("Botão", "Click", "Formulario", 9L).build());
        Uri uri = Uri.parse("http://goo.gl/forms/QmLw25RDuQ");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void Clickreferencias(View v){
        EasyTracker tracker = EasyTracker.getInstance(tela_sobre.this);
        Uri uri = Uri.parse("http://divesdk.tk/nfsolicitacao.html");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao bot�o Up/Home da actionbar
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }


}