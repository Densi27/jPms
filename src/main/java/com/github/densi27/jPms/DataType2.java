package com.github.densi27.jPms;

import com.fasterxml.jackson.annotation.JsonValue;

public class DataType2 {

    String s;
    int i;

    public DataType2(String s, int i) {
        this.s = s;
        this.i = i;
    }

    @Override
    @JsonValue
    public String toString() {
        return "(" + this.s + "," + this.i + ")";
    }
}


