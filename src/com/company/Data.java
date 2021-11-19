package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Data {
    // Types of data that can be stores in the database

    public static class IntVal extends Data {
        public final int val;

        public IntVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "IntVal{" + val + '}';
        }
    }

    public static class StrVal extends Data {
        public final String val;

        public StrVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "StrVal{"  + val + '}';
        }
    }


    public static class DoubleVal extends Data {
        public final Double val;

        public DoubleVal(Double val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "DoubleVal{" + val + '}';
        }
    }


    public static class ArrayVal extends Data {
        public final ArrayList<Data> val;

        public ArrayVal(Data... val) {
            this.val = new ArrayList<>(Arrays.asList(val));
        }


        @Override
        public String toString() {
            AtomicReference<String> str = new AtomicReference<>("ArrayVal{");
            val.forEach(i-> toStringArrHelper(i, str));
            return str + "}";
        }

    }

    // Case that an ArrayVal has many ArrayVal
    protected void toStringArrHelper(Data val, AtomicReference<String> str) {
        switch (val.getClass().getSimpleName()) {
            case "FloatVal":
            case "StrVal":
            case "IntVal": {
                str.set(str + val.toString());
                return;
            }
            case "ArrayVal": {
                ArrayVal a = (ArrayVal) val;
                a.val.forEach(i->toStringArrHelper(i, str));
            }
        }
    }
}
