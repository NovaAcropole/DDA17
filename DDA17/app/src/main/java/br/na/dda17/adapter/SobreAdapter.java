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

    public SobreHolder(View view) {
        super(view);
        faceBtn = (ImageButton) view.findViewById(R.id.image_facebook);
        instaBtn = (ImageButton) view.findViewById(R.id.image_insta);
        youtubeBtn = (ImageButton) view.findViewById(R.id.image_youtube);
        setButtons();
    }

    public void setButtons() {

        faceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NA.Fortaleza"));
                v.getContext().startActivity(i);
            }
        });
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nafortaleza"));
                v.getContext().startActivity(i);
            }
        });
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/NovaAcropole"));
                v.getContext().startActivity(i);
            }
        });
    }


}

