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
        DATABASENAME,
        KEYNAME,
        DATA
    }

    Boolean typeCheck(Object q, TYPE typ) {

        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                return typ == TYPE.CREATE &&
                        typeCheck( ((Query.CREATE) q).DBname, TYPE.DATABASENAME);
            }
            case "INSERT": {
                return typ == TYPE.INSERT &&
                        typeCheck( ((Query.INSERT) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.INSERT) q).key, TYPE.KEYNAME) &&
                        typeCheck( ((Query.INSERT) q).data, TYPE.DATA);
            }
            case "GET": {
                return typ == TYPE.GET &&
                        typeCheck( ((Query.GET) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.GET) q).key, TYPE.KEYNAME);
            }
            case "UPDATE": {
                return typ == TYPE.UPDATE &&
                        typeCheck( ((Query.UPDATE) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.UPDATE) q).key, TYPE.KEYNAME) &&
                        typeCheck( ((Query.UPDATE) q).updatedData, TYPE.DATA);


            }
            case "REMOVE": {
                return typ == TYPE.REMOVE &&
                        typeCheck( ((Query.REMOVE) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.REMOVE) q).key, TYPE.KEYNAME);

            }
            case "DELETE": {
                return typ == TYPE.DELETE &&
                        typeCheck( ((Query.DELETE) q).DBname, TYPE.DATABASENAME);
            }
            default: return false; // None of the quires are
        }
    }
}
