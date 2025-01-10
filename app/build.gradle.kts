plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.vyzasolutions.indiaweather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vyzasolutions.indiaweather"
        minSdk = 21
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //Gson converter
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //Gson
    //implementation ("com.google.code.gson:gson:2.11.0")

    //Swipe to refresh Layout
    //implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation ("com.google.android.material:material:1.11.0")
}