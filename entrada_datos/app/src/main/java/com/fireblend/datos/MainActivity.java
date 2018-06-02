package com.fireblend.datos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nombre)
    EditText nombre;
    @BindView(R.id.correo)
    EditText correo;
    @BindView(R.id.edad)
    SeekBar edad;
    @BindView(R.id.textoEdad)
    TextView textoEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setup();
    }

    private void setup(){
        edad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textoEdad.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


    @OnClick(R.id.botonMostrar)
    public void mostrar(){
        //Recuperar los valores de nombre, edad y correo

        //Crear un intent para abrir la pantalla de detalles

        //Agregarle al intent los valores recuperados

        //Llamar a startActivity() con ese intent
    }


}
