package com.company;


public class Programs {


    public static void main(String[] args) {

        Interpreter i = new Interpreter();

        // Program 1 CREATE
/*        i.queryAll(new Query.CREATE(
                new DatabaseName("Database CS476")));*/

        // Program 2 CREATE, INSERT
/*        i.queryAll(new Query.CREATE(
                        new DatabaseName("Database CS476")),
                new Query.INSERT(
                        new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo")));*/

        // Program 3 CREATE, INSERT. GET
/*        i.queryAll(new Query.CREATE(
                        new DatabaseName("Database CS476")),
                new Query.INSERT(
                        new DatabaseName("Database CS476"),
                        new KeyName("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.RETRIEVE(new DatabaseName("Database CS476"),
                        new KeyName("Student1")));*/

        // Program 4 CREATE, INSERT, UPDATE, GET
/*        i.queryAll(new Query.CREATE(
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
/*        i.queryAll(new Query.CREATE(
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
/*        i.queryAll(new Query.CREATE(
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
/*        i.queryAll(new Query.CREATE(
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
/*        i.queryAll(new Query.CREATE(
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
                                        new Data.DoubleVal(22.22))));

        System.out.println(
        tc.typeCheck(new Query.CREATE(new DatabaseIdent("School")), // Should return false;
                new Query.INSERT(
                        new DatabaseIdent("School"),
                        new DatabaseIdent("Midterm Grades"),
                        new Data.DoubleVal(22.22))));



    }
}
