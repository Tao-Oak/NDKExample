#include "com_example_caotao_ndkexample_TestNDK.h"

jobject nativeCallbacks;

void invokeJaveMethod (JNIEnv *);

JNIEXPORT jstring JNICALL
    Java_com_example_caotao_ndkexample_TestNDK_getNDKString (JNIEnv *env, jobject obj) {
    return (*env).NewStringUTF("My Jni Test");
}

JNIEXPORT jint JNICALL
    Java_com_example_caotao_ndkexample_TestNDK_convertToInt__D (JNIEnv *jenv, jobject jobj, jdouble jarg1) {
    invokeJaveMethod(jenv);
    return 1;
}

JNIEXPORT jint JNICALL
    Java_com_example_caotao_ndkexample_TestNDK_convertToInt__DLjava_lang_String_2 (JNIEnv *jenv, jobject jobj, jdouble jarg1, jstring jarg2) {
    (void) jenv;

    return 2;
}

JNIEXPORT jint JNICALL
    Java_com_example_caotao_ndkexample_TestNDK_convertToInt__DLjava_lang_String_2Z (JNIEnv *jenv, jobject jobj, jdouble jarg1, jstring jarg2, jboolean jarg3) {
    return 3;
}

JNIEXPORT void JNICALL
    Java_com_example_caotao_ndkexample_TestNDK_setNativeCallbacks (JNIEnv *jenv, jclass jcls, jobject jself) {
        nativeCallbacks = (jclass) jenv -> NewGlobalRef(jself);
}

void invokeJaveMethod (JNIEnv *jenv) {
    jclass cbClazz = jenv -> GetObjectClass(nativeCallbacks);
    jmethodID mthId = jenv -> GetMethodID(cbClazz, "updateTextString", "()Ljava/lang/String;");
    jenv -> CallObjectMethod(nativeCallbacks, mthId);
}

