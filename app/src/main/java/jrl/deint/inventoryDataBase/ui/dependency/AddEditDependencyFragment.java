package jrl.deint.inventoryDataBase.ui.dependency;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.ui.base.BasePresenter;
import jrl.deint.inventoryDataBase.ui.dependency.contract.AddEditDependencyContract;
import jrl.deint.inventoryDataBase.ui.dependency.presenter.AddEditDependencyPresenter;
import jrl.deint.inventoryDataBase.utils.AddEdit;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyFragment extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditdependencyfragment";
    private AddEditDependencyContract.Presenter presenter;
    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;
    private EditText edtName;
    private EditText edtShortName;
    private EditText edtDescription;
    private FloatingActionButton fab;
    private AddEditDependencyListener mCallback;
    private AddEdit addEditMode;

    public interface AddEditDependencyListener {
        void listDependency();
    }

    public static AddEditDependencyFragment newInstance(Bundle arguments) {
        AddEditDependencyFragment addEditDependency = new AddEditDependencyFragment();
        if(arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (AddEditDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }
    }

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        tilName = (TextInputLayout) rootView.findViewById(R.id.tilName);
        tilShortName = (TextInputLayout) rootView.findViewById(R.id.tilShortName);
        tilDescription = (TextInputLayout) rootView.findViewById(R.id.tilDescription);
        fab = (FloatingActionButton)rootView.findViewById(R.id.fab);

        edtName = (EditText)rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtShortName = (EditText)rootView.findViewById(R.id.tietShortName);
        edtShortName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilShortName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtDescription = (EditText)rootView.findViewById(R.id.edtDescription);
        edtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Por defecto está en ADD_MODE
        addEditMode = new AddEdit();
        if(getArguments() != null) {
            addEditMode.setMode(AddEdit.EDIT_MODE);
            Dependency dependency = getArguments().getParcelable(Dependency.TAG);
            tilName.getEditText().setText(dependency.getName());
            tilShortName.getEditText().setText(dependency.getShortname());
            tilDescription.getEditText().setText(dependency.getDescription());
            tilName.setEnabled(false);
            tilShortName.setEnabled(false);
        }

        Log.d(TAG, "onCreateView");
        return rootView;

        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validatedependency();
            }
        });
        if(getArguments() != null) {        // Se trata de la opción editar
            presenter.validatedependency(tilName.getEditText().toString(), tilShortName.getEditText().toString(), tilDescription.getEditText().toString());
        }
        Log.d(TAG, "AddEditDependencyFragment: onCreateView()");
        return rootView;
        */
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addEditMode.getMode() == AddEdit.ADD_MODE) {
                    presenter.saveDependency(
                            tilName.getEditText().getText().toString(),
                            tilShortName.getEditText().getText().toString(),
                            tilDescription.getEditText().getText().toString());
                }
                if(addEditMode.getMode() == AddEdit.EDIT_MODE) {
                    Dependency dependency = getArguments().getParcelable(Dependency.TAG);
                    presenter.editDependency(dependency, tilDescription.getEditText().getText().toString());
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(AddEditDependencyPresenter.TAG, presenter);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        this.presenter = (AddEditDependencyContract.Presenter) savedInstanceState.get(AddEditDependencyPresenter.TAG);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter)presenter;
    }

    @Override
    public void showMessage(String message) {

    }

    // Si es correcto se muestra el listado con la dependencia que se ha añadido
    @Override
    public void showListDependency() {
        mCallback.listDependency();
    }

    @Override
    public void showDescriptionEmptyError() {
        tilDescription.setError(getResources().getString(R.string.errorDescriptionEmpty));
    }

    @Override
    public void showNameEmptyError() {
        tilName.setError(getResources().getString(R.string.errorName));
    }

    @Override
    public void showShortNameEmptyError() {
        tilShortName.setError(getResources().getString(R.string.errorShortname));
    }

    @Override
    public void showShortNameLengthError() {
        tilShortName.setError(getResources().getString(R.string.errorShortnameLength));
    }

    @Override
    public void showDependencyDuplicate() {
        //showMessage(getResources().getString(R.string.errorDependencyDuplicate));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
