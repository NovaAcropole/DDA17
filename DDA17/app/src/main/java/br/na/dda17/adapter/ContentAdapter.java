package br.na.dda17.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.na.dda17.R;
import br.na.dda17.Utils;
import br.na.dda17.model.Content;


public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Content> contents;
    private int type = 1;


    public ContentAdapter(List<Content> contents, int type) {
        this.contents = contents;
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (type == Utils.VIEW_EXPO) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card_imagem_texto, parent, false);
        } else
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card_texto_unico, parent, false);
        ContentObjetoHolder holder = new ContentObjetoHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewRolder, int position) {
        ContentObjetoHolder holder = (ContentObjetoHolder) viewRolder;
        holder.setTexts(contents.get(position).getTitulo(), contents.get(position).getDescricao());
    }
}

class ContentObjetoHolder extends RecyclerView.ViewHolder {
    TextView descricao, titulo;
    ImageView imagem;

    public ContentObjetoHolder(View view) {
        super(view);
        titulo = (TextView) view.findViewById(R.id.card_titulo);
        descricao = (TextView) view.findViewById(R.id.card_descricao);
        titulo.setTypeface(titulo.getTypeface(), Typeface.BOLD);
        descricao = (TextView) view.findViewById(R.id.card_descricao);
        imagem = (ImageView) view.findViewById(R.id.card_imagem);
    }

    public void setTexts(String titulo, String descricao) {
        this.descricao.setText(descricao);
        this.titulo.setText(titulo);
    }


}