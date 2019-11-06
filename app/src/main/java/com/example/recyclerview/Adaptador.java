package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener
{
    Context context;
    Holder holder;
    View.OnClickListener listener, listenerImage;
    View.OnLongClickListener longListener;

    public Adaptador(Context  context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        holder = new Holder(view, context);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        holder.ClickImagen(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listenerImage != null) listenerImage.onClick(view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).bind(((MainActivity)context).datos[position], position);
    }

    @Override
    public int getItemCount()
    {
        return((MainActivity)context).datos.length;
    }

    public void setClickListener(View.OnClickListener listener)
    {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onClick(view);
    }

    public void setLongListener(View.OnLongClickListener longListener)
    {
        if (longListener != null)
            this.longListener = longListener;
    }

    @Override
    public boolean onLongClick(View view)
    {
        if (longListener != null)
            longListener.onLongClick(view);
        return true;
    }

    public void ClickImagen(View.OnClickListener listener)
    {
        if (listener != null) listenerImage = listener;
    }
}
