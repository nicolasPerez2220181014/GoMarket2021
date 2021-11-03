package com.example.gomarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gomarket.Estructural.Gestor;
import com.example.gomarket.Estructural.Usuario;
import com.example.gomarket.Logica.ServicioGestor;
import com.example.gomarket.Logica.ServicioUsuarios;
import com.example.gomarket.R;

public class GuiLogin extends AppCompatActivity {

    private TextView txtLeerUsuario;
    private TextView txtLeerClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logion);

        txtLeerUsuario = (TextView) findViewById(R.id.txtusuario);
        txtLeerClave = (TextView) findViewById(R.id.txtclave);

    }

    public void btnIngresar(View view) {
        String dato = "";
        Usuario use;
        dato = txtLeerUsuario.getText().toString().trim();
        use = ServicioUsuarios.leerPorNombre(dato);
        if(use != null){
            txtLeerUsuario.setText(use.getNombre());
            txtLeerClave.setText(use.getClave());
        }else{
            Toast.makeText(this, "No se encontró la película", Toast.LENGTH_LONG).show();
        }
    }
}