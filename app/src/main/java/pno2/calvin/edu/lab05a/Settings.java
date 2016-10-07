package pno2.calvin.edu.lab05a;
/* Settings shows an example preference check box
 *
 * Author: Peter Oostema
 * Date: October 7, 2016
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
