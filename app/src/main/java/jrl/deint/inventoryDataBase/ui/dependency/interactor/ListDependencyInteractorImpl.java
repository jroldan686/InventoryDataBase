package jrl.deint.inventoryDataBase.ui.dependency.interactor;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private final OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        if(DependencyRepository.getInstance().deleteDependency(dependency))
            //Falta mostrar mensaje cuando se haya eliminado
            listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    public void loadDependencies(){
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
