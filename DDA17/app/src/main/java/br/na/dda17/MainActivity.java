package br.na.dda17;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout programacao, exposicao, concerto, plateia, palestra, sobre;
    TextView tvProgramacao, tvExposicao, tvConcerto, tvPlateia, tvPalestra, tvSobre;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        programacao = (LinearLayout) findViewById(R.id.btProgramacao);
        exposicao = (LinearLayout) findViewById(R.id.btExposicao);
        concerto = (LinearLayout) findViewById(R.id.btConcerto);
        plateia = (LinearLayout) findViewById(R.id.btPlateia);
        palestra = (LinearLayout) findViewById(R.id.btPalestra);
        sobre = (LinearLayout) findViewById(R.id.btSobre);

        programacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProgramacaoActivity.class);
                startActivity(intent);
            }
        });
        exposicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExposicaoActivity.class);
                startActivity(intent);
            }
        });

        concerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConcertoActivity.class);
                startActivity(intent);
            }
        });
        plateia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlateiaActivity.class);
                startActivity(intent);
            }
        });
        palestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PalestraActivity.class);
                startActivity(intent);
            }
        });
        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(intent);
            }
        });

        setAllFonts();


    }

    private void setAllFonts() {

        tvConcerto = (TextView) findViewById(R.id.tv_concerto);
        tvExposicao = (TextView) findViewById(R.id.tv_exposicao);
        tvPalestra = (TextView) findViewById(R.id.tv_palestra);
        tvPlateia = (TextView) findViewById(R.id.tv_plateia);
        tvProgramacao = (TextView) findViewById(R.id.tv_programacao);
        tvSobre = (TextView) findViewById(R.id.tv_sobre);

        typeface = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), "fonts/KeplerStd-Medium.otf");

        tvConcerto.setTypeface(typeface);
        tvExposicao.setTypeface(typeface);
        tvPalestra.setTypeface(typeface);
        tvPlateia.setTypeface(typeface);
        tvProgramacao.setTypeface(typeface);
        tvSobre.setTypeface(typeface);


    }


}
