plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // For annotation processing (needed for Hilt)
    id("com.google.dagger.hilt.android") // For Hilt Dependency Injection
    alias(libs.plugins.kotlin.parcelize)

}

android {
    namespace = "com.example.ap1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ap1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true // Enables ViewBinding for the project
    }
}

dependencies {

    // Core dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navigation component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Retrofit, Moshi, and OkHttp for networking
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.logging.interceptor)
    // Optional Gson converter if needed
    implementation(libs.converter.gson)

    // Lifecycle components for LiveData and ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Coroutines support
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt for dependency injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Unit testing dependencies
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit.v113)
    androidTestImplementation (libs.androidx.espresso.core.v340)

// Mockito for mocking
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.inline)

// Hilt testing dependencies
    androidTestImplementation (libs.hilt.android.testing)
    kaptAndroidTest (libs.hilt.compiler)

    implementation (libs.kotlin.stdlib)

}

kapt {
    correctErrorTypes = true // Ensure kapt handles error types correctly
}