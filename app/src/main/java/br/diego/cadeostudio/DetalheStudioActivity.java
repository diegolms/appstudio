package br.diego.cadeostudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ftinc.kit.widget.AspectRatioImageView;
import com.squareup.picasso.Picasso;

import br.diego.cadeostudio.Utils.Constants;
import br.diego.cadeostudio.core.Controller;

/**
 * Created by diego on 08/03/17.
 */
public class DetalheStudioActivity extends AppCompatActivity implements View.OnClickListener {

    AspectRatioImageView image;
    View mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studio_detalhe_view);

        image = (AspectRatioImageView) findViewById(R.id.cover);
        Picasso.with(getApplicationContext())
                .load(Controller.studio.getImageUrl())
                .into(image);

        mapa = (View) findViewById(R.id.mapa);
        mapa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.mapa:
                startActivity(new Intent(DetalheStudioActivity.this, MapsActivity.class));
                break;
        }
    }
}
