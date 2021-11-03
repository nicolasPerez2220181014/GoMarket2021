package com.example.gomarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gomarket.Estructural.Gestor;
import com.example.gomarket.Logica.ServicioGestor;

public class activity_main_buscar extends AppCompatActivity {

    private TextView txtDato;
    private TextView txtNombre;
    private TextView txtNit;
    private TextView txtUbicacion;
    private TextView txtDescripcion;
    private TextView txtUrlImagen;
    private TextView txtHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_borrar);
        txtDato = (TextView) findViewById(R.id.txtDatoActualizar);
        txtNombre = (TextView) findViewById(R.id.txtActualizarNombre);
        txtNit = (TextView) findViewById(R.id.txtActualizarNombre);
        txtUbicacion = (TextView) findViewById(R.id.txtActualizarUbicacion);
        txtDescripcion = (TextView) findViewById(R.id.txtActualizarDescripcion);
        txtUrlImagen = (TextView) findViewById(R.id.txtActualizarUrl);
        txtHorario = (TextView) findViewById(R.id.txtActualizarHorario);
    }
    public void btnBuscarGestor_Click(View view){
        String dato = "";
        Gestor ges;
        dato = txtNombre.getText().toString().trim();

        ges = ServicioGestor.leerPorNombre(dato);

        if(ges != null){
            txtNombre.setText(ges.getNombre());
            txtNit.setText(ges.getNit());
            txtUbicacion.setText(ges.getUbicacion());
            txtDescripcion.setText(ges.getDescripcion());
            txtUrlImagen.setText(ges.getUrlImagen());
            txtHorario.setText(ges.getHorario());

        }else{
            Toast.makeText(this, "No se encontró la tienda", Toast.LENGTH_LONG).show();
        }
    }
}