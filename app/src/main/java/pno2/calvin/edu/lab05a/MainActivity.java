package pno2.calvin.edu.lab05a;

/* Main Activity displays a set text and allows context switching to an about page\
 *   and a settings page
 *
 * Author: Peter Oostema
 * Date: October 7, 2016
 */

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.preference.PreferenceManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;

/*MainActivity sets up the layout of a textbox and a activity menu
 * it also implements the context switching to the about page
 */
public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean preference = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();
    }

    private void showPreferences() {
        TextView preferenceTextView = (TextView) findViewById(R.id.preferenceTextView);
        preferenceTextView.setText("Preference: " + prefs.getBoolean("preference", false));
    }

    @Override
    public void onPause() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preference", preference);
        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        preference = prefs.getBoolean("preference", false);
        showPreferences();
    }

    /*onCreateOptionsMenu creates a menu for context switching
     * @param menu a menu to create a menu from
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /* onOptionsItemSelected handles the context switching of the app
     * @param item, a MenuItem adds the ability to move to the about activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(getApplicationContext(), About.class));
                return true;
            case R.id.menu_settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
