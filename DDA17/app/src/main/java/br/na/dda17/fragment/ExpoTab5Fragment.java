package br.na.dda17.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import br.na.dda17.R;
import br.na.dda17.adapter.TabAdapter;
import br.na.dda17.model.Content;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ExpoTab5Fragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static ExpoTab5Fragment newInstance() {
        return new ExpoTab5Fragment();
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

        setContentExpo();
    }


    private void setContentExpo() {
        List items = new ArrayList<>();
        items.add(new Content(this.getContext(), R.string.exposicao_arte5_obra1, R.string.exposicao_arte5_obra1_texto, R.drawable.exposicao_arte5_obra1));
        items.add(new Content(this.getContext(), R.string.exposicao_arte5_obra2, R.string.exposicao_arte5_obra2_texto, R.drawable.exposicao_arte5_obra2));
        items.add(new Content(this.getContext(), R.string.exposicao_arte5_obra3, R.string.exposicao_arte5_obra3_texto, R.drawable.exposicao_arte5_obra3));
        mRecyclerView.setAdapter(new TabAdapter(this.getContext(), items));
    }

}
