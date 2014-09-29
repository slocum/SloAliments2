package fr.slocum79.metier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jfenond on 26/09/2014.
 */
public class ProduitBDD {


    private SQLiteDatabase _bdd;
    private DatabaseHandler _baseProduits;

    public ProduitBDD(Context context) {

        _baseProduits = new DatabaseHandler(context, DatabaseHandler.DATABASE_NAME, null, DatabaseHandler.DATABASE_VERSION);
    }

    // Ajouter un nouveau produit
    public long ajouter(Produit pProduit) {

        ContentValues values = new ContentValues();

        values.put(DatabaseHandler.PRODUIT_COLUMN_CODE, pProduit.getCode());
        values.put(DatabaseHandler.PRODUIT_COLUMN_LIBELLE, pProduit.getLibelle());
        values.put(DatabaseHandler.PRODUIT_COLUMN_STOCK_MINI, pProduit.getStockMini());
        values.put(DatabaseHandler.PRODUIT_COLUMN_STOCK_ENCOURS, pProduit.getStockEnCours());

        // Inserting Row
        _bdd = _baseProduits.getWritableDatabase();
        long id = _bdd.insert(DatabaseHandler.PRODUIT_TABLE, null, values);
        _bdd.close();

        return id;

    }

    // Liste tous les produits
    public List<Produit> lister(String pCode){

        List<Produit> lstProduits = new ArrayList<Produit>();

        String sql = "SELECT * " +
                     "FROM " + DatabaseHandler.PRODUIT_TABLE + " tblProduit " +
                     "WHERE tblProduit." + DatabaseHandler.PRODUIT_COLUMN_CODE + " >= '" + pCode + "'";

        _bdd = _baseProduits.getReadableDatabase();

        Cursor rec = _bdd.rawQuery(sql, null);

        if (rec.moveToFirst()) {

            do {

                Produit produit = new Produit(rec.getInt(rec.getColumnIndex(DatabaseHandler.PRODUIT_COLUMN_ID)),
                                              rec.getString(rec.getColumnIndex(DatabaseHandler.PRODUIT_COLUMN_CODE)),
                                              rec.getString(rec.getColumnIndex(DatabaseHandler.PRODUIT_COLUMN_LIBELLE)),
                                              rec.getInt(rec.getColumnIndex(DatabaseHandler.PRODUIT_COLUMN_STOCK_MINI)),
                                              rec.getInt(rec.getColumnIndex(DatabaseHandler.PRODUIT_COLUMN_STOCK_ENCOURS)));

                lstProduits.add(produit);


            } while (rec.moveToNext());
        }

        _bdd.close();

        return lstProduits;
    }
}
