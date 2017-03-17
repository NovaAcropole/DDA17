package br.na.dda17.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import br.na.dda17.R;

public class MainActivity extends AppCompatActivity {

    ImageView programacao, exposicao, concerto, plateia, palestra, sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        programacao = (ImageView) findViewById(R.id.icon_programa);
        exposicao = (ImageView) findViewById(R.id.icon_expo);
        concerto = (ImageView) findViewById(R.id.icon_concerto);
        plateia = (ImageView) findViewById(R.id.icon_plateia);
        palestra = (ImageView) findViewById(R.id.icon_palestra);
        sobre = (ImageView) findViewById(R.id.icon_sobre);

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
                Intent intent = new Intent(MainActivity.this, AudicaoActivity.class);
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
