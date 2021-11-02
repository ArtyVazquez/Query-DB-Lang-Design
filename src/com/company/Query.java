package com.company;

public abstract class Query {

    public static class CREATE extends Query {
        public final Name DBname;

        CREATE(Name DBname) {
            this.DBname = DBname;
        }
    }

    public static class INSERT extends Query {
        public final Name DBname;
        public final Name key;
        public final Data data;

        public INSERT(Name DBname, Name key, Data data) {
            this.DBname = DBname;
            this.key = key;
            this.data = data;
        }
    }

    public static class RETRIEVE extends Query {
        public final Name DBname;
        public final Name key;

        public RETRIEVE(Name DBname, Name key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class UPDATE extends Query {
        public final Name DBname;
        public final Name key;
        public final Data updatedData;

        public UPDATE(Name DBname, Name key, Data updatedData) {
            this.DBname = DBname;
            this.key = key;
            this.updatedData = updatedData;
        }
    }

    public static class REMOVE extends Query {
        public final Name DBname;
        public final Name key;

        public REMOVE(Name DBname, Name key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class DELETE extends Query {
        public final Name DBname;

        public DELETE(Name DBname) {
            this.DBname = DBname;
        }
    }

    // DESIGN CHOICE LHS (key1) will be combined with RHS (key2) meaning that key1 will have its data itself plus
    // key2's data
    public static class COMBINE extends Query {
        public final Name DBname;
        public final Name key;
        public final Name key1;
        public final Name key2;

        public COMBINE(Name DBname, Name key, Name key1, Name key2) {
            this.DBname = DBname;
            this.key = key;
            this.key1 = key1;
            this.key2 = key2;
        }
    }
}