package com.example.caotao.ndkexample;

import android.util.Log;

public class NativeCallbacks {

    @SuppressWarnings("unused")
    public String updateTextString () {
        Log.d("NativeCallbacks", "Invoke from native side");
        return "new_text_string";
    }
}
