package com.example.gomarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gomarket.Estructural.Gestor;
import com.example.gomarket.Logica.ServicioDBGestor;


public class activity_main_Agregar extends AppCompatActivity {

    private TextView txtDato;
    private TextView txtNombre;
    private TextView txtNit;
    private TextView txtUbicacion;
    private TextView txtDescripcion;
    private TextView txtUrlImagen;
    private TextView txtHorario;

    private ServicioDBGestor db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_agregar);
        txtDato = (TextView) findViewById(R.id.txtDatoActualizar);
        txtNombre = (TextView) findViewById(R.id.txtActualizarNombre);
        txtNit = (TextView) findViewById(R.id.txtActualizarNombre);
        txtUbicacion = (TextView) findViewById(R.id.txtActualizarUbicacion);
        txtDescripcion = (TextView) findViewById(R.id.txtActualizarDescripcion);
        txtUrlImagen = (TextView) findViewById(R.id.txtActualizarUrl);
        txtHorario = (TextView) findViewById(R.id.txtActualizarHorario);
        db = new ServicioDBGestor(this);

    }

    public void btnAgregarGestor_Click(View view) {

        String Nombre, Nit, Ubicacion, Descripcion, UrlImagen, Horario, strId;
        int id;
        Gestor nuevaGestor;

        boolean res=false;

        strId = txtDato.getText().toString();
        Nombre = txtNombre.getText().toString();
        Nit = txtNit.getText().toString();
        Ubicacion = txtUbicacion.getText().toString();
        Descripcion = txtDescripcion.getText().toString();
        UrlImagen = txtUrlImagen.getText().toString();
        Horario = txtHorario.getText().toString();

        id = Integer.parseInt(strId);

        nuevaGestor = new Gestor(id, Nombre, Nit, Ubicacion, Descripcion, UrlImagen, Horario);
        res = db.addPelicula(nuevaGestor);

        if(res){
            Toast.makeText(this, "La Tienda se ha adicionado!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Problemas al adicionar!", Toast.LENGTH_LONG).show();
        }

        txtDato.setText("");
        txtNombre.setText("");
        txtNit.setText("");
        txtUbicacion.setText("");
        txtDescripcion.setText("");
        txtUrlImagen.setText("");
        txtHorario.requestFocus();

    }
}