package com.github.densi27.jPms;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;

public class DataType1 {

    String name;
    LocalDate datum;

    public DataType1(String name, LocalDate datum) {
        this.name = name;
        this.datum = datum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    @JsonValue
    public String toString() {
        return "(" + this.name + "," + this.datum + ")";
    }
}
