package jrl.deint.inventoryFragments.ui.dependency.interactor;

import jrl.deint.inventoryFragments.data.db.model.Dependency;
import jrl.deint.inventoryFragments.repository.DependencyRepository;

/**
 * Created by usuario on 29/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditDependencyInteractor {

    // Aquí habría que controlarlo con excepciones en lugar de elseif
    @Override
    public void validateDependency(String name, String shortname, String description, OnAddEditFinishedListener listener) {
        if (name.isEmpty())
            listener.onNameEmptyError();
        else if (shortname.isEmpty())
            listener.onShortNameEmptyError();
        else if (shortname.length() < 2 && shortname.length() > 5)
            listener.onShortNameLengthError();
        else if (description.isEmpty())
            listener.onDescriptionEmptyError();
        else if (DependencyRepository.getInstance().validateDependency(name, shortname))
            listener.onSuccess(name, shortname, description);
    }

    @Override
    public void addDependency(String name, String shortname, String description) {
        Dependency dependency = new Dependency(-1, name, shortname, description);
        DependencyRepository.getInstance().addDependency(dependency);
    }

    @Override
    public void editDependency(Dependency dependency, String description, OnAddEditFinishedListener listener) {
        if(!description.isEmpty()) {
            DependencyRepository.getInstance().editDependency(dependency, description);
            listener.onSuccess(dependency.getName(), dependency.getShortname(), dependency.getDescription());
        } else
            listener.onDescriptionEmptyError();
    }
}
