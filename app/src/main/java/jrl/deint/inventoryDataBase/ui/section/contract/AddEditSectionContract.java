package jrl.deint.inventoryDataBase.ui.section.contract;

import jrl.deint.inventoryDataBase.data.db.model.Section;
import jrl.deint.inventoryDataBase.ui.base.BasePresenter;
import jrl.deint.inventoryDataBase.ui.base.BaseView;

/**
 * Created by usuario on 26/01/18.
 */

public interface AddEditSectionContract {

    interface View extends BaseView {
        void showListSection();
    }

    interface Presenter extends BasePresenter {
        void saveSection(String name, String shortName, String description, int dependencyId, boolean enabled, boolean _default);
        void editSection(Section section, String description);
    }
}
