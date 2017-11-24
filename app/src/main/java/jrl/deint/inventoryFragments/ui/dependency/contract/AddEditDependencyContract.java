package jrl.deint.inventoryFragments.ui.dependency.contract;

import jrl.deint.inventoryFragments.ui.base.BasePresenter;
import jrl.deint.inventoryFragments.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {

    interface View extends BaseView {
        void showListDependency();
        void showDescriptionError();
        void showNameError();
        void showDependencyExistsError();
        void showDependencyDuplicate();
    }

    interface Presenter extends BasePresenter {

        void validatedependency(String name, String shortname, String description);
    }
}
