package br.na.dda17.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.na.dda17.R;
import br.na.dda17.model.Content;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static br.na.dda17.R.string.sobre_na_localizacao_endereco;


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

    ImageButton faceBtn, instaBtn, youtubeBtn;
    ImageButton faceSulBtn, instaSulBtn;
    ImageButton mapBtn, mapNaBtn, mapNaSBtn;
    TextView siteNa, siteNaSul;
    TextView emailNa, emailNaSul;

    public SobreHolder(View view) {
        super(view);
        faceBtn = (ImageButton) view.findViewById(R.id.image_facebook);
        instaBtn = (ImageButton) view.findViewById(R.id.image_insta);
        youtubeBtn = (ImageButton) view.findViewById(R.id.image_youtube);

        faceSulBtn = (ImageButton) view.findViewById(R.id.image_facebook_sul);
        instaSulBtn = (ImageButton) view.findViewById(R.id.image_insta_sul);

        mapBtn = (ImageButton) view.findViewById(R.id.image_maps);
        mapNaBtn = (ImageButton) view.findViewById(R.id.image_maps_na);
        mapNaSBtn = (ImageButton) view.findViewById(R.id.image_maps_na_sul);

        siteNa = (TextView) view.findViewById(R.id.sitena);
        siteNaSul = (TextView) view.findViewById(R.id.sitenasul);
        emailNa = (TextView) view.findViewById(R.id.emailna);
        emailNaSul = (TextView) view.findViewById(R.id.emailnasul);
        setButtons();
    }

    public void setButtons() {

        siteNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(siteNa.getText().toString()));
                v.getContext().startActivity(i);
            }
        });
        siteNaSul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(siteNaSul.getText().toString()));
                v.getContext().startActivity(i);
            }
        });

        faceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FACEBOOK_URL = "https://www.facebook.com/NA.Fortaleza";
                String FACEBOOK_PAGE_ID = "NA.Fortaleza";

                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                PackageManager packageManager = v.getContext().getPackageManager();
                String facebookUrl = "";

                try {
                    int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) { //newer versions of fb app
                        facebookUrl = "fb://facewebmodal/f?href=" + FACEBOOK_URL;
                    } else { //older versions of fb app
                        facebookUrl = "fb://page/" + FACEBOOK_PAGE_ID;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    facebookUrl = FACEBOOK_URL; //normal web url
                }

                facebookIntent.setData(Uri.parse(facebookUrl));
                v.getContext().startActivity(facebookIntent);

            }
        });
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_instagram));
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");

                try {
                    v.getContext().startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }


            }
        });

        faceSulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FACEBOOK_URL = "https://www.facebook.com/NA.FortalezaSul";
                String FACEBOOK_PAGE_ID = "NA.FortalezaSul";

                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                PackageManager packageManager = v.getContext().getPackageManager();
                String facebookUrl = "";

                try {
                    int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) { //newer versions of fb app
                        facebookUrl = "fb://facewebmodal/f?href=" + FACEBOOK_URL;
                    } else { //older versions of fb app
                        facebookUrl = "fb://page/" + FACEBOOK_PAGE_ID;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    facebookUrl = FACEBOOK_URL; //normal web url
                }

                facebookIntent.setData(Uri.parse(facebookUrl));
                v.getContext().startActivity(facebookIntent);

            }
        });

        instaSulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(v.getContext().getResources().getString(R.string.sobre_na_instagram_sul));
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");

                try {
                    v.getContext().startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
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

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(" Cineteatro São Luiz"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                view.getContext().startActivity(mapIntent);

            }
        });

        mapNaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(
                        view.getContext().getResources().getString(R.string.sobre_na_localizacao_endereco)));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                view.getContext().startActivity(mapIntent);

            }
        });


        mapNaSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(
                        view.getContext().getResources().getString(R.string.sobre_na_localizacao_endereco_sul)));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                view.getContext().startActivity(mapIntent);

            }
        });
    }


}

