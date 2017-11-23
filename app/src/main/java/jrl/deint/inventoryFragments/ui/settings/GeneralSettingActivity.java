package jrl.deint.inventoryFragments.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import jrl.deint.inventoryFragments.R;

public class GeneralSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.generic_settings);
    }
}
