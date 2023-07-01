plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    namespace = "com.ashkan.userprofile.features.profile.data"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":common:network"))

    implementation(Libs.coreKtx)
    testImplementation(TestLibs.junit)
}