package pno2.calvin.edu.lab05a;
/* SettingsFragment loads a preference box from preferences.xml
 *
 * Author: Peter Oostema
 * Date: October 7, 2016
 */
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by pno2 on 10/7/2016.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
