package jrl.deint.inventoryFragments.ui.dependency.interactor;

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

    void addDependency(String name, String sortname, String description);

}
