package com.example.hwandroid82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerLanguages;
    private Button btnOK;
    private String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLanguages = findViewById(R.id.spinnerLanguages);
        btnOK = findViewById(R.id.btnOK);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerLanguages, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerLanguages.setAdapter(arrayAdapter);

        spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                String[] spinnerLanguages = getResources().getStringArray(R.array.spinnerLanguages);
                selected = spinnerLanguages[position];

            }
            @Override
            public void onNothingSelected(AdapterView adapterView) {
            }
        });



        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selected.equals("Russian")) {
                Locale locale = new Locale("ru", "rRU");

                Configuration config = new Configuration();
                config.setLocale(locale);

                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
                }else if (selected.equals("Английский")){
                    Locale locale = new Locale("en","rGB");

                    Configuration config = new Configuration();
                    config.setLocale(locale);

                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }
}
