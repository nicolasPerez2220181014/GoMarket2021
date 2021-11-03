package com.example.gomarket.Logica;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import com.example.gomarket.Estructural.Gestor;

import java.util.ArrayList;

public class ServicioDBGestor extends SQLiteOpenHelper{

    public static final String NOMBRE_BASE_DE_DATOS = "Gomarket.db";
    public static final String NOMBRE_TABLA_GESTOR = "GESTOR";
    public static final String NOMBRE_ATRIBUTO_GESTOR_ID = "id";
    public static final String NOMBRE_ATRIBUTO_GESTOR_NOMBRE = "Nombre";
    public static final String NOMBRE_ATRIBUTO_GESTOR_NIT = "Nit";
    public static final String NOMBRE_ATRIBUTO_GESTOR_UBICACION = "Ubicacion";
    public static final String NOMBRE_ATRIBUTO_GESTOR_DESCRIPCION = "Descripcion";
    public static final String NOMBRE_ATRIBUTO_GESTOR_URL_IMAGEN = "UrlImagen";
    public static final String NOMBRE_ATRIBUTO_GESTOR_HORARIO = "Horario";

    public ServicioDBGestor(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cadSQL = "";
        cadSQL = "CREATE TABLE " + NOMBRE_TABLA_GESTOR + "(" + NOMBRE_ATRIBUTO_GESTOR_ID + " INTEGER NOT NULL PRIMARY KEY, "
                + NOMBRE_ATRIBUTO_GESTOR_NOMBRE + " TEXT, " + NOMBRE_ATRIBUTO_GESTOR_NIT + " TEXT, "
                + NOMBRE_ATRIBUTO_GESTOR_UBICACION + " TEXT, " + NOMBRE_ATRIBUTO_GESTOR_DESCRIPCION + " TEXT, "
                + NOMBRE_ATRIBUTO_GESTOR_URL_IMAGEN + "TEXT," + NOMBRE_ATRIBUTO_GESTOR_HORARIO + " TEXT" + ")";
        sqLiteDatabase.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String cadSQL = "";
        cadSQL = "DROP TABLE IF EXISTS " + NOMBRE_TABLA_GESTOR;
        sqLiteDatabase.execSQL(cadSQL);
    }

    public boolean addPelicula(Gestor gest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues;
        long resultado;
        contentValues = new ContentValues();
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_ID, gest.getId());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_NOMBRE, gest.getNombre());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_NIT, gest.getNit());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_UBICACION, gest.getUbicacion());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_DESCRIPCION, gest.getDescripcion());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_URL_IMAGEN, gest.getUrlImagen());
        contentValues.put(NOMBRE_ATRIBUTO_GESTOR_HORARIO, gest.getHorario());
        resultado = db.insert(NOMBRE_TABLA_GESTOR, null, contentValues);
        if(resultado == -1){
            return false;
        }
        return true;
    }

    public ArrayList llenarLv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM " + NOMBRE_TABLA_GESTOR;
        Cursor res = database.rawQuery(q, null);
        if(res.moveToFirst()){
            do{
                lista.add(res.getString(1));
            }while (res.moveToNext());
        }
        return lista;
    }

    public boolean deletePelicula(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        long resultado = 0;

        String cadSQL = "";
        Cursor res = null;

        cadSQL = "DELETE FROM " + NOMBRE_TABLA_GESTOR + " WHERE " + NOMBRE_ATRIBUTO_GESTOR_ID + " = "+ id;
        res = db.rawQuery(cadSQL, null);

        if(resultado == -1){
            return false;
        }
        return true;
    }

}
