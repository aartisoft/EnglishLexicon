package com.myapp.lexicon.settings;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.View;

import com.myapp.lexicon.R;
import com.myapp.lexicon.main.MainActivity;

import androidx.annotation.Nullable;

/**
 * Created by Renat
 */

public class SettingsFragment extends PreferenceFragment
{
    ListPreference listDisplayModePref;
    CheckBoxPreference serviceCheckBoxPref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
        listDisplayModePref = (ListPreference) findPreference(getActivity().getString(R.string.key_list_display_mode));
        // при новом создании экрана заполняем summary значением настройки
        listDisplayModePref.setSummary(listDisplayModePref.getEntry());

        listDisplayModePref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue)
            {
                listDisplayModePref.setValue(newValue.toString());
                listDisplayModePref.setSummary(listDisplayModePref.getEntry());
                return true;
            }
        });

        final ListPreference listOnUnBlokingScreen = (ListPreference) findPreference(getActivity().getString(R.string.key_on_unbloking_screen));
        listOnUnBlokingScreen.setSummary(listOnUnBlokingScreen.getEntry());
        listOnUnBlokingScreen.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue)
            {
                listOnUnBlokingScreen.setValue(newValue.toString());
                listOnUnBlokingScreen.setSummary(listOnUnBlokingScreen.getEntry());
                AppData.getInstance().setDisplayVariant(Integer.parseInt(newValue.toString()));
                return true;
            }
        });

        serviceCheckBoxPref = (CheckBoxPreference) findPreference(getActivity().getString(R.string.key_service));
        serviceCheckBoxPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue)
            {
                listDisplayModePref.setEnabled((Boolean) newValue);
                listOnUnBlokingScreen.setEnabled((Boolean) newValue);
                if (MainActivity.serviceIntent != null)
                {
                    getActivity().stopService(MainActivity.serviceIntent);
                }
                return true;
            }
        });
        if (!serviceCheckBoxPref.isChecked())
        {
            listOnUnBlokingScreen.setEnabled(false);
            listDisplayModePref.setEnabled(false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(R.color.colorWhite));

    }
}
