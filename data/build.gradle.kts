plugins {
    alias(libs.plugins.congdanh.android.library)
    alias(libs.plugins.congdanh.android.room)
    alias(libs.plugins.congdanh.android.hilt)
}

android {
    namespace = "com.congdanh.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
}