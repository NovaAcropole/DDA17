package br.na.dda17.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.na.dda17.Event;
import br.na.dda17.R;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ProgramacaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Event> contents;
    private Context context;


    public ProgramacaoAdapter(Context context, List<Event> contents) {
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
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_programacao, parent, false);
        ObjetoHolder holder = new ObjetoHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewRolder, int position) {
        ObjetoHolder holder = (ObjetoHolder) viewRolder;
        holder.setTexts(contents.get(position).getHora(), contents.get(position).getTitulo(),
                contents.get(position).getDescricao());
    }
}

class ObjetoHolder extends RecyclerView.ViewHolder {
    TextView hora, descricao, titulo;



    public ObjetoHolder(View view) {
        super(view);
        hora = (TextView) view.findViewById(R.id.programacao_hora);
        descricao = (TextView) view.findViewById(R.id.programacao_descricao);
        titulo = (TextView) view.findViewById(R.id.programacao_titulo);
        titulo.setTypeface(titulo.getTypeface(), Typeface.BOLD);
    }

    public void setTexts(String hora, String titulo, String descricao) {
        this.hora.setText(hora);
        this.descricao.setText(descricao);
        this.titulo.setText(titulo);
    }


}