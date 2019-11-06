package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Usuario[] datos = new Usuario[]{new Usuario("Juan Pedro", "Gomez García", "juanpe@gmail.com"),
                                    new Usuario("Lola", "Perez Pardo", "lolitaperez@gmail.com"),
                                    new Usuario("Manuel", "Garcia Rodriguez", "manolito@gmail.com")};
    RecyclerView recycler;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView)findViewById(R.id.recycler);
        adaptador = new Adaptador(this);
        adaptador.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = recycler.getChildAdapterPosition(view);
                Toast.makeText(MainActivity.this, datos[pos].getCorreo(), Toast.LENGTH_SHORT).show();
            }
        });
        adaptador.setLongListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = recycler.getChildAdapterPosition(v);
                Toast.makeText(MainActivity.this, "Nombre " + datos[pos].getNombre() + " Apellido " + datos[pos].getApellido(),Toast.LENGTH_LONG).show();
                return true;
            }
        });
        adaptador.ClickImagen(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has pulsado la imagen", Toast.LENGTH_LONG).show();
            }
        });
        recycler.setAdapter(adaptador);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));

    }
}
