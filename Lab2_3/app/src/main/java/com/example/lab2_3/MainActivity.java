package com.example.lab2_3;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMaNV;
    EditText edtTenNV;
    RadioButton rd_chinhthuc, rdBtnKhong;
    RadioGroup rgType;
    Button btnNhap;
    ListView lv_staff;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMaNV = (EditText) findViewById(R.id.edtMaNV);
        edtTenNV = (EditText) findViewById(R.id.edtTenNV);
        rgType = (RadioGroup) findViewById(R.id.gr_radio);
        btnNhap = (Button) findViewById(R.id.btnEnter);
        lv_staff = (ListView) findViewById(R.id.lv_staff);
        employees = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);
        lv_staff.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                int curId = rgType.getCheckedRadioButtonId();
                String id = edtMaNV.getText().toString();
                String name = edtTenNV.getText().toString();
                if(curId==R.id.radio_offical)
                {
                    employee = new EmployeeFulltime();
                }
                else
                {
                    employee = new EmployeeParttime();
                }
                employee.setId(id);
                employee.setName(name);
                employees.add(employee);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
