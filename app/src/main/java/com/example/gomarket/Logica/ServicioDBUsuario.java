package com.example.gomarket.Logica;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import com.example.gomarket.Estructural.Usuario;

import java.util.ArrayList;

public class ServicioDBUsuario extends SQLiteOpenHelper{

    public static final String NOMBRE_BASE_DE_DATOS = "Gomarket.db";
    public static final String NOMBRE_TABLA_USUARIO = "Usuario";
    public static final String NOMBRE_ATRIBUTO_ID = "id";
    public static final String NOMBRE_ATRIBUTO_USUARIO = "usuario";
    public static final String NOMBRE_ATRIBUTO_CLAVE = "clave";

    public ServicioDBUsuario(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cadSQL = "";
        cadSQL = "CREATE TABLE " + NOMBRE_TABLA_USUARIO + "(" + NOMBRE_ATRIBUTO_USUARIO + " INTEGER NOT NULL PRIMARY KEY, "
                + NOMBRE_ATRIBUTO_CLAVE + " TEXT" + ")";
        sqLiteDatabase.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String cadSQL = "";
        cadSQL = "DROP TABLE IF EXISTS " + NOMBRE_TABLA_USUARIO;
        sqLiteDatabase.execSQL(cadSQL);
    }

    public boolean addUsuario(Usuario user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues;
        long resultado;
        contentValues = new ContentValues();
        contentValues.put(NOMBRE_ATRIBUTO_ID, user.getId());
        contentValues.put(NOMBRE_ATRIBUTO_USUARIO, user.getNombre());
        contentValues.put(NOMBRE_ATRIBUTO_CLAVE, user.getClave());
        resultado = db.insert(NOMBRE_TABLA_USUARIO, null, contentValues);
        if(resultado == -1){
            return false;
        }
        return true;
    }

    public ArrayList llenarLv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM " + NOMBRE_TABLA_USUARIO;
        Cursor res = database.rawQuery(q, null);
        if(res.moveToFirst()){
            do{
                lista.add(res.getString(1));
            }while (res.moveToNext());
        }
        return lista;
    }

    public boolean deletePelicula(String nombre){
        SQLiteDatabase db = this.getWritableDatabase();
        long resultado = 0;

        String cadSQL = "";
        Cursor res = null;

        cadSQL = "DELETE FROM " + NOMBRE_TABLA_USUARIO + " WHERE " + NOMBRE_TABLA_USUARIO + " = "+ nombre;
        res = db.rawQuery(cadSQL, null);

        if(resultado == -1){
            return false;
        }
        return true;
    }

}
