package com.example.lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView lvPerson;
    TextView tvPerson;
    EditText edtName;
    Button btnAdd;
    ArrayList<String> arrayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                // truong hop 1
        // 1 - AdapterView : ListView
        lvPerson = (ListView) findViewById(R.id.lv_person);
        tvPerson = findViewById(R.id.tv_person);
        // 2- Data Source
        String arr[] = {"Teo", "Ty", "Bin", "Bo"};

        // 3- Adapter : acts as a brigde between the 'data source' and the 'AdapterView'
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        // link listview with the Adapter
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                String value = lvPerson.getItemAtPosition(position).toString();
                tvPerson.setText("position :" + position+ " ; value =" + value);
            }
        });

    }
}