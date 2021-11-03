package com.example.gomarket;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.gomarket.Logica.ServicioGestor;

import java.util.ArrayList;
public class activity_main_actualizar extends AppCompatActivity {

    private TextView txtDatoActualizar;
    private TextView txtActualizarNombre;
    private TextView txtActualizarNit;
    private TextView txtActualizarUbicacion;
    private TextView txtActualizarDescripcion;
    private TextView txtActualizarUrlImagen;
    private TextView txtActualizarHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);
        txtDatoActualizar = (TextView) findViewById(R.id.txtDatoActualizar);
        txtActualizarNombre = (TextView) findViewById(R.id.txtActualizarNombre);
        txtActualizarNit = (TextView) findViewById(R.id.txtActualizarNiT);
        txtActualizarUbicacion = (TextView) findViewById(R.id.txtActualizarUbicacion);
        txtActualizarDescripcion = (TextView) findViewById(R.id.txtActualizarDescripcion);
        txtActualizarUrlImagen = (TextView) findViewById(R.id.txtActualizarUrl);
        txtActualizarHorario = (TextView) findViewById(R.id.txtActualizarHorario);
    }

        public void btnBuscarGestor_Click (View view){
        String datoActualizar = "";
        Gestor ges;
        datoActualizar = txtDatoActualizar.getText().toString().trim();

        ges = ServicioGestor.leerPorNombre(datoActualizar);

        if(ges!=null){
            txtActualizarNombre.setText(ges.getNombre());
            txtActualizarNit.setText(ges.getNit());
            txtActualizarUbicacion.setText(ges.getUbicacion());
            txtActualizarDescripcion.setText(ges.getDescripcion());
            txtActualizarUrlImagen.setText(ges.getUrlImagen());
            txtActualizarHorario.setText(ges.getHorario());
        }
    }

    public void btnActualizarGestor_Click (View view){
        String Nombre = "";
        String Nit = "";
        String Ubicacion = "";
        String Descripcion = "";
        String UrlImagen = "";
        String Horario = "";
        String datoActualizar = "";
        datoActualizar = txtDatoActualizar.getText().toString().trim();

        Nombre = txtActualizarNombre.getText().toString().trim();
        Nit = txtActualizarNit.getText().toString().trim();
        Ubicacion = txtActualizarUbicacion.getText().toString().trim();
        Descripcion = txtActualizarDescripcion.getText().toString().trim();
        UrlImagen = txtActualizarUrlImagen.getText().toString().trim();
        Horario = txtActualizarHorario.getText().toString().trim();

        ServicioGestor.actualizarGestor(datoActualizar, Nombre, Nit, Ubicacion, Descripcion, UrlImagen, Horario);

        Toast.makeText(this, "La tienda se actualizo se ha actualizado", Toast.LENGTH_LONG).show();

    }

}