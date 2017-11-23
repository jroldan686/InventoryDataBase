package jrl.deint.inventoryFragments.ui.dependency;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditdependency";
    private AddEditDependencyContract.Presenter presenter;

    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        if(getArguments() != null) {        // Se trata de la opción editar

        }
        return rootView;
    }

    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
