package br.na.dda17.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by Lana on 14/03/2017.
 */

public class Content {

    private final String titulo;
    private final String descricao;
    private Drawable image = null;

    public Content(Context context, int titulo, int descricao) {
        this.titulo = context.getResources().getString(titulo);
        this.descricao = context.getResources().getString(descricao);
    }

    public Content(Context context, int titulo, int descricao, int image) {
        this.titulo = context.getResources().getString(titulo);
        this.descricao = context.getResources().getString(descricao);
        this.image = ContextCompat.getDrawable(context, image);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Drawable getImage() {
        return image;
    }
}
