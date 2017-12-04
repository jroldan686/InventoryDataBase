package jrl.deint.inventoryFragments.data.prefs;

import android.content.SharedPreferences;

import jrl.deint.inventoryFragments.ui.inventory.InventoryApplication;
import jrl.deint.inventoryFragments.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper {

    // 2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper() {
        // Si es el fichero por defecto de las preferencias
        this.preferences = InventoryApplication.getContext().getDefaultSharedPreferences();
    }

    /**
     * Método de acceso a la instancia de la clase AppPreferencesHelper

     * @return
     */
    public static AppPreferencesHelper getInstance() {
        if(instance==null)
            instance = new AppPreferencesHelper();
        return instance;
    }

    public long getCurrentUserId() {
        long id = preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName() {
        String name = preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public String getCurrentUserPassword() {
        String password = preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }

    public boolean getCurrentUserRemember() {
        boolean remember = preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return remember;
    }

    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();
    }

    public void setCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();
    }

    public void setCurrentUserRemember(boolean remember) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();
    }

    public static String getPrefKeyCurrentUserId() {
        return PREF_KEY_CURRENT_USER_ID;
    }

    public static String getPrefKeyCurrentUserName() {
        return PREF_KEY_CURRENT_USER_NAME;
    }

    public static String getPrefKeyCurrentUserPassword() {
        return PREF_KEY_CURRENT_USER_PASSWORD;
    }

    public static String getPrefKeyCurrentUserRemember() {
        return PREF_KEY_CURRENT_USER_REMEMBER;
    }
}
