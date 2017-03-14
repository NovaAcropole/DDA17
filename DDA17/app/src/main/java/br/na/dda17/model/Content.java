package br.na.dda17.model;

import android.content.Context;

/**
 * Created by Lana on 14/03/2017.
 */

public class Content {

    private final String titulo;
    private final String descricao;

    public Content(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Content(Context context, int titulo, int descricao) {
        this.titulo = context.getResources().getString(titulo);
        this.descricao = context.getResources().getString(descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
