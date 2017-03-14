package br.na.dda17.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import br.na.dda17.R;
import br.na.dda17.Utils;
import br.na.dda17.fragment.RecyclerViewFragment;
import butterknife.ButterKnife;

public class SobreActivity extends AppCompatActivity {

    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        setTitle("");
        ButterKnife.bind(this);

        mViewPager = (MaterialViewPager) findViewById(R.id.SobreViewPager);


        Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return RecyclerViewFragment.newInstance(Utils.VIEW_SOBRE);
            }

            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {

                return HeaderDesign.fromColorAndDrawable(
                        ContextCompat.getColor(SobreActivity.this, R.color.colorPrimary),
                        ContextCompat.getDrawable(SobreActivity.this, R.drawable.na));
            }
        });

    }

}