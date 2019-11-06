package com.example.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView txtNombre, txtApellido;
    ImageButton botonImagen;
    View.OnClickListener listener;
    Context context;

    public Holder(View itemView, Context context)
    {
        super(itemView);
        this.context = context;
        txtNombre = (TextView)itemView.findViewById(R.id.textonombre);
        txtApellido = (TextView) itemView.findViewById(R.id.textApellido);
        botonImagen = (ImageButton) itemView.findViewById(R.id.imagenButton);
        botonImagen.setOnClickListener(this);

    }

    public void bind(Usuario usuario, int pos)
    {
        if (pos%2 == 0)
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPares));
        else
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorImpares));

        txtNombre.setText(usuario.getNombre());
        txtApellido.setText(usuario.getApellido());
    }

    public void ClickImagen(View.OnClickListener listener)
    {
        if(listener != null) this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onClick(view);
    }
}
