package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programs {


    public static void main(String[] args) {

        Interpreter i = new Interpreter();

        // Program 1 CREATE
/*        i.query(new Query.CREATE(
                new DatabaseName("Database CS476")));*/

        // Program 2 CREATE, INSERT
/*        i.query(new Query.CREATE(
                        new DatabaseName("Database CS476")),
                new Query.INSERT(
                        new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo")));*/

        // Program 3 CREATE, INSERT. GET
/*        i.query(new Query.CREATE(
                        new DatabaseName("Database CS476")),
                new Query.INSERT(
                        new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.RETRIEVE(new DatabaseName("Database CS476"),
                        new KeyName("Student1")));*/

        // Program 4 CREATE, INSERT, UPDATE, GET
/*        i.query(new Query.CREATE(
                        new DatabaseName("Database CS476")),
                new Query.INSERT(
                        new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.UPDATE(new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo Vazquez")),
                new Query.RETRIEVE(new DatabaseName("Database CS476"),
                        new KeyName("Student1")));*/

        // Program 5 CREATE, INSERT, UPDATE, GET
/*        i.query(new Query.CREATE(
                        new DatabaseName("Plants")),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.RETRIEVE(
                        new DatabaseName("Plants"),
                        new KeyName("Vegetables")));*/

        // Program 6
/*        i.query(new Query.CREATE(
                        new DatabaseName("Plants")),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.RETRIEVE(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits")));*/

        // Program 7 ---> error thrown
/*        i.query(new Query.CREATE(
                        new DatabaseName("Plants")),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.REMOVE(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits")),
                new Query.RETRIEVE(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits")
                ));*/

        // Program 8
/*        i.query(new Query.CREATE(
                        new DatabaseName("Plants")),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseName("Plants"),
                        new KeyName("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.COMBINE(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits & Veg"),
                        new KeyName("Vegetables"),
                        new KeyName("Fruits")),
                new Query.RETRIEVE(
                        new DatabaseName("Plants"),
                        new KeyName("Fruits & Veg")
                ));*/










        /*
        *
        *
        * Type Checker
        *
        * */

        TypeChecker tc = new TypeChecker();
        System.out.println(tc.typeCheckQuery(new Query.CREATE(new DatabaseName("MyDB")), Data.TYPE.DATABASE));
    }
}
