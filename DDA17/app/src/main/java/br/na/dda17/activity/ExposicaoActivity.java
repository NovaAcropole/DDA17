package br.na.dda17.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import br.na.dda17.R;
import br.na.dda17.Utils;
import br.na.dda17.fragment.RecyclerViewFragment;
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
                return RecyclerViewFragment.newInstance(Utils.VIEW_EXPO, position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
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

                //execute others actions if needed (ex : modify your header logo)
                return null;
            }

        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        // EEGG
        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.eegg),
                            Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}
