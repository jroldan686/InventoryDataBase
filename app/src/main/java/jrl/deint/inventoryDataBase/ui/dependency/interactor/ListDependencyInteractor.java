package jrl.deint.inventoryDataBase.ui.dependency.interactor;

import java.util.List;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;

/**
 * Created by usuario on 29/11/17.
 */

public interface ListDependencyInteractor {

    void deleteDependency(Dependency dependency);

    interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> dependencies);
    }

    void loadDependencies();
}
