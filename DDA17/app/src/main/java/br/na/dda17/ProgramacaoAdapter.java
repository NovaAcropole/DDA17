package br.na.dda17;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ProgramacaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Event> contents;
    private Context context;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public ProgramacaoAdapter(Context context, List<Event> contents) {
        this.contents = contents;
        this.context = context;
    }


/*    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }*/

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;


/*        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
        }*/
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_small, parent, false);

        ObjetoHolder ob = new ObjetoHolder(view);

        return ob;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }
}

class ObjetoHolder extends RecyclerView.ViewHolder {
    TextView hora;
    TextView descricao;
    TextView titulo;

    public ObjetoHolder(View view) {
        super(view);
        hora = (TextView) view.findViewById(R.id.programacao_hora);
        descricao = (TextView) view.findViewById(R.id.programacao_descricao);
        descricao.setTypeface(descricao.getTypeface(), Typeface.BOLD);
        titulo = (TextView) view.findViewById(R.id.programacao_titulo);
    }

    public void setTexts() {

    }


}