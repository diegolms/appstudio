package br.diego.cadeostudio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ftinc.kit.widget.AspectRatioImageView;
import com.squareup.picasso.Picasso;

import br.diego.cadeostudio.core.Controller;

/**
 * Created by diego on 08/03/17.
 */
public class DetalheStudioActivity extends AppCompatActivity {

    AspectRatioImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studio_detalhe_view);

        image = (AspectRatioImageView) findViewById(R.id.cover);
        Picasso.with(getApplicationContext())
                .load(Controller.studio.getImageUrl())
                .into(image);
    }
}
