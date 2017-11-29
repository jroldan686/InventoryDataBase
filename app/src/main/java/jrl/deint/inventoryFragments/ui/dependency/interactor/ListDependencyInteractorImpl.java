package jrl.deint.inventoryFragments.ui.dependency.interactor;

import jrl.deint.inventoryFragments.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private final OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    public void loadDependencies(){
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
