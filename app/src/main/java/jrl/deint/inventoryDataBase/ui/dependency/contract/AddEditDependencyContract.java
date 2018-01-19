package jrl.deint.inventoryDataBase.ui.dependency.contract;

import java.io.Serializable;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.ui.base.BasePresenter;
import jrl.deint.inventoryDataBase.ui.base.BaseView;

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
    }

    interface Presenter extends BasePresenter, Serializable {
        void saveDependency(String name, String shortName, String description);
        void editDependency(Dependency dependency, String description);

        @Override
        void onDestroy();
    }
}
