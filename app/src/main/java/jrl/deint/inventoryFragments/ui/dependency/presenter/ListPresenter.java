package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter {

    ListDependencyContract.View view;

    public ListPresenter(ListDependencyContract.View view) {
        this.view = view;
    }
}
