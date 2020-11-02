package tk.divesdk.nutrifood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class frutassecas_tamaras extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frutassecas_tamara);
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
            // Id correspondente ao botão Up/Home da actionbar
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
        b.setOnClickListener( new View.OnClickListener() { // FUNÇÂO BOTÂO
            @Override
            public void onClick(View v) { // FUNÇÂO...
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                share.putExtra(Intent.EXTRA_SUBJECT,
                        "Descrição");
                share.putExtra(Intent.EXTRA_TEXT,
                        "As tâmaras possuem coloração avermelhada e são frutos fibrosos de sabor agridoce. Possuem alto teor de tiramina e devido a isso as pessoas que fazem uso de IMAO devem ter precauções ao ingerir a fruta para evitar a elevação da pressão arterial.");

                startActivity(Intent.createChooser(share, "Compartilhar"));
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
}