package jrl.deint.inventoryDataBase.ui.section.interactor;

import java.util.List;

import jrl.deint.inventoryDataBase.data.db.model.Section;

/**
 * Created by usuario on 26/01/18.
 */

public interface ListSectionInteractor {

    void deleteSection();
    void loadSections();

    interface OnLoadFinishedListener {
        void onSuccess(List<Section> sections);
    }
}
