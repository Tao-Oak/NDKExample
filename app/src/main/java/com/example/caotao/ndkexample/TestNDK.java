package com.example.caotao.ndkexample;

public class TestNDK {
    class InnerClass {}
    static {
        System.loadLibrary("MyLibrary");
    }

    @SuppressWarnings("unused")
    public String getNDKString (int i) {
        return "";
    }
    public native String getNDKString();

    public native int convertToInt (double d);
    public native int convertToInt (double d, String type);
    public native int convertToInt (double d, String type, boolean flag);
    public native int convertToInt (double d, String type, boolean flag, Object obj);
    public native int convertToInt (double d, String type, boolean flag, InnerClass obj);

    public static native void setNativeCallbacks (NativeCallbacks nativeCbs);
}
