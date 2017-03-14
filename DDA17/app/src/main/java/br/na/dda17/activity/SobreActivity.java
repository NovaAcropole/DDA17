package br.na.dda17.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;

import br.na.dda17.R;

public class SobreActivity extends AppCompatActivity {

    ImageButton faceBtn;
    ImageButton instaBtn;
    ImageButton youtubeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        setTitle(R.string.sobre);

        faceBtn = (ImageButton) findViewById(R.id.image_facebook);
        instaBtn = (ImageButton) findViewById(R.id.image_insta);
        youtubeBtn = (ImageButton) findViewById(R.id.image_youtube);

        faceBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NA.Fortaleza"));
                startActivity(i);
            }
        });
        instaBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nafortaleza"));
                startActivity(i);
            }
        });
        youtubeBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/NovaAcropole"));
                startActivity(i);
            }
        });
    }
}
