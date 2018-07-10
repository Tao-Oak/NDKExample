package com.example.caotao.ndkexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    NativeCallbacks mNativeCbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.sample_text);

        TestNDK testNDK= new TestNDK();
        createNativeCallbacks();

        String nativeString = "" + testNDK.getNDKString();
        nativeString += "_" + testNDK.convertToInt(1);
        nativeString += "_" + testNDK.convertToInt(2, "");
        nativeString += "_" + testNDK.convertToInt(3, "", false);

        textView.setText(nativeString);

    }

    private void createNativeCallbacks () {
        mNativeCbs = new NativeCallbacks();
        TestNDK.setNativeCallbacks(mNativeCbs);
    }
}
