plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
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
    implementation(project(":common:network")) // with retrofit
    implementation(project(":features:login:domain"))

    implementation(Libs.coreKtx)
    testImplementation(TestLibs.junit)

    api(Libs.dagger)
    kapt(Kapt.daggerCompiler)

    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Kapt.room)
}