package com.hari.aag.textcolorchanger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TextColorChangerActivity extends AppCompatActivity {

    TextView helloWorldTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color_changer);
        helloWorldTV = (TextView) findViewById(R.id.id_hello);
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
        int color = 0;
        switch (item.getItemId()){
            case R.id.id_violet:    color = R.color.colorViolet;    break;
            case R.id.id_indigo:    color = R.color.colorIndigo;    break;
            case R.id.id_blue:      color = R.color.colorBlue;      break;
            case R.id.id_green:     color = R.color.colorGreen;     break;
            case R.id.id_yellow:    color = R.color.colorYellow;    break;
            case R.id.id_orange:    color = R.color.colorOrange;    break;
            case R.id.id_red:       color = R.color.colorRed;       break;
            default:
                return super.onOptionsItemSelected(item);
        }
        helloWorldTV.setTextColor(getResources().getColor(color));
        return true;
    }
}
