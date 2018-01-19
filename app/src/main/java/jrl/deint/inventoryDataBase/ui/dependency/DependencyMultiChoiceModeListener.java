package jrl.deint.inventoryDataBase.ui.dependency;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.ui.dependency.contract.ListDependencyContract;
import jrl.deint.inventoryDataBase.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 20/12/17.
 */

public class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

    private ListDependencyPresenter presenter;
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter) {

    }

    @Override
    public void onItemCheckedStateChanged(android.view.ActionMode actionMode, int position, long id, boolean checked) {
        if(checked) {
            presenter.setNewSelection(position);
        }
        else {
            count++;
            presenter.removeSelection(position);
        }
        actionMode.setTitle(count + " seleccionados");
    }

    @Override
    public boolean onCreateActionMode(android.view.ActionMode actionMode, Menu menu) {
        MenuInflater inflater = actionMode.getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_listdependency, menu);
        actionMode.setTitle("Iniciando ActionMode");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(android.view.ActionMode mode) {
        count = 0;
    }
}
