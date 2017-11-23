package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailPresenter implements DetailDependencyContract.Presenter {

    DetailDependencyContract.View view;

    public DetailPresenter(DetailDependencyContract.View view) {
        this.view = view;
    }
}
