package jrl.deint.inventoryFragments.ui.inventory;

import android.app.Application;
import java.util.ArrayList;
import jrl.deint.inventoryFragments.data.db.model.Dependency;
import jrl.deint.inventoryFragments.data.prefs.AppPreferencesHelper;

public class InventoryApplication extends Application {

    //ArrayList<Dependency> dependencies;

    private AppPreferencesHelper appPreferencesHelper;

    public AppPreferencesHelper InventoryApplication() {
        //dependencies = new ArrayList();
        return appPreferencesHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper=AppPreferencesHelper.getInstance();
    }
}
