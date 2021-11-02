package com.company;

public class TypeChecker {

    public enum TYPE {
        CREATE,
        INSERT,
        RETRIEVE,
        UPDATE,
        REMOVE,
        DELETE,
        COMBINE,
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
            case "RETRIEVE": {
                return typ == TYPE.RETRIEVE &&
                        typeCheck( ((Query.RETRIEVE) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.RETRIEVE) q).key, TYPE.KEYNAME);
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
            case "COMBINE": {
                return typ == TYPE.COMBINE &&
                        typeCheck( ((Query.COMBINE) q).DBname, TYPE.DATABASENAME) &&
                        typeCheck( ((Query.COMBINE) q).key, TYPE.KEYNAME) &&
                        typeCheck( ((Query.COMBINE) q).key1, TYPE.KEYNAME) &&
                        typeCheck( ((Query.COMBINE) q).key2, TYPE.KEYNAME);
            }
            default: return false;
        }
    }
}
