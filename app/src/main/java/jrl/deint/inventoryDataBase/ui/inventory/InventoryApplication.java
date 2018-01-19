package jrl.deint.inventoryDataBase.ui.inventory;

import android.app.Application;
import android.content.Context;

import jrl.deint.inventoryDataBase.data.prefs.AppPreferencesHelper;

public class InventoryApplication extends Application {

    //ArrayList<Dependency> dependencies;

    private AppPreferencesHelper appPreferencesHelper;
    private static Context application;

    public static Context getContext() {
        return application;
    }

    public static void setApplication(Context application) {
        InventoryApplication.application = application;
    }

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
