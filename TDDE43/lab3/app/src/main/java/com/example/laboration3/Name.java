package com.example.laboration3;

import java.util.ArrayList;

public class Name {

    String id;


    ArrayList<String> result;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getResult() {
        return result;
    }


    public String getName(int n) {

        return result.get(n);

    }



    public void setResult(ArrayList<String> result) {

        this.result = result;
    }
}
