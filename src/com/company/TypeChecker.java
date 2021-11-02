package com.company;

public class TypeChecker {

    Boolean typeCheckQuery(Query q, Data.TYPE... typ) {

        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                return ((Query.CREATE) q).DBname.TYP ==  typ[0];
            }
            case "INSERT": {
                return  ((Query.INSERT) q).DBname.TYP == typ[0] &&
                        ((Query.INSERT) q).key.TYP == typ[1] &&
                        ((Query.INSERT) q).data.TYP == typ[2];

            }
            case "RETRIEVE": {
                return  ((Query.RETRIEVE) q).DBname.TYP == typ[0] &&
                        ((Query.RETRIEVE) q).key.TYP == typ[1];
            }
            case "UPDATE": {
                return ((Query.UPDATE) q).DBname.TYP == typ[0] &&
                        ((Query.UPDATE) q).key.TYP == typ[1] &&
                        ((Query.UPDATE) q).updatedData.TYP == typ[2];
            }
            case "REMOVE": {
                return ((Query.REMOVE) q).DBname.TYP == typ[0] &&
                        ((Query.REMOVE) q).key.TYP == typ[1];

            }
            case "DELETE": {
                return ((Query.DELETE) q).DBname.TYP == typ[0];
            }
            case "COMBINE": {
                return ((Query.COMBINE) q).DBname.TYP == typ[0] &&
                        ((Query.COMBINE) q).key.TYP == typ[1] &&
                        ((Query.COMBINE) q).key1.TYP == typ[2] &&
                        ((Query.COMBINE) q).key2.TYP == typ[3];
            }
            default: return false;
        }
    }
}
