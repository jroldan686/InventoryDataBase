package jrl.deint.inventoryDataBase.ui.section.contract;

import java.util.List;

import jrl.deint.inventoryDataBase.ui.base.BasePresenter;
import jrl.deint.inventoryDataBase.ui.base.BaseView;

/**
 * Created by usuario on 26/01/18.
 */

public interface ListSectionContract {

    interface View extends BaseView {
        void showSection(List listSectionInteractor);
    }

    interface Presenter extends BasePresenter {
        void loadSection();
    }
}
