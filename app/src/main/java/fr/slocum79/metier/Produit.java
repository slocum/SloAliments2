package fr.slocum79.metier;

import android.content.Context;

/**
 * Created by jfenond on 25/09/2014.
 */
public class Produit {

    /*** VARIABLES PRIVEES ***/
    int _id;
    String _Code;
    String _Libelle;
    int _StockMini;
    int _StockEnCours;

    /*** CONSTRUCTEURS ***/
    public Produit() {    }

    public Produit(int pId, String pCode, String pLibelle, int pStockMini, int pStockEnCours) {

        this._id = pId;
        this._Code = pCode;
        this._Libelle = pLibelle;
        this._StockMini = pStockMini;
        this._StockEnCours = pStockEnCours;
    }

    public Produit(String pCode, String pLibelle, int pStockMini, int pStockEnCours) {

        this._id = -1;
        this._Code = pCode;
        this._Libelle = pLibelle;
        this._StockMini = pStockMini;
        this._StockEnCours = pStockEnCours;
    }

    /*** ACCESSEURS ***/
    public  int getID() {
        return this._id;
    }

    public void setID(int pID) {
        this._id = pID;
    }

    public String getCode() {
        return  this._Code;
    }

    public void setCode(String pCode) {
        this._Code = pCode;
    }

    public String getLibelle() {
        return this._Libelle;
    }

    public void setLibelle(String pLibelle) {
        this._Libelle = pLibelle;
    }

    public int getStockMini() {
        return this._StockMini;
    }

    public void setStockMini(int pStockMini) {
        this._StockMini = pStockMini;
    }

    public int getStockEnCours() {
        return this._StockEnCours;
    }

    public void setStockEnCours(int pStockEnCours) {
        this._StockEnCours = pStockEnCours;
    }

    /*** INTERFACE ***/
    public String toString() {

        return "ID : " + _id + "\n CODE : " + _Code + "\n LIBELLE : " + _Libelle;

    }

/*
    public boolean ajouter(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.ajouterProduit(this);

        return true;
    }
*/

}
