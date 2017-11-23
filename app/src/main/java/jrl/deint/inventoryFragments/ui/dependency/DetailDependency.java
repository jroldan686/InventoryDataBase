package jrl.deint.inventoryFragments.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependency extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detaildependency";
    private DetailDependencyContract.Presenter presenter;

    public static DetailDependency newInstance(Bundle arguments) {
        DetailDependency detailDependency = new DetailDependency();
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
    public void setPresenter(DetailDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
