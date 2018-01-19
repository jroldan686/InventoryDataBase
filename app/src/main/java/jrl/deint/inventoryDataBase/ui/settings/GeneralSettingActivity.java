package jrl.deint.inventoryDataBase.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import jrl.deint.inventoryDataBase.R;

public class GeneralSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.generic_settings);
    }
}
