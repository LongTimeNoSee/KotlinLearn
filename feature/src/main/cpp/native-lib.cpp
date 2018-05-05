#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_tv_rings_kotlinloops_feature_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
