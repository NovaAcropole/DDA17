package br.na.dda17.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.na.dda17.R;
import br.na.dda17.model.Content;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class SobreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public SobreAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_sobre, parent, false);
        return new SobreHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 1;
    }


}

class SobreHolder extends RecyclerView.ViewHolder {
    TextView hora, descricao, titulo;

    // intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    ImageButton faceBtn, instaBtn, youtubeBtn;
    ImageButton faceSulBtn, instaSulBtn;

    public SobreHolder(View view) {
        super(view);
        faceBtn = (ImageButton) view.findViewById(R.id.image_facebook);
        instaBtn = (ImageButton) view.findViewById(R.id.image_insta);
        youtubeBtn = (ImageButton) view.findViewById(R.id.image_youtube);

        faceSulBtn = (ImageButton) view.findViewById(R.id.image_facebook_sul);
        instaSulBtn = (ImageButton) view.findViewById(R.id.image_insta_sul);
        setButtons();
    }

    public void setButtons() {

        faceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_facebook)));
                v.getContext().startActivity(i);
            }
        });
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_instagram)));
                v.getContext().startActivity(i);
            }
        });

        faceSulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_facebook_sul)));
                v.getContext().startActivity(i);
            }
        });

        instaSulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_instagram_sul)));
                v.getContext().startActivity(i);
            }
        });
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_youtube)));
                v.getContext().startActivity(i);
            }
        });
    }


}

