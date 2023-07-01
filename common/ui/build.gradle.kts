plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    namespace = "com.ashkan.userprofile.common.ui"
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
    buildFeatures {
        dataBinding = true
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

    api(project(":common:network"))
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
}