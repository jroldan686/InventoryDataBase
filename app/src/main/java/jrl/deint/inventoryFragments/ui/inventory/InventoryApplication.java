package jrl.deint.inventoryFragments.ui.inventory;

import android.app.Application;
import java.util.ArrayList;
import jrl.deint.inventoryFragments.data.db.model.Dependency;

public class InventoryApplication extends Application {

    ArrayList<Dependency> dependencies;

    public InventoryApplication() {
        dependencies = new ArrayList();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
