package fr.slocum79.sloaliments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ProduitAjouterActivity extends Activity {

    /*** Construction de l'UI ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_ajouter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.produit_ajouter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_enregistrer:

                return ajouter();

            case R.id.action_annuler:

                return annuler();

            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /*** Implémentation ***/
    private boolean ajouter() {
        Toast.makeText(this, R.string.msgEnregistre, Toast.LENGTH_LONG).show();
        return true;
    }

    private boolean annuler() {
        Toast.makeText(this, R.string.msgAnnule, Toast.LENGTH_LONG).show();
        return true;
    }
}
