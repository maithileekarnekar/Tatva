plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
}

android {
    namespace = "com.androidwavelength.tatva"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.androidwavelength.tatva"
        minSdk = 26
        targetSdk = 35
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.glide)

    //google play services
    implementation(libs.play.services.maps)
    implementation(libs.play.services.location)

    //Room
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.converter.scalars)

    implementation(libs.ccp)
    //viewpager
    implementation(libs.androidx.viewpager)

    //maps
    implementation(libs.maps.utils.ktx)
    implementation(libs.android.maps.utils)

    implementation(libs.androidx.core.ktx)
    implementation(libs.ccp)
    implementation(libs.volley)
}