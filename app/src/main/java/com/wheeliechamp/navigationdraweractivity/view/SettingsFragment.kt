package com.wheeliechamp.navigationdraweractivity.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.wheeliechamp.navigationdraweractivity.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}