package com.example.testforlab2;

import static com.example.testforlab2.R.id.edtName;
import static com.example.testforlab2.R.id.grid_view;


import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner_dish;
    SpinnerAdapterCustom spinnerAdapterDish;
    Dish dish;
    Button btnAdd;
    ArrayList<Dish> arrayListDish;
    ArrayList<Dish> ListDishSecond;
    DishAdapter adapter;
    CheckBox checkBoxPromotion;
    GridView gvDish;
    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exampleth5);

        arrayListDish = new ArrayList<Dish>();
        arrayListDish.add(new Dish("Thumbnail 1", R.drawable.dish1));
        arrayListDish.add(new Dish("Thumbnail 2", R.drawable.dish2));
        arrayListDish.add(new Dish("Thumbnail 3", R.drawable.dish3));
        arrayListDish.add(new Dish("Thumbnail 4", R.drawable.dish4));
        arrayListDish.add(new Dish("Thumbnail 5", R.drawable.dish5));
        arrayListDish.add(new Dish("Thumbnail 6", R.drawable.dish6));
        arrayListDish.add(new Dish("Thumbnail 7", R.drawable.dish7));
        arrayListDish.add(new Dish("Thumbnail 8", R.drawable.dish8));
        arrayListDish.add(new Dish("Thumbnail 9", R.drawable.dish9));
        spinner_dish = (Spinner) findViewById(R.id.spn_dish);

        spinnerAdapterDish = new SpinnerAdapterCustom(getApplicationContext(), R.layout.dropdownitem, arrayListDish);
        spinner_dish.setAdapter(spinnerAdapterDish);

        spinner_dish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dish = arrayListDish.get(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        checkBoxPromotion = (CheckBox) findViewById(R.id.checkbox);
        btnAdd = (Button) findViewById(R.id.btnAddNewDish);
        gvDish = (GridView) findViewById(R.id.grid_view);
        edtName = (EditText) findViewById(R.id.edtName);
        ListDishSecond = new ArrayList<Dish>();
        adapter = new DishAdapter(this, R.layout.grid_item_layout, ListDishSecond);
        gvDish.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Dish newDish = new Dish();
                newDish.setName(name);
                newDish.setThumbnail(dish.getThumbnail());
                if (checkBoxPromotion.isChecked()) {
                    newDish.setPromotion(true);
                } else {
                    newDish.setPromotion(false);
                }
                ListDishSecond.add(newDish);
                edtName.setText("");
                spinner_dish.setSelection(0);
                checkBoxPromotion.setChecked(false);
                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });
    }
}