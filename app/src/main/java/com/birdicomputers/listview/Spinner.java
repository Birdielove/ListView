package com.birdicomputers.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Spinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        android.widget.Spinner spinner = findViewById(R.id.spinner);
        String value = getIntent().getExtras().getString("First");
        String value2 = getIntent().getExtras().getString("Second");
        TextView v1 = findViewById(R.id.textView2);
        TextView v2 = findViewById(R.id.textView3);
        v1.setText(value);
        v2.setText(value2);
        String[] a = new String[]{"L","S","T","J"};
        ListView lv = findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(adapter);
    }
}
