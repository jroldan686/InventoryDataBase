package jrl.deint.inventoryDataBase.ui.section.interactor;

import jrl.deint.inventoryDataBase.data.db.model.Section;

/**
 * Created by usuario on 26/01/18.
 */

public interface AddEditSectionInteractor {

    interface OnAddEditFinishedListener {
        void onNameEmptyError();
        void onShortNameEmptyError();
        void onShortNameLengthError();
        void onDescriptionEmptyError();
        void onDependencyIdEmptyError();
        void onSuccess(String name, String shortname, String description, int dependencyId);
    }

    void validateSection(String name, String shortname, String description, int dependencyId, OnAddEditFinishedListener listener);

    void addSection(String name, String shortname, String description, int dependencyId, boolean enabled, boolean _default);

    void editSection(Section section, String description, OnAddEditFinishedListener listener);

    void updateSection(Section section);
}
