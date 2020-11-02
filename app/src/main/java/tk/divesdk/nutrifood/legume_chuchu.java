package tk.divesdk.nutrifood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class legume_chuchu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legume_chuchu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_label, menu);
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
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem actionViewItem = menu.findItem(R.id.miActionButton);
        // Retrieve the action-view from menu
        View v = MenuItemCompat.getActionView(actionViewItem);
        // Find the button within action-view
        Button b = (Button) v.findViewById(R.id.btnCustomAction);
        // Handle button click here
        b.setOnClickListener( new View.OnClickListener() { // FUN��O BOT�O
            @Override
            public void onClick(View v) { // FUN��O...
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                share.putExtra(Intent.EXTRA_SUBJECT,
                        "Descrição");
                share.putExtra(Intent.EXTRA_TEXT,
                        "Sua origem é atribuída à América Central em países como Costa Rica e Panamá. segundo alguns historiadores, essa hortaliça-fruto já era cultivada no Caribe na época do descobrimento da América. É uma trepadeira herbácea da família das cucurbitáceas. Do chuchu nada é desperdiçado: pode-se consumir as folhas, brotos e raízes da planta, depois de devidamente lavados.");

                startActivity(Intent.createChooser(share, "Compartilhar"));
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
}