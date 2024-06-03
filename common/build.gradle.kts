plugins {
    alias(libs.plugins.congdanh.android.library)
    alias(libs.plugins.congdanh.android.hilt)
}

android {
    namespace = "com.congdanh.common"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    api(libs.timber)
}