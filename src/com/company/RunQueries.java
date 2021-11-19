package com.company;


public class RunQueries {


    public static void main(String[] args) {

       Interpreter i = new Interpreter();

        // Program 1 CREATE
/*        i.query(new Query.CREATE(
                new DatabaseIdent("Database CS476")));*/

        // Program 2 CREATE, INSERT
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Database CS476")),
                new Query.INSERT(
                        new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo")));*/

        // Program 3 CREATE, INSERT. RETRIEVE
/*        i.query(new Query.CREATE(
                        new DatabaseIdent("Database CS476")),
                new Query.INSERT(
                        new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1"),
                        new Data.StrVal("Arturo")),
                new Query.RETRIEVE(new DatabaseIdent("Database CS476"),
                        new KeyIdent("Student1")));*/

        // Program 4 CREATE, INSERT, UPDATE, RETRIEVE
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

        // Program 5 CREATE, INSERT, RETRIEVE
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

        // Program 6 CREATE, INSERT, RETRIEVE
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
                        new KeyIdent("Fruits")));*/

        // Program 7 CREATE INSERT REMOVE RETRIEVE
        // ---> error thrown : Invalid DB or Key does not exist. Since Fruits was removed then we tried to retrieve
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

        // Program 8 CREATE INSERT COMBINE RETRIEVE
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

        // Program 9 CREATE INSERT DELETE RETRIEVE
        //  ---> error thrown : Invalid DB or Key does not exist. Since database was deleted
        i.query(new Query.CREATE(
                        new DatabaseIdent("Computer Science Department")),
                new Query.INSERT(
                        new DatabaseIdent("Computer Science Department"),
                        new KeyIdent("Courses"),
                        new Data.ArrayVal(new Data.StrVal("CS476"),
                                          new Data.StrVal("CS474"),
                                          new Data.StrVal("CS401"))),
                new Query.DELETE(new DatabaseIdent("Computer Science Department")),
                new Query.RETRIEVE(new DatabaseIdent("Computer Science Department"),
                                   new KeyIdent("Courses")));

    }
}