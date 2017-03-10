package br.na.dda17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PalestraActivity extends AppCompatActivity {

    Button btMais, btMenos;
    TextView textView;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palestra);

        textView = (TextView) findViewById(R.id.textosangue);
        btMais = (Button) findViewById(R.id.bt_frag_sangue_mais);
        btMenos = (Button) findViewById(R.id.bt_frag_sangue_menos);
        metrics = getApplicationContext().getResources().getDisplayMetrics();

        btMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mais();
            }
        });

        btMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menos();
            }
        });

    }

    public void mais() {
        float x = textView.getTextSize() / metrics.density;
        if (x < 40) {
            textView.setTextSize(x + 2);
        }
    }

    public void menos() {
        float x = textView.getTextSize() / metrics.density;
        if (x > 12)
            textView.setTextSize(x - 2);
    }

}

