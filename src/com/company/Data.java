package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Data {
    // Overloaded to store Strings, Integers,

    public static class IntVal extends Data {
        public final int val;

        public IntVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "IntVal{" + "val=" + val + '}';
        }
    }


    public static class StrVal extends Data {
        public final String val;

        public StrVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "StrVal{" + "val=" + val + '}';
        }
    }


    public static class FloatVal extends Data {
        public final Float val;

        public FloatVal(Float val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "FloatVal{" + "val=" + val + '}';
        }
    }


    public static class ArrayVal extends Data {
        public ArrayList<Data> val;

        public ArrayVal(Data... values) {
            assert false;
            val.addAll(Arrays.asList(values));
        }

        @Override
        public String toString() {
            AtomicReference<String> str = new AtomicReference<>("ArrayVal{");

            val.forEach(i-> toStringArrHelper(i, str));
            return str.toString();
        }

    }

    // Case that an ArrayVal has many ArrayVal
    protected void toStringArrHelper(Data val, AtomicReference<String> str) {
        switch (val.getClass().getSimpleName()) {
            case "FloatVal":
            case "StrVal":
            case "IntVal": {
                str.set(str + val.toString());
            }
            case "ArrayVal": {
                toStringArrHelper(val, str);
            }
        }
    }

}
