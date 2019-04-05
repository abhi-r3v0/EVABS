#include <jni.h>
#include <string>

std::string hrex(int i);

std::string hlex(int i);





extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_CustomAccess_stringFromJNI(JNIEnv *env, jobject instance) {

    std::string r_half_key = hrex(2);
    std::string l_half_key = hlex(3);

    int a1[] = { 97, 108, 119, 97, 121, 115, 95, 118, 101, 114, 49, 102, 121, 95, 112, 97, 99, 107, 97, 103, 51, 115 };

    char a3[22];

    for(int i=0; i<22; ++i){
        a3[i] = char(a1[i]);
    }
    std::string custaccess = std::string(a3);

    //std::string sensor_key = flag;
    std::string flag = custaccess;



    return env->NewStringUTF(flag.c_str());
}

std::string hlex(int y) {
    int i;
    int h4[] = {95, 115, 101, 110, 115, 48, 114};
    int h5[7];
    char h6[7];

    for(i=0;i<7;++i)
    {
        h5[i] = h4[i] + y;
    }

    for(i=0;i<7;++i)
    {
        h6[i] = char(h5[i]);
    }

    return std::string(h6);
}


std::string hrex(int x) {
    int i;
    int h1[] = {95, 51, 118, 97, 98, 36, 95};
    int h2[7];
    char h3[7];

    for(i=0;i<7;++i)
    {
        h2[i] = h1[i] + x;
    }

    for(i=0;i<7;++i)
    {
        h3[i] = char(h2[i]);
    }

    return std::string(h3);
}



extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_DebugMe_stringFromJNI(JNIEnv *env, jobject instance) {

    int a1[] = { 108, 111, 103, 103, 105, 110, 103, 95, 105, 110, 102, 111, 95, 110, 101, 118, 101, 114, 95, 115, 97, 102, 101 };

    char a3[23];

    for(int i=0; i<23; ++i){
        a3[i] = char(a1[i]);
    }
    std::string debugged = std::string(a3);
    return env->NewStringUTF(debugged.c_str());
}




extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_Welcome_stringFromJNI(JNIEnv *env, jobject instance) {

    int a1[] = {115, 104, 97, 114, 51, 100, 95, 112, 114, 51, 102, 115, 95, 99, 48, 117, 108, 100, 95, 98, 101, 95, 99, 48, 109, 112, 114, 111, 109, 105, 122, 51, 100};
    char a3[33];

    for(int i=0; i<33; ++i){
        a3[i] = char(a1[i]);
    }

    std::string sharedpref = std::string(a3);

    return env->NewStringUTF(sharedpref.c_str());
}




extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_DBLeak_stringFromJNI(JNIEnv *env, jobject instance) {

    int a1[] = {69, 86, 65, 66, 83, 123, 115, 113, 108, 105, 116, 101, 95, 105, 115, 95, 110, 111, 116, 95, 115, 97, 102, 101, 125};
    char a3[25];

    for(int i=0; i<25; i++)
    {
        a3[i] = char(a1[i]);
    }

    std::string dbstr = std::string(a3);

    return env->NewStringUTF(dbstr.c_str());
}




extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_ExportedActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    int a1[] = {69, 86, 65, 66, 83, 123, 101, 120, 112, 48, 114, 116, 101, 100, 95, 97, 99, 116, 105, 118, 105, 116, 105, 101, 115, 95, 97, 114, 51, 95, 104, 97, 114, 109, 102, 117, 108, 125};
    char a3[38];

    for(int i=0; i<38; ++i){
        a3[i] = char(a1[i]);
    }

    std::string exported = std::string(a3);
    return env->NewStringUTF(exported.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_SmaliInject_stringFromSmali(JNIEnv *env, jobject instance) {

    int a1[] = {115,109,97,108,105,95,105,110,106,95,105,115,95,108,51,116,104,97,108};

    char a3[19];

    for(int i=0; i<19; ++i){
        a3[i] = char(a1[i]);
    }

    std::string labon = std::string(a3);

    return env->NewStringUTF(labon.c_str());
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_revo_evabs_Frida1_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO
    int a1[] = {69, 86, 65, 66, 83, 123, 97, 95, 100, 121, 110, 97, 109, 49, 99, 95, 104, 48, 48, 107, 125};
    char a3[21];

    for(int i=0; i<21; ++i){
        a3[i] = char(a1[i]);
    }

    std::string frida = std::string(a3);

    return env->NewStringUTF(frida.c_str());
}