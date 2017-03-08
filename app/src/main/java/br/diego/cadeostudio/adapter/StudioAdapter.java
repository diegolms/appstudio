package br.diego.cadeostudio.adapter;

/**
 * Created by diego on 08/03/17.
 */
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import br.diego.cadeostudio.R;
import br.diego.cadeostudio.core.Controller;
import br.diego.cadeostudio.models.Studio;
import co.dift.ui.SwipeToAction;


public class StudioAdapter extends ArrayAdapter<Studio> {

    private ArrayList<Studio> items;

    public StudioAdapter(Context context, int textViewResourceId, List<Studio> items) {
        super(context, textViewResourceId, items);
        this.items = (ArrayList<Studio>) items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FrameLayout v = (FrameLayout) convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (FrameLayout) vi.inflate(R.layout.item_view, null);
        }

        Studio studio = items.get(position);
        if (studio != null) {

            TextView nome = (TextView) v.findViewById(R.id.nome);
            if (nome != null) {
                nome.setText(studio.getNome());
            }

            TextView responsavel = (TextView) v.findViewById(R.id.responsavel);
            if (responsavel != null) {
                responsavel.setText(studio.getDono());
            }
        }
        return v;
    }
}
