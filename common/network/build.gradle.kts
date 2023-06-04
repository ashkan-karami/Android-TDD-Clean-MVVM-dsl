plugins {
    id(Plugins.androidLibrary)
    kotlin("android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // base_domain contains domain classes and Coroutines
    api(project(":common:base_domain"))

    implementation(Libs.coreKtx)
    implementation(Libs.retrofit)
}