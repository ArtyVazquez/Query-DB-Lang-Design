package com.company;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    // Map which will store
    private static final Map<String, Map<String, Data>> databases = new HashMap<>();

    public void query(Query q) {
        switch (q.getClass().getSimpleName()) {
            case "CREATE": {
                Query.CREATE c = (Query.CREATE) q;
                databases.put(c.DBname.name, new HashMap<>());
                System.out.println(c.DBname.name + " created.");
                return;
            }
            case "INSERT": {
                Query.INSERT i = (Query.INSERT) q;
                databases.get(i.DBname.name).put(i.key.name, i.data);
                System.out.println(i.data + " inserted into key {" + i.key.name + "} on database {" + i.DBname.name + "}");
                return;
            }
            case "GET": {
                Query.GET g = (Query.GET) q;
                System.out.println("Retrieved: " +databases.get(g.DBname.name).get(g.key.name));
                return;
            }
            case "UPDATE": {
                Query.UPDATE u = (Query.UPDATE) q;
                databases.get(u.DBname.name).put(u.key.name, u.updatedData);
                System.out.println("key " + u.key.name + " updated data to " + u.updatedData);
                return;
            }
            case "REMOVE": {
                Query.REMOVE r = (Query.REMOVE) q;
                databases.get(r.DBname.name).remove(r.key.name);
                System.out.println("Removed " + r.key.name);
                return;
            }
            case "DELETE": {
                Query.DELETE d = (Query.DELETE) q;
                databases.remove("Deleted " + d.DBname.name);
            }
        }

    }

    // Design choice throw an error if DB already exists instead of creating overwriting DB with same name
    public void checkDBExists() {

    }

    // Throw an error if a Key is not within a DB
    public void checkDBKeyExists() {

    }


}

// Create
// Insert
// Retrieve
// Update
// Remove
// Combine  --> data will have to be combined into a Data ArrayVar
// Delete
