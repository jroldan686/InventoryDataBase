package jrl.deint.inventoryFragments.ui.dependency.interactor;

import jrl.deint.inventoryFragments.data.db.model.Dependency;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractor {

    interface OnAddEditFinishedListener {
        void onNameEmptyError();
        void onShortNameEmptyError();
        void onShortNameLengthError();
        void onDescriptionEmptyError();
        void onSuccess(String name, String shortname, String description);
    }

    void validateDependency(String name, String shortname, String description, OnAddEditFinishedListener listener);

    void addDependency(String name, String shortname, String description);

    void editDependency(Dependency dependency, String description, OnAddEditFinishedListener listener);
}
