package jrl.deint.inventoryFragments.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.base.BasePresenter;
import jrl.deint.inventoryFragments.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditdependency";
    private AddEditDependencyContract.Presenter presenter;
    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;

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
        tilName = (TextInputLayout) rootView.findViewById(R.id.tilName);
        tilShortName = (TextInputLayout) rootView.findViewById(R.id.tilShortName);
        tilDescription = (TextInputLayout) rootView.findViewById(R.id.tilDescription);
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validatedependency();
            }
        });
        if(getArguments() != null) {        // Se trata de la opción editar
            presenter.validatedependency(tilName.getEditText().toString(), tilShortName.getEditText().toString(), tilDescription.getEditText().toString());
        }
        Log.d(TAG, "AddEditDependency: onCreateView()");
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    // Si es correcto se muestra el listado con la dependencia que se ha añadido
    @Override
    public void showListDependency() {

    }

    @Override
    public void showDescriptionError() {
        tilDescription.setError(getResources().getString(R.string.errorDescriptionEmpty));
    }

    @Override
    public void showNameError() {
        tilName.setError(getResources().getString(R.string.errorShortname));
    }

    @Override
    public void showDependencyExistsError() {

    }

    @Override
    public void showDependencyDuplicate() {
        showMessage(getResources().getString(R.string.errorDependencyDuplicate));
    }
}
