package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter {

    AddEditDependencyContract.View view;

    public AddEditPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }
}
