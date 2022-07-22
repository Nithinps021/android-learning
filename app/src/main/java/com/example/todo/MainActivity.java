package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView list;
    private Spinner spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button btn = findViewById(R.id.button);
//        btn.setOnClickListener(this::onClick);
//        btn.setOnLongClickListener(this::onLongClick);
        list= findViewById(R.id.list);
        spin = findViewById(R.id.spinner);

        ArrayList<String> citiList = new ArrayList<>();
        citiList.add("Pothecode");
        citiList.add("Ariyottukonam");
        citiList.add("Andoorkonam");
        citiList.add("Trivandrum");
        citiList.add("Pothecode");
        citiList.add("Ariyottukonam");
        citiList.add("Andoorkonam");

        ArrayList<String> dropdown = new ArrayList<>();
        dropdown.add("Nithin");
        dropdown.add("Bob");
        dropdown.add("Rob");
        dropdown.add("Clob");



        ArrayAdapter<String> citiAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                citiList
        );

        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                dropdown
        );



        list.setAdapter(citiAdapter);
        spin.setAdapter(dropDownAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,dropdown.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,citiList.get(i),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settingsmenu:
                Toast.makeText(MainActivity.this,"Settings Clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.alarm:
                Toast.makeText(MainActivity.this,"Alarm Clicked",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //    @Override
//    public boolean onLongClick(View view){
//        Toast.makeText(this,"Long click",Toast.LENGTH_SHORT).show();
//        return true;
//    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.button:
//                Toast.makeText(this,"hello button clicked ",Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//
//        }
//    }
}