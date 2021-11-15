package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    private static final Map<String, Map<String, Data>> databases = new HashMap<>();

    public void query(Query... queries) {
        Arrays.stream(queries).forEach(this::query);
    }

    public void query(Query q) {
        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                Query.CREATE c = (Query.CREATE) q;

                if (checkDBExists(c.DBname.name) != null)
                    throw new Error(c.DBname.name + " already exists");

                databases.put(c.DBname.name, new HashMap<>());
                System.out.println(c.DBname.name + " created.");
                return;
            }
            case "INSERT": {
                Query.INSERT i = (Query.INSERT) q;

                if (checkDBAndKeyExists(i.DBname.name, i.key.name) != null)
                    throw new Error("Invalid DB or Key does not exists");

                databases.get(i.DBname.name).put( i.key.name, i.data);
                System.out.println(i.data + " inserted into key {" + i.key.name + "} on database {"
                        + i.DBname.name + "}");
                return;
            }
            case "RETRIEVE": {
                Query.RETRIEVE g = (Query.RETRIEVE) q;

                if (checkDBAndKeyExists(g.DBname.name, g.key.name) == null)
                    throw new Error("Invalid DB or Key does not exists");

                System.out.println("Retrieved: " + databases.get(g.DBname.name).get(g.key.name) +
                        " from database " + g.DBname.name);
                return;
            }
            case "UPDATE": {
                Query.UPDATE u = (Query.UPDATE) q;

                if (checkDBAndKeyExists(u.DBname.name, u.key.name) == null)
                    throw new Error("Invalid DB or Key does not exists");

                databases.get(u.DBname.name).put(u.key.name, u.updatedData);
                System.out.println("key " + u.key.name + " updated data to " + u.updatedData);
                return;
            }
            case "REMOVE": {
                Query.REMOVE r = (Query.REMOVE) q;

                if (checkDBAndKeyExists(r.DBname.name, r.key.name) == null)
                    throw new Error("Invalid DB or Key does not exists");

                databases.get(r.DBname.name).remove(r.key.name);
                System.out.println("Removed " + r.key.name + " from database " + r.DBname.name);
                return;
            }
            case "DELETE": {
                Query.DELETE d = (Query.DELETE) q;

                if (checkDBExists(d.DBname.name) == null)
                    throw new Error("DB does not exist");

                databases.remove(d.DBname.name);

                System.out.println("Deleted database " + d.DBname.name);

                return;
            }
            case "COMBINE": {
                Query.COMBINE c = (Query.COMBINE) q;

                if (checkDBAndKeyExists(c.DBname.name, c.key1.name) == null ||
                        checkDBAndKeyExists(c.DBname.name, c.key2.name) == null)
                    throw new Error("Invalid DB or Key does not exists");

                Data d1 = databases.get(c.DBname.name).get(c.key1.name);
                Data d2 = databases.get(c.DBname.name).get(c.key2.name);
                databases.get(c.DBname.name).put(c.newKey.name, new Data.ArrayVal(d1, d2));

                System.out.println("Combined data with key " + c.key1.name + " and data with key " + c.key2.name +
                        "  into a new key " + c.newKey.name);
                return;
            }
            default: throw new Error("I don't know the query: " + q.getClass().getSimpleName());
        }
    }

    // Design choice throw an error if DB already exists instead of creating overwriting DB with same name
    public Object checkDBExists(String db) {
        return databases.get(db);
    }

    // Throw an error
    public Object checkDBAndKeyExists(String db, String k) {
        if (databases.get(db) != null)
            return databases.get(db).get(k);
        return null;
    }
}
