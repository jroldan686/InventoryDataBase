package jrl.deint.inventoryFragments.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.base.BasePresenter;
import jrl.deint.inventoryFragments.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependencyFragment extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detaildependency";
    private DetailDependencyContract.Presenter presenter;

    public static DetailDependencyFragment newInstance(Bundle arguments) {
        DetailDependencyFragment detailDependency = new DetailDependencyFragment();
        if(arguments != null) {
            detailDependency.setArguments(arguments);
        }
        return detailDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_dependency, container, false);
        if(getArguments() != null) {

        }
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (DetailDependencyContract.Presenter)presenter;
    }
}
