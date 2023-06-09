plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.navigationKotlin)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        configurations.all {
            resolutionStrategy { force(Libs.coreKtx) }
        }
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
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    dynamicFeatures += setOf(Features.profileFeature, Features.loginFeature)
}

dependencies {

    api(project(":common:navigation"))
    implementation(project(":common:ui"))

    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.legacy)
    implementation(Libs.constraintLayout)
    implementation(Libs.espressoIdlingResource)
    implementation(Libs.viewModel)

    // Kotlin-Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    // Retrofit
    api(Libs.retrofit)
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:1.0.0")
    api(Libs.moshi)
    api(Libs.converterMoshi)

    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)
    api(Libs.navigationDynamicFeature)

    // Hilt-library
    implementation(Libs.hilt)
    kapt(Kapt.hilt)

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.mockitoKotlin)
    testImplementation(TestLibs.mockitoInline)
    testImplementation(TestLibs.coreTesting)
    testImplementation(TestLibs.coroutines)

    androidTestImplementation(AndroidTestLibs.extJunit)
    androidTestImplementation(AndroidTestLibs.extJunitKtx)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.testRunner)
    androidTestImplementation(AndroidTestLibs.barista) {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "androidx.legacy", module= "legacy-support-core-utils")
    }
}