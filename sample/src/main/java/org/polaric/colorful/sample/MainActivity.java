package org.polaric.colorful.sample;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.Colorful;
import org.polaric.colorful.ColorfulActivity;

public class MainActivity extends ColorfulActivity implements OnClickListener {

    private SwitchCompat mSwitchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));

        Button primaryButton = (Button) findViewById(R.id.primary_btn);
        primaryButton.setOnClickListener(this);
        findViewById(R.id.accent_btn).setOnClickListener(this);

        mSwitchCompat = (SwitchCompat) findViewById(R.id.day_night_switch);
        mSwitchCompat.setChecked(Colorful.getThemeDelegate().isNight());
        primaryButton.setEnabled(!mSwitchCompat.isChecked());
        mSwitchCompat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.primary_btn:
                ColorPickerDialog dialog = new ColorPickerDialog(MainActivity.this);
                dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(Colorful.ThemeColor color) {
                        Colorful.config(MainActivity.this)
                                .primaryColor(color)
                                .apply();
                        recreate();
                    }
                });
                dialog.show();

                break;
            case R.id.accent_btn:
                dialog = new ColorPickerDialog(MainActivity.this);
                dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(Colorful.ThemeColor color) {
                        Colorful.config(MainActivity.this)
                                .accentColor(color)
                                .apply();
                        recreate();
                    }
                });
                dialog.show();

                break;
            case R.id.day_night_switch:
                Colorful.config(MainActivity.this)
                        .night(mSwitchCompat.isChecked())
                        .apply();
                recreate();

                break;
        }
    }
}
