package br.na.dda17.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import br.na.dda17.Event;
import br.na.dda17.R;
import br.na.dda17.adapter.ProgramacaoAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends Fragment {

    private static final boolean GRID_LAYOUT = false;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
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

        final List<Event> items = new ArrayList<>();

        items.add(new Event(this.getContext(), R.string.programacao_item1_hora,
                R.string.programacao_item1_titulo, R.string.programacao_item1_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item2_hora,
                R.string.programacao_item2_titulo, R.string.programacao_item2_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item3_hora,
                R.string.programacao_item3_titulo, R.string.programacao_item3_descricao));
        items.add(new Event(this.getContext(), R.string.programacao_item4_hora,
                R.string.programacao_item4_titulo, R.string.programacao_item4_descricao));

        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new ProgramacaoAdapter(this.getContext(), items));
    }
}
