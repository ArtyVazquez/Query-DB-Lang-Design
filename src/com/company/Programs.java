package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programs {

    // Inserting all the queries in an arraylist
    static public ArrayList<Query> program1 = new ArrayList<>(List.of(
            new Query.CREATE(new DatabaseName("Database CS476"))
    ));

    // Inserting all the queries in an arraylist
    static public ArrayList<Query> program2 = new ArrayList<>(Arrays.asList(
            new Query.CREATE(
                    new DatabaseName("Database CS476")),
            new Query.INSERT(
                    new DatabaseName("Database CS476"),
                    new KeyName("Student1"),
                    new Data.StrVal("Arturo"))
    ));


    // Inserting all the queries in an arraylist
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

    // Inserting all the queries in an arraylist
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




    public static void main(String[] args) {
	// write your code here
        runQueries(program4);

    }

    public static void runQueries(ArrayList<Query> q) {
        Interpreter i = new Interpreter();
        q.forEach(i::query);
    }
}
