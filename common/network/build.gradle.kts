plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    namespace = "com.ashkan.userprofile.common.network"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // base_domain contains domain classes and Coroutines
    implementation(project(":common:base_domain"))

    implementation(Libs.coreKtx)
    api(Libs.retrofit)
    api(Libs.moshi)
    api(Libs.converterMoshi)
}