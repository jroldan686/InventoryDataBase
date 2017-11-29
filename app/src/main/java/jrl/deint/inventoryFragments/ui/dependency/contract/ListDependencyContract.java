package jrl.deint.inventoryFragments.ui.dependency.contract;

import java.util.List;

import jrl.deint.inventoryFragments.ui.base.BasePresenter;
import jrl.deint.inventoryFragments.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);
    }

    interface Presenter extends BasePresenter {
        void loadDependencies();
    }
}
