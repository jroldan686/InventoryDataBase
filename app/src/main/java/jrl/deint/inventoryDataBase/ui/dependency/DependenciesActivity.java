package jrl.deint.inventoryDataBase.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.ui.base.BaseActivity;
import jrl.deint.inventoryDataBase.ui.dependency.presenter.AddEditDependencyPresenter;
import jrl.deint.inventoryDataBase.ui.dependency.presenter.ListDependencyPresenter;

public class DependenciesActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener,
        AddEditDependencyFragment.AddEditDependencyListener {

    private ListDependencyFragment listDependency;
    private ListDependencyPresenter listPresenter;

    private AddEditDependencyFragment addEditDependency;
    private AddEditDependencyPresenter addEditPresenter;
    private Fragment detailDependency;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependencies);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1. Se crea la vista
        listDependency = (ListDependencyFragment)fragmentManager.findFragmentByTag(ListDependencyFragment.TAG);
        if(listDependency == null) {
            listDependency = ListDependencyFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependencyFragment.TAG);
            fragmentTransaction.commit();
        }
        // 2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        listPresenter = new ListDependencyPresenter(listDependency);

        // 3. Si fuera necesario, se asigna el presentador a su fragment
        listDependency.setPresenter(listPresenter);
    }

    @Override
    public void addNewDependency(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1. Se crea la vista
        addEditDependency = (AddEditDependencyFragment)fragmentManager.findFragmentByTag(AddEditDependencyFragment.TAG);
        if(addEditDependency == null) {
            if(bundle != null)
                addEditDependency = AddEditDependencyFragment.newInstance(bundle);
            else
                addEditDependency = AddEditDependencyFragment.newInstance(null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(android.R.id.content, addEditDependency, AddEditDependencyFragment.TAG).commit();
        }
        // 2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        addEditPresenter = new AddEditDependencyPresenter(addEditDependency);

        // 3. Si fuera necesario, se asignan el presentador a su fragment
        addEditDependency.setPresenter(addEditPresenter);
    }

    @Override
    public void listDependency() {
        getSupportFragmentManager().popBackStack();
    }
}
