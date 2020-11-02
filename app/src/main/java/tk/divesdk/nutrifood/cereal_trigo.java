package tk.divesdk.nutrifood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class cereal_trigo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cereal_trigo);
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
                        "O trigo é uma gramínea cultivada em todo o mundo. Globalmente, é a segunda maior cultura de cereais, a seguir ao milho; a terceira é o arroz. O grão de trigo é um alimento básico usado para fazer farinha e, com esta, o pão, na alimentação dos animais domésticos e como ingrediente no fabrico de cerveja. O trigo é também plantado estritamente como forragem para animais domésticos, como o feno.");

                startActivity(Intent.createChooser(share, "Compartilhar"));
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
}
