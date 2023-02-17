plugins {
    id(Plugins.androidApplication)
    kotlin("android")
    id("kotlin-kapt")
    id(Plugins.hilt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.espressoIdlingResource)
    implementation(Libs.viewModel)

    // Hilt-library
    implementation(Libs.hilt)
    kapt(Kapt.hilt)

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.mockitoKotlin)
    testImplementation(TestLibs.mockitoInline)
    testImplementation(TestLibs.coreTesting)

    androidTestImplementation(AndroidTestLibs.extJunit)
    androidTestImplementation(AndroidTestLibs.extJunitKtx)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.testRunner)
    androidTestImplementation(AndroidTestLibs.barista) {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "androidx.legacy", module= "legacy-support-core-utils")
    }
}