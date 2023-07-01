plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
}

android {
    namespace = "com.ashkan.userprofile.features.login.data"
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