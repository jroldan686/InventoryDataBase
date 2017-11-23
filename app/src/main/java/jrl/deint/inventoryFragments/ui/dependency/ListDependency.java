package jrl.deint.inventoryFragments.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.adapter.DependencyAdapter;
import jrl.deint.inventoryFragments.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "listdependency";
    private ListDependencyListener callback;
    private ListDependencyContract.Presenter presenter;

    interface ListDependencyListener {
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must be implements ListDependencyListener");
        }
    }

    public static ListDependency newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null) {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_dependency, container, false);
        // Como se encuentra en el fragment, se usa rootView
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        // Si el floatingactionbutton se encontrara en el xml de la Activity
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewDependency();
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
