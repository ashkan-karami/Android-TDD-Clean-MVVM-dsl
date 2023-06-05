plugins {
    id(Plugins.androidLibrary)
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }

    buildTypes {
        release {
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
    implementation(project(":common:network"))
    // domain classes along with base domain and coroutines
    api(project(":domain"))

    implementation(Libs.coreKtx)
    testImplementation(TestLibs.junit)
}