package jrl.deint.inventoryFragments.ui.dependency.presenter;

import jrl.deint.inventoryFragments.ui.dependency.AddEditDependency;
import jrl.deint.inventoryFragments.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenterImpl {

    AddEditDependencyContract.View view;

    public AddEditPresenterImpl(AddEditDependencyContract.View view) {
        this.view = view;
    }
}
