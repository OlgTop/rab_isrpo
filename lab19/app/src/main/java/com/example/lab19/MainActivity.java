package com.example.lab19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends BaseClass implements AdapterView.OnItemClickListener {
    protected MyApp myApp;
    List<String> notes;
    MyAdapter myAdapter;
    private ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApp = (MyApp)getApplicationContext();
        notes = myApp.getNotes();
        button = findViewById(R.id.button);
        myAdapter = new MyAdapter(getApplicationContext());
        listView = findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }



    public void Add(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String txt = notes.get(i);
        //int pos = i;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, txt);
        intent.putExtra(EXTRA_ID, i);
        startActivityForResult(intent, EDIT_ACTION);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String newTxt = extras.getString(EXTRA_TEXT);
            switch (requestCode) {
                case CREATE_ACTION:
                notes.add(newTxt);
                    break;
                case EDIT_ACTION:
                int pos = extras.getInt(EXTRA_ID);
                notes.set(pos, newTxt);
                    break;
            }
            listView.invalidateViews();
        }

    }
}
