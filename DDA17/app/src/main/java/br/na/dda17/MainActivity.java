package br.na.dda17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout programacao, exposicao, concerto, plateia, palestra, sobre;

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

    }


}
