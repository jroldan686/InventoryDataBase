package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenterImpl implements ListDependencyContract.Presenter {
    ListDependencyContract.View view;

    public ListPresenterImpl(ListDependencyContract.View view) {
        this.view = view;
    }
}
