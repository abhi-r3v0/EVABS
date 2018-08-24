#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_revo_evabs_CustomAccess_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, returnValue);
}