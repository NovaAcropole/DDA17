package br.na.dda17.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.na.dda17.R;
import br.na.dda17.model.Content;


public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Content> contents;
    private Context context;


    public TabAdapter(Context context, List<Content> contents) {
        this.contents = contents;
        this.context = context;
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
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_imagem_texto, parent, false);
        TabObjetoHolder holder = new TabObjetoHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewRolder, int position) {
        TabObjetoHolder holder = (TabObjetoHolder) viewRolder;
        holder.setContent(contents.get(position).getTitulo(),
                contents.get(position).getDescricao(),
                contents.get(position).getImage());
    }
}

class TabObjetoHolder extends RecyclerView.ViewHolder {
    TextView descricao, titulo;
    ImageView imagem;

    public TabObjetoHolder(View view) {
        super(view);
        titulo = (TextView) view.findViewById(R.id.card_titulo);
        descricao = (TextView) view.findViewById(R.id.card_descricao);
        titulo.setTypeface(titulo.getTypeface(), Typeface.BOLD);
        descricao = (TextView) view.findViewById(R.id.card_descricao);
        imagem = (ImageView) view.findViewById(R.id.card_imagem);

    }

    void setContent(String titulo, String descricao, Drawable imagem) {
        this.titulo.setText(titulo);
        this.descricao.setText(descricao);
        this.imagem.setImageDrawable(imagem);
    }


}