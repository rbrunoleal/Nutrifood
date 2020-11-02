package tk.divesdk.nutrifood;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * Created by bruno on 06/09/16.
 */
public class tela_piramide extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_piramide);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
