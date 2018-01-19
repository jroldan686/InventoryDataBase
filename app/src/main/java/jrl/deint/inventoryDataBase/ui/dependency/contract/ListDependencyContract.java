package jrl.deint.inventoryDataBase.ui.dependency.contract;

import java.io.Serializable;
import java.util.List;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.ui.base.BasePresenter;
import jrl.deint.inventoryDataBase.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);
        void showDeletedMessage();
    }

    interface Presenter extends BasePresenter, Serializable {
        void loadDependencies();
        void deleteItem(Dependency parcelable);

        @Override
        void onDestroy();
    }
}
