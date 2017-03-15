package br.na.dda17.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;

import br.na.dda17.R;
import butterknife.ButterKnife;

public class AudicaoActivity extends AppCompatActivity {

    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audicao);

        setTitle("");
        ButterKnife.bind(this);

        mViewPager = (MaterialViewPager) findViewById(R.id.AudicaoViewPager);

        Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
