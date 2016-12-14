package com.hari.aag.textcolorchanger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TextColorChangerActivity extends AppCompatActivity {

    private static final String LOG_TAG = TextColorChangerActivity.class.getSimpleName();
    private static final String PREFS_NAME = TextColorChangerActivity.class.getSimpleName();

    private static final String SELECTED_COLOR = "selectedColor";

    private int selectedColorInt = 0;

    TextView helloWorldTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color_changer);
        helloWorldTV = (TextView) findViewById(R.id.id_hello);

        Log.d(LOG_TAG, "Inside - onCreate!");
        readValuesFromPrefs();
        updateValueToUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Inside - onPause!");
        saveValuesToPrefs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.text_color_changer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_violet:    selectedColorInt = R.color.colorViolet;    break;
            case R.id.id_indigo:    selectedColorInt = R.color.colorIndigo;    break;
            case R.id.id_blue:      selectedColorInt = R.color.colorBlue;      break;
            case R.id.id_green:     selectedColorInt = R.color.colorGreen;     break;
            case R.id.id_yellow:    selectedColorInt = R.color.colorYellow;    break;
            case R.id.id_orange:    selectedColorInt = R.color.colorOrange;    break;
            case R.id.id_red:       selectedColorInt = R.color.colorRed;       break;
            default:
                return super.onOptionsItemSelected(item);
        }
        updateValueToUI();
        return true;
    }

    private void updateValueToUI(){
        if (selectedColorInt != 0){
            helloWorldTV.setTextColor(getResources().getColor(selectedColorInt));
        }
    }

    private void readValuesFromPrefs(){
        SharedPreferences mySharedPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        selectedColorInt = mySharedPrefs.getInt(SELECTED_COLOR, 0);

        Log.d(LOG_TAG, "Values Read from Prefs.\n");
        dumpPrefValues();
    }

    private void saveValuesToPrefs(){
        SharedPreferences.Editor prefsEditor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();

        prefsEditor.putInt(SELECTED_COLOR, selectedColorInt);
        prefsEditor.commit();

        Log.d(LOG_TAG, "Values Saved to Prefs.\n");
        dumpPrefValues();
    }

    private void dumpPrefValues(){
        Log.d(LOG_TAG, SELECTED_COLOR + " - " + selectedColorInt);
    }
}
