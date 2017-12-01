package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependencyPresenter implements DetailDependencyContract.Presenter {

    DetailDependencyContract.View view;

    public DetailDependencyPresenter(DetailDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validatedependency() {

    }

    @Override
    public void onDestroy() {

    }
}
