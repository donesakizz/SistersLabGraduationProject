
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.yemektarifim2"
    compileSdk = 34

    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.example.yemektarifim2"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //NavigationComponent
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")//2.7.0
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    //viewModel eklentisi
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //okhttp
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    //retrofitClient
    implementation ("com.google.code.gson:gson:2.9.0")

    //dagger-hilt
    implementation ("com.google.dagger:hilt-android:2.44")//2.42
    //kapt 'com.google.dagger:hilt-compiler:2.44'
    kapt ("com.google.dagger:hilt-compiler:2.44")
}