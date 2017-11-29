package jrl.deint.inventoryFragments.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.base.BaseActivity;
import jrl.deint.inventoryFragments.ui.dependency.presenter.AddEditDependencyPresenter;
import jrl.deint.inventoryFragments.ui.dependency.presenter.ListDependencyPresenter;

public class DependenciesActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener {

    private ListDependencyFragment listDependency;
    private ListDependencyPresenter listPresenter;

    private AddEditDependencyFragment addEditDependency;
    private AddEditDependencyPresenter addEditPresenter;
    private Fragment detailDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependencies);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1. Se crea la vista
        listDependency = (ListDependencyFragment)fragmentManager.findFragmentByTag(ListDependencyFragment.TAG);
        if(listDependency == null) {
            listDependency = ListDependencyFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency);
            fragmentTransaction.commit();
        }
        // 2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        listPresenter = new ListDependencyPresenter(listDependency);

        // 3. Si fuera necesario, se asigna el presentador a su fragment
        listDependency.setPresenter(listPresenter);
    }

    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1. Se crea la vista
        addEditDependency = (AddEditDependencyFragment)fragmentManager.findFragmentByTag(AddEditDependencyFragment.TAG);
        if(addEditDependency == null) {
            listDependency = ListDependencyFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, addEditDependency);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        addEditPresenter = new AddEditDependencyPresenter(addEditDependency);

        // 3. Si fuera necesario, se asignan el presentador a su fragment
        addEditDependency.setPresenter(addEditPresenter);
    }
}
