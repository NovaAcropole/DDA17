package br.na.dda17.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import br.na.dda17.R;
import br.na.dda17.Utils;
import br.na.dda17.adapter.ContentAdapter;
import br.na.dda17.adapter.ProgramacaoAdapter;
import br.na.dda17.adapter.SobreAdapter;
import br.na.dda17.model.Content;
import br.na.dda17.model.Event;
import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerViewFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    static int type = 1;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    public static RecyclerViewFragment newInstance(int type) {
        RecyclerViewFragment.type = type;
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        //setup materialviewpager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

        if (type == Utils.VIEW_PROGRAMACAO)
            setProgramItems();
        else if (type == Utils.VIEW_EXPO)
            setExpoItems();
        else if (type == Utils.VIEW_CONCERTO)
            setText(R.string.concerto_titulo, R.string.concerto_descricao);
        else if (type == Utils.VIEW_AUDICAO)
            setText(R.string.concerto_titulo, R.string.concerto_descricao);
        else if (type == Utils.VIEW_PALESTRA)
            setText(R.string.palestra_titulo, R.string.palestra_descricao);
        else if (type == Utils.VIEW_SOBRE)
            mRecyclerView.setAdapter(new SobreAdapter(this.getContext()));


    }

    private void setExpoItems() {
    }

    private void setProgramItems() {

        List items = new ArrayList<>();
        items.add(new Event(this.getContext(), R.string.programacao_item1_hora,
                R.string.programacao_item1_titulo, R.string.programacao_item1_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item2_hora,
                R.string.programacao_item2_titulo, R.string.programacao_item2_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item3_hora,
                R.string.programacao_item3_titulo, R.string.programacao_item3_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item4_hora,
                R.string.programacao_item4_titulo, R.string.programacao_item4_descricao));

        //Use this now
        mRecyclerView.setAdapter(new ProgramacaoAdapter(this.getContext(), items));
    }

    private void setText(int titulo, int descricao) {

        List items = new ArrayList<>();
        items.add(new Content(this.getContext(), titulo, descricao));

        //Use this now
        mRecyclerView.setAdapter(new ContentAdapter(this.getContext(), items));
    }


}
