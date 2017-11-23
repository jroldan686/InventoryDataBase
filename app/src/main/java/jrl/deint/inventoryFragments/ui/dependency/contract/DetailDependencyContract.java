package jrl.deint.inventoryFragments.ui.dependency.contract;

/**
 * Created by jesus on 23/11/17.
 */

public interface DetailDependencyContract {

    interface View {
        void setPresenter(DetailDependencyContract.Presenter presenter);
    }

    interface Presenter {

    }
}
