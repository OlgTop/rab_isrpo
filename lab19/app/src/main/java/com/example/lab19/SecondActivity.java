package com.example.lab19;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends BaseClass implements TextWatcher {
EditText editText;
    Button button;
    int pos;
    Boolean action=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);
        editText.addTextChangedListener(this);
        button = findViewById(R.id.button2);
        button.setEnabled(false);
        Bundle extras = getIntent().getExtras();

        if(extras !=null){
            action = true;
            String txt = extras.getString(EXTRA_TEXT);
            pos = extras.getInt(EXTRA_ID);

            if(txt!=null){
                editText.setText(txt);
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String str = charSequence.toString().trim();
        if(str.length()>0)
            button.setEnabled(true);
        else
            button.setEnabled(false);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void Confirm(View view) {
        Intent intent =getIntent();
        intent.putExtra(EXTRA_TEXT, editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
