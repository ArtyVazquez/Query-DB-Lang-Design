package com.company;


public class RunQueries {


    public static void main(String[] args) {

       Interpreter i = new Interpreter();

        // Program 1 CREATE
/*        i.query(new Query.CREATE(
                new DatabaseIdent("Database CS476")));*/

        // Program 2 CREATE, INSERT
        i.query(new Query.CREATE(
                        new DatabaseIdent("Database CS476")),
                new Query.INSERT(
                        new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo")));

        // Program 3 CREATE, INSERT. GET
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Database CS476")),
                new Query.INSERT(
                        new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.RETRIEVE(new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1")));*/

        // Program 4 CREATE, INSERT, UPDATE, GET
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Database CS476")),
                new Query.INSERT(
                        new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.UPDATE(new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo Vazquez")),
                new Query.RETRIEVE(new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1")));*/

        // Program 5 CREATE, INSERT, UPDATE, GET
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Plants")),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.RETRIEVE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Vegetables")));*/

        // Program 6
  /*      i.query(new Query.CREATE(
                        new DatabaseIdent("Plants")),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.RETRIEVE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits")));*/

        // Program 7 ---> error thrown : Invalid DB or Key does not exist
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Plants")),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.REMOVE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits")),
                new Query.RETRIEVE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits")
                ));*/

        // Program 8
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Plants")),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits"),
                        new Data.ArrayVal(
                                new Data.StrVal("Apple"),
                                new Data.StrVal("Pear"),
                                new Data.StrVal("Grape"),
                                new Data.StrVal("Mango"),
                                new Data.StrVal("Cherry"))),
                new Query.INSERT(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Vegetables"),
                        new Data.ArrayVal(
                                new Data.StrVal("Tomato"),
                                new Data.StrVal("Cauliflower"),
                                new Data.StrVal("Broccoli"),
                                new Data.StrVal("Zucchini"))),
                new Query.COMBINE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits & Veg"),
                        new KeyIdent("Vegetables"),
                        new KeyIdent("Fruits")),
                new Query.RETRIEVE(
                        new DatabaseIdent("Plants"),
                        new KeyIdent("Fruits & Veg")
                ));*/



        /*
        *
        *
        * Type Checker
        *
        * */


       TypeChecker tc = new TypeChecker();
        System.out.println(
                tc.typeCheck(new Query.CREATE(new DatabaseIdent("MyDB")))); // Should return true

        System.out.println(
                tc.typeCheck(new Query.CREATE(new KeyIdent("DB")))); // Should return false

        System.out.println(
                tc.typeCheck(new Query.CREATE(new Ident()))); // Should return false

        System.out.println(
                tc.typeCheck(new Query.CREATE(new DatabaseIdent("School")), // Should return true;
                                new Query.INSERT(
                                        new DatabaseIdent("School"),
                                        new KeyIdent("Midterm Grades"),
                                        new Data.DoubleVal(88.88))));

        System.out.println(
        tc.typeCheck(new Query.CREATE(new DatabaseIdent("School")), // Should return false;
                new Query.INSERT(
                        new DatabaseIdent("School"),
                        new DatabaseIdent("Midterm Grades"),
                        new Data.DoubleVal(100.00))));



    }
}
