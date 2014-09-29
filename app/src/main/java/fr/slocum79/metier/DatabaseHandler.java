package fr.slocum79.metier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by jfenond on 25/09/2014.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    /**** CONSTANTES ***/

    public static final String DATABASE_NAME = "stock_aliments.db";
    public static final int DATABASE_VERSION = 1;

    public static final String PRODUIT_TABLE = "produits";
    public static final String PRODUIT_COLUMN_ID = "_id";
    public static final String PRODUIT_COLUMN_CODE = "code";
    public static final String PRODUIT_COLUMN_LIBELLE = "libelle";
    public static final String PRODUIT_COLUMN_STOCK_MINI = "stock_mini";
    public static final String PRODUIT_COLUMN_STOCK_ENCOURS = "stock_encours";

    public static final String PRODUIT_TABLE_CREATE = "CREATE TABLE " + PRODUIT_TABLE + "(" +
                                                         PRODUIT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                         PRODUIT_COLUMN_CODE + " TEXT NOT NULL, " +
                                                         PRODUIT_COLUMN_LIBELLE + " TEXT NOT NULL, " +
                                                         PRODUIT_COLUMN_STOCK_MINI + " INTEGER DEFAULT 0, " +
                                                         PRODUIT_COLUMN_STOCK_ENCOURS + " INTEGER DEFAULT 0);" ;
    public static final String PRODUIT_TABLE_DELETE = "DROP TABLE IF EXISTS " + PRODUIT_TABLE + ";";

    /*** CONSTRUCTEUR ***/
    public DatabaseHandler(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*** INTERFACE ***/

    // Création des tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PRODUIT_TABLE_CREATE);

    }

    // Modification de la Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Efface la table et la recrée
        db.execSQL(PRODUIT_TABLE_DELETE);
        onCreate(db);
    }

    /*** INTERFACE ***/

}
