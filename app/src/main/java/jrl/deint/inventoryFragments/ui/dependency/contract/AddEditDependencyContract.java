package jrl.deint.inventoryFragments.ui.dependency.contract;

import jrl.deint.inventoryFragments.ui.base.BasePresenter;
import jrl.deint.inventoryFragments.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {

    interface View extends BaseView {
        void showListDependency();
        void showDescriptionEmptyError();
        void showNameEmptyError();
        void showShortNameEmptyError();
        void showShortNameLengthError();
        void showDependencyDuplicate();
        void onSuccess();
    }

    interface Presenter extends BasePresenter {
        void saveDependency(String name, String shortName, String description);
    }
}
