package br.na.dda17.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.ArrayList;
import java.util.List;

import br.na.dda17.R;
import br.na.dda17.Utils;
import br.na.dda17.fragment.ExpoTab1Fragment;
import br.na.dda17.fragment.ExpoTab2Fragment;
import br.na.dda17.fragment.ExpoTab3Fragment;
import br.na.dda17.fragment.ExpoTab4Fragment;
import br.na.dda17.fragment.ExpoTab5Fragment;
import br.na.dda17.fragment.ExpoTab6Fragment;
import br.na.dda17.fragment.RecyclerViewFragment;
import br.na.dda17.model.Content;
import butterknife.ButterKnife;

public class ExposicaoActivity extends AppCompatActivity {

    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exposicao);

        setTitle("");
        ButterKnife.bind(this);

        mViewPager = (MaterialViewPager) findViewById(R.id.ExposicaoViewPager);

        Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return ExpoTab1Fragment.newInstance();
                    case 1:
                        return ExpoTab2Fragment.newInstance();
                    case 2:
                        return ExpoTab3Fragment.newInstance();
                    case 3:
                        return ExpoTab4Fragment.newInstance();
                    case 4:
                        return ExpoTab5Fragment.newInstance();
                }
                return ExpoTab6Fragment.newInstance();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getResources().getString(R.string.exposicao_arte1_nome);
                    case 1:
                        return getResources().getString(R.string.exposicao_arte2_nome);
                    case 2:
                        return getResources().getString(R.string.exposicao_arte3_nome);
                    case 3:
                        return getResources().getString(R.string.exposicao_arte4_nome);
                    case 4:
                        return getResources().getString(R.string.exposicao_arte5_nome);
                    case 5:
                        return getResources().getString(R.string.exposicao_arte6_nome);
                }
                return "";
            }

        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {

            @Override
            public HeaderDesign getHeaderDesign(int page) {

                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo));
                    case 1:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo2));
                    case 2:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo3));
                    case 3:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo4));
                    case 4:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo5));
                    case 5:
                        return HeaderDesign.fromColorAndDrawable(
                                ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                                ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo6));
                }

                return HeaderDesign.fromColorAndDrawable(
                        ContextCompat.getColor(ExposicaoActivity.this, R.color.colorPrimary),
                        ContextCompat.getDrawable(ExposicaoActivity.this, R.drawable.expo3));
            }

        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getPagerTitleStrip().setTextColorResource(R.color.white);

    }
}
