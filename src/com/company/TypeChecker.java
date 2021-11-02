package com.company;

import java.util.HashMap;

public class TypeChecker {

    public enum TYPE {
        CREATE,
        INSERT,
        GET,
        UPDATE,
        REMOVE,
        DELETE,
        DATABASENAME;
    }


    Boolean typeCheck(Object q, TYPE typ) {

        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                // call type check on the dbName

                return typ == TYPE.CREATE && typeCheck( ((Query.CREATE) q).DBname, TYPE.DATABASENAME);
            }
            case "INSERT": {
                return typ == TYPE.INSERT;
            }
            case "GET": {
                return typ == TYPE.GET;
            }
            case "UPDATE": {
                return typ == TYPE.UPDATE;
            }
            case "REMOVE": {
                return typ == TYPE.REMOVE;
            }
            case "DELETE": {
                return typ == TYPE.DELETE;
            }
            default: return false; // None of the quires are
        }
    }



}
