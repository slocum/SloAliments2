package fr.slocum79.sloaliments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.slocum79.boiteoutils.Outil;
//import fr.slocum79.metier.DatabaseHandler;
import fr.slocum79.metier.Produit;
import fr.slocum79.metier.ProduitBDD;


public class ProduitAjouterActivity extends Activity {

    /*** VARIABLES ***/
    private String _KeyTypeAction;

    /*** ACCESSEURS ***/

    private String getCode() {

        return this.fieldToString(R.id.txtProduitCode);
    }

    private String getLibelle() {

        return this.fieldToString(R.id.txtProduitLibelle);
    }

    private int getStockMini() {

        return this.fieldToInteger(R.id.txtProduitStockMini);
    }

    private int getStockEnCours() {

        return this.fieldToInteger(R.id.txtProduitStockEnCours);
    }

    /*** Construction de l'UI ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_ajouter);

        _KeyTypeAction = getIntent().getStringExtra(Outil.KEY_TYPE_ACTION);

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

                if(_KeyTypeAction == Outil.eKeyTypeAction.Ajouter.toString()) {
                    return ajouter();     
                }


            case R.id.action_annuler:

                return annuler();

            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /*** IMPLEMENTATION ***/
    private boolean ajouter() {

        ProduitBDD  oProduitBDD = new ProduitBDD(this);

        Produit oProduit = new Produit(this.getCode(),
                                       this.getLibelle(),
                                       this.getStockMini(),
                                       this.getStockEnCours());

        long id = oProduitBDD.ajouter(oProduit);

        Toast.makeText(this, R.string.msgEnregistre, Toast.LENGTH_LONG).show();

        return true;
    }

    private boolean annuler() {
        Toast.makeText(this, R.string.msgAnnule, Toast.LENGTH_LONG).show();
        return true;
    }

    private String fieldToString(int pId){
        EditText editText = (EditText) findViewById(pId);
        return editText.getText().toString();
    }

    private int fieldToInteger(int pId){
        EditText editText = (EditText) findViewById(pId);
        return Integer.parseInt(editText.getText().toString());
    }
}
