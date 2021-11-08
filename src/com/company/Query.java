package com.company;

public abstract class Query {

    public static class CREATE extends Query {
        public final Ident DBname;

        CREATE(Ident DBname) {
            this.DBname = DBname;
        }
    }

    public static class INSERT extends Query {
        public final Ident DBname;
        public final Ident key;
        public final Data data;

        public INSERT(Ident DBname, Ident key, Data data) {
            this.DBname = DBname;
            this.key = key;
            this.data = data;
        }
    }

    public static class RETRIEVE extends Query {
        public final Ident DBname;
        public final Ident key;

        public RETRIEVE(Ident DBname, Ident key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class UPDATE extends Query {
        public final Ident DBname;
        public final Ident key;
        public final Data updatedData;

        public UPDATE(Ident DBname, Ident key, Data updatedData) {
            this.DBname = DBname;
            this.key = key;
            this.updatedData = updatedData;
        }
    }

    public static class REMOVE extends Query {
        public final Ident DBname;
        public final Ident key;

        public REMOVE(Ident DBname, Ident key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class DELETE extends Query {
        public final Ident DBname;

        public DELETE(Ident DBname) {
            this.DBname = DBname;
        }
    }

    public static class COMBINE extends Query {
        public final Ident DBname;
        public final Ident key;
        public final Ident key1;
        public final Ident key2;

        public COMBINE(Ident DBname, Ident key, Ident key1, Ident key2) {
            this.DBname = DBname;
            this.key = key;
            this.key1 = key1;
            this.key2 = key2;
        }
    }
}