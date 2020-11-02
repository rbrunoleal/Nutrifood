package tk.divesdk.nutrifood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

public class tela_principal extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;



        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new tab_fragment()).commit();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.contato:
                        FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                        xfragmentTransaction.replace(R.id.containerView,new tab_fragment()).commit();
                        intent = new Intent(getBaseContext(), tela_contato.class);
                        startActivity(intent);
                        break;
                    case R.id.sobre:
                        intent = new Intent(getBaseContext(), tela_sobre.class);
                        startActivity(intent);
                        break;
                    case R.id.formulario:
                        Uri uri = Uri.parse("http://goo.gl/forms/QmLw25RDuQ");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case R.id.googleplay:
                        intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=tk.divesdk.nutrifood"));
                        startActivity(intent);
                        break;

                }

                /*if (menuItem.getItemId() == R.id.contato) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new tab_fragment()).commit();
                    intent = new Intent(getBaseContext(), tela_contato.class);
                    startActivity(intent);
                }*/

                return false;
            }

        });



        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }


}