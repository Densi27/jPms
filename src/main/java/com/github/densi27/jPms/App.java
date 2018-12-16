package com.github.densi27.jPms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    static Map<DataType1, DataType2> myMap;

    public static void main(String[] args) throws IOException {

        myMap = new HashMap<>();
        DataType1 k1 = new DataType1("daniel", LocalDate.of(1974,1,1));
        DataType2 v1 = new DataType2("desery", 27);
        DataType1 k2 = new DataType1("tina", LocalDate.of(1975,3,13));
        DataType2 v2 = new DataType2("desery", 13);
        DataType1 k3 = new DataType1("fine", LocalDate.of(2009,4,25));
        DataType2 v3 = new DataType2("desery", 25);
        DataType1 k4 = new DataType1("charlie", LocalDate.of(2011,6,9));
        DataType2 v4 = new DataType2("desery", 9);
        myMap.put(k1,v1);
        myMap.put(k2,v2);
        myMap.put(k3,v3);
        myMap.put(k4,v4);

        ObjectMapper om = new ObjectMapper();

        String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(myMap);
        System.out.println(jsonString);
        try (PrintWriter pw = new PrintWriter(new FileWriter("jsonFile.json"))) {
            pw.write(jsonString);
        }

        Map<DataType1, List<DataType2>> myMap2 = new HashMap<>();
        myMap2.put(k1, Arrays.asList(v1,v2,v3,v4));

        String jsonString2 = om.writerWithDefaultPrettyPrinter().writeValueAsString(myMap2);
        System.out.println(jsonString2);
        try (PrintWriter pw = new PrintWriter(new FileWriter("jsonFile2.json"))) {
            pw.write(jsonString2);
        }

        Map<DataType1, List<DataType2>> myMap3 = om.readValue(new FileReader("jsonFile3.json"), HashMap.class);
        System.out.println(myMap3);

    }

}
