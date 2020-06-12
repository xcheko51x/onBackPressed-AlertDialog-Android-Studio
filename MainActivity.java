package com.xcheko51x.onbackpressed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean cerrar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("SALIR");
        builder.setMessage("¿Estas seguro que desesa salir de la aplicación?");

        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrar = true;
                salirApp(cerrar);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrar = false;
                salirApp(cerrar);
            }
        });

        builder.create();
        builder.show();

    }

    public void salirApp(boolean cerrar) {
        if(cerrar == true) {
            Toast.makeText(this, "Vuelve pronto.", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Gracias por seguir aqui.", Toast.LENGTH_SHORT).show();
        }
    }
}
