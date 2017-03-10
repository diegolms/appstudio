package br.diego.cadeostudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import br.diego.cadeostudio.adapter.StudioAdapter;
import br.diego.cadeostudio.core.Controller;
import br.diego.cadeostudio.models.Studio;
import br.diego.cadeostudio.service.LocationService;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView studioListView;

    List<Studio> studios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        if(Controller.locationService == null){
            Controller.locationService = new LocationService(getApplicationContext());
        }


        populate();

        StudioAdapter adapter = new StudioAdapter(
                MainActivity.this, R.layout.item_view, studios);
        studioListView = (ListView) findViewById(R.id.studio_list_view);
        studioListView.setAdapter(adapter);
        studioListView.setOnItemClickListener(MainActivity.this);
    }

    private void populate() {
        int cont = 0;
        this.studios.add(new Studio("Studio " +cont++, "Responsavel "+cont++ , "android.resource://" + getPackageName() + "/" + R.drawable.animal1, -7.1688413,-34.8385449));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Controller.studio = (Studio) adapterView.getItemAtPosition(i);
        startActivity(new Intent(this, DetalheStudioActivity.class));
    }
}
