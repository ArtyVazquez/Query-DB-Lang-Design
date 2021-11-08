package com.company;

import java.util.Arrays;

public class TypeChecker {


    Boolean typeCheck(Query... quires) {
        return Arrays.stream(quires).allMatch(this::typeCheck);
    }

    boolean typeCheck(Query q) {
        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                return ((Query.CREATE) q).DBname.TYP ==  Data.TYPE.DATABASE;
            }
            case "INSERT": {
                return  ((Query.INSERT) q).DBname.TYP == Data.TYPE.DATABASE &&
                        ((Query.INSERT) q).key.TYP == Data.TYPE.KEY &&
                        ((Query.INSERT) q).data.TYP == Data.TYPE.DATA;

            }
            case "RETRIEVE": {
                return  ((Query.RETRIEVE) q).DBname.TYP == Data.TYPE.DATABASE &&
                        ((Query.RETRIEVE) q).key.TYP == Data.TYPE.KEY;
            }
            case "UPDATE": {
                return ((Query.UPDATE) q).DBname.TYP == Data.TYPE.DATABASE &&
                        ((Query.UPDATE) q).key.TYP == Data.TYPE.KEY &&
                        ((Query.UPDATE) q).updatedData.TYP == Data.TYPE.DATA;
            }
            case "REMOVE": {
                return ((Query.REMOVE) q).DBname.TYP == Data.TYPE.DATABASE &&
                        ((Query.REMOVE) q).key.TYP == Data.TYPE.KEY;

            }
            case "DELETE": {
                return ((Query.DELETE) q).DBname.TYP == Data.TYPE.DATABASE;
            }
            case "COMBINE": {
                return ((Query.COMBINE) q).DBname.TYP == Data.TYPE.DATABASE &&
                        ((Query.COMBINE) q).key.TYP == Data.TYPE.KEY &&
                        ((Query.COMBINE) q).key1.TYP == Data.TYPE.KEY &&
                        ((Query.COMBINE) q).key2.TYP == Data.TYPE.KEY;
            }
            default: return false;
        }
    }
}
