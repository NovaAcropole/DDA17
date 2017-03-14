package br.na.dda17.model;

import android.content.Context;

/**
 * Created by Lana on 13/03/2017.
 */

public class Event {

    private final String hora;
    private final String titulo;
    private final String descricao;

    public Event(String hora, String titulo, String descricao) {
        this.hora = hora;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Event(Context context, int hora, int titulo, int descricao) {
        this.hora = context.getResources().getString(hora);
        this.titulo = context.getResources().getString(titulo);
        this.descricao = context.getResources().getString(descricao);
    }

    public String getHora() {
        return hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}
