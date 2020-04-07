package com.example.lab19;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<String> notes = new ArrayList<>();

    public MyApp(){
        super();
        notes.add("lxmpt");
        notes.add("Заур");
    }

    public List<String> getNotes(){
        return notes;
    }
}
