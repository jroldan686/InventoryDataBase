package jrl.deint.inventoryDataBase.ui.dependency.presenter;

import java.io.Serializable;
import java.util.List;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.ui.dependency.contract.ListDependencyContract;
import jrl.deint.inventoryDataBase.ui.dependency.interactor.ListDependencyInteractor;
import jrl.deint.inventoryDataBase.ui.dependency.interactor.ListDependencyInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractor.OnLoadFinishedListener, Serializable {

    public static final String TAG = "listdependencypresenter";
    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl interactor;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.interactor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependencies() {
        interactor.loadDependencies();
    }

    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependency(dependencies);
    }

    @Override
    public void validatedependency() {

    }

    @Override
    public void deleteItem(Dependency dependency) {
        interactor.deleteDependency(dependency);
        loadDependencies();
        view.showDeletedMessage();
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }
}
