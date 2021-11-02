package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programs {

    // CREATE
    static public ArrayList<Query> program1 = new ArrayList<>(List.of(
            new Query.CREATE(new DatabaseName("Database CS476"))
    ));

    // CREATE, INSERT
    static public ArrayList<Query> program2 = new ArrayList<>(Arrays.asList(
            new Query.CREATE(
                    new DatabaseName("Database CS476")),
            new Query.INSERT(
                    new DatabaseName("Database CS476"),
                    new KeyName("Student1"),
                    new Data.StrVal("Arturo"))
    ));


    // CREATE, INSERT, GET
    static public ArrayList<Query> program3 = new ArrayList<>(Arrays.asList(
            new Query.CREATE(
                    new DatabaseName("Database CS476")),
            new Query.INSERT(
                    new DatabaseName("Database CS476"),
                    new KeyName("Student1"),
                    new Data.StrVal("Arturo")),
            new Query.GET(new DatabaseName("Database CS476"),
                    new KeyName("Student1"))
    ));

    // CREATE, INSERT, UPDATE, GET
    static public ArrayList<Query> program4 = new ArrayList<>(Arrays.asList(
            new Query.CREATE(
                    new DatabaseName("Database CS476")),
            new Query.INSERT(
                    new DatabaseName("Database CS476"),
                    new KeyName("Student1"),
                    new Data.StrVal("Arturo")),
            new Query.UPDATE(new DatabaseName("Database CS476"),
                    new KeyName("Student1"),
                    new Data.StrVal("Arty")),
            new Query.GET(new DatabaseName("Database CS476"),
                    new KeyName("Student1"))
    ));

//    // CREATE, INSERT, GET
    static public ArrayList<Query> program5 = new ArrayList<>(Arrays.asList(
            new Query.CREATE(
                    new DatabaseName("Shoes")),
            new Query.INSERT(
                    new DatabaseName("Shoes"),
                    new KeyName("Jordan's"),
                    new Data.ArrayVal(
                            new Data.StrVal("Retro 1"),
                            new Data.StrVal("Retro 2"),
                            new Data.StrVal("Retro 3"),
                            new Data.StrVal("Retro 4"),
                            new Data.StrVal("Retro 5"))),
            new Query.GET(
                    new DatabaseName("Shoes"),
                    new KeyName("Jordan's"))
        ));





    public static void main(String[] args) {
	// write your code here
        runQueries(program5);

    }

    public static void runQueries(ArrayList<Query> q) {
        Interpreter i = new Interpreter();
        q.forEach(i::query);
    }
}
