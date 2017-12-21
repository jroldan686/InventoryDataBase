package jrl.deint.inventoryFragments.ui.section;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.adapter.SectionAdapter;
import jrl.deint.inventoryFragments.data.db.model.Section;

public class SectionActivity extends AppCompatActivity {

    private RecyclerView rcvSections;
    private SectionAdapter sectionAdapter;
    private SectionAdapter.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        rcvSections = (RecyclerView) findViewById(R.id.rcvSections);
        rcvSections.setHasFixedSize(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listener = new SectionAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Section section) {
                Toast.makeText(SectionActivity.this, "SectionItemClick: " + section.getName(), Toast.LENGTH_LONG).show();
            }
        };

        if(savedInstanceState != null)
            sectionAdapter = new SectionAdapter(savedInstanceState.<Section>getParcelableArrayList("section"), listener);
        else
            sectionAdapter = new SectionAdapter();

        // Indicamos el tipo de LayoutManager
        //rcvSections.setLayoutManager(new LinearLayoutManager(this));
        // Pone los elementos en dos columnas
        //rcvSections.setLayoutManager(new GridLayoutManager(this, sectionAdapter.getItemCount()));
        rcvSections.setLayoutManager(new LinearLayoutManager(this));
        rcvSections.setAdapter(sectionAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_section, menu);
        // Hay casos en los que devuelve true directamente porque es igual
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno las secciones que se han modificado en la vista y no han sido guardasdas
     * para visualizar el estado correcto en OnCreate()
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("section", sectionAdapter.getSectionsModified());
    }
}
