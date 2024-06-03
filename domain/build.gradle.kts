plugins {
    alias(libs.plugins.congdanh.android.library)
    alias(libs.plugins.congdanh.android.hilt)
}

android {
    namespace = "com.congdanh.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}