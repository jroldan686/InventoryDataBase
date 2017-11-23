package jrl.deint.inventoryFragments.ui.dependency;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.data.db.model.Dependency;
import jrl.deint.inventoryFragments.repository.DependencyRepository;

public class AddDependencyActivity extends AppCompatActivity {

    TextInputEditText tietName;
    TextInputEditText tietShortName;
    TextInputEditText tietDescription;
    FloatingActionButton fab;
    DependencyRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_edit_dependency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tietName = (TextInputEditText)findViewById(R.id.tietName);
        tietShortName = (TextInputEditText)findViewById(R.id.tietShortName);
        tietDescription = (TextInputEditText)findViewById(R.id.tietDescription);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VALIDA LOS DATOS
                String name = tietName.getText().toString();
                String shortname = tietShortName.getText().toString();
                String description = tietDescription.getText().toString();

                if(!(name.isEmpty() || shortname.isEmpty() || description.isEmpty()))
                    // AGREGA A REPOSITORY
                    repository.addDependency(new Dependency(3, name, shortname, description));
                else
                    Toast.makeText(AddDependencyActivity.this, "Los campos no pueden estar vacíos. Por favor, revíselos.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
