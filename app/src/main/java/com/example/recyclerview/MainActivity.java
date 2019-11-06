package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    public interface onImagenClickListener
    {
        void onImagenClick(Usuario usuario);
    }

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
        adaptador.ClickImagen(new Adaptador.onImagenClickListener() {
            @Override
            public void onImagenClick(Usuario usuario) {
                Intent intento = new Intent(Intent.ACTION_SEND);
                intento.setType("text/html");
                intento.setData(Uri.parse("mailto:"));
                intento.putExtra(Intent.EXTRA_EMAIL, usuario.getCorreo());
                startActivity(Intent.createChooser(intento,"Email "));
                Toast.makeText(MainActivity.this, "Enviando email a " + usuario.getCorreo(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adaptador);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));

    }
}
