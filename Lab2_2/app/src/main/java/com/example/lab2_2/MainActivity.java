package com.example.lab2_2;



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

        // truong hop 3
        // truong hop 1
        // 1 - AdapterView : ListView
        lvPerson = (ListView) findViewById(R.id.lv_person);
        tvPerson = (TextView) findViewById(R.id.tv_person);
        edtName = (EditText) findViewById(R.id.edtName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        // 2- Data Source
        arrayName = new ArrayList<>();
        arrayName.add("Tèo");
        arrayName.add("Tý");
        arrayName.add("Bin");
        arrayName.add("Bo");

        // 3- Adapter : acts as a brigde between the 'data source' and the 'AdapterView'
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayName);
        // link listview with the Adapter
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                String value = lvPerson.getItemAtPosition(position).toString();
                tvPerson.setText("position :" + position + " ; value =" + value);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String ten = edtName.getText().toString();
                arrayName.add(ten);
                adapter.notifyDataSetChanged();
            }
        });

        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}

