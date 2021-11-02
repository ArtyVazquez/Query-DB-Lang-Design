package com.company;

public abstract class Query {

    public static class CREATE extends Query {
        public final DatabaseName DBname;

        CREATE(DatabaseName DBname) {
            this.DBname = DBname;
        }
    }

    public static class INSERT extends Query {
        public final DatabaseName DBname;
        public final KeyName key;
        public final Data data;

        public INSERT(DatabaseName DBname, KeyName key, Data data) {
            this.DBname = DBname;
            this.key = key;
            this.data = data;
        }
    }

    public static class RETRIEVE extends Query {
        public final DatabaseName DBname;
        public final KeyName key;

        public RETRIEVE(DatabaseName DBname, KeyName key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class UPDATE extends Query {
        public final DatabaseName DBname;
        public final KeyName key;
        public final Data updatedData;

        public UPDATE(DatabaseName DBname, KeyName key, Data updatedData) {
            this.DBname = DBname;
            this.key = key;
            this.updatedData = updatedData;
        }
    }

    public static class REMOVE extends Query {
        public final DatabaseName DBname;
        public final KeyName key;

        public REMOVE(DatabaseName DBname, KeyName key) {
            this.DBname = DBname;
            this.key = key;
        }
    }

    public static class DELETE extends Query {
        public final DatabaseName DBname;

        public DELETE(DatabaseName DBname) {
            this.DBname = DBname;
        }
    }

    //
    public static class COMBINE extends Query {
        public final DatabaseName DBname;
        public final KeyName key;
        public final KeyName key1;
        public final KeyName key2;

        public COMBINE(DatabaseName DBname, KeyName key, KeyName key1, KeyName key2) {
            this.DBname = DBname;
            this.key = key;
            this.key1 = key1;
            this.key2 = key2;
        }
    }
}