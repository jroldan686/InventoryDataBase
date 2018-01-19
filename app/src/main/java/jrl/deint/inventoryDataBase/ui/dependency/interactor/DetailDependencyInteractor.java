package jrl.deint.inventoryDataBase.ui.dependency.interactor;

import java.util.List;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;

/**
 * Created by usuario on 24/11/17.
 */

public class DetailDependencyInteractor {
    public interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> dependencies);
    }

    void loadDependencies() {

    }
}
