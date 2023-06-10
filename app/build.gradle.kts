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
    hilt {
        enableAggregatingTask = true
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

    api(Libs.coreKtx)
    api(Libs.appcompat)
    api(Libs.material)
    //implementation(Libs.legacy)
    api(Libs.constraintLayout)
    api(Libs.espressoIdlingResource)
    api(Libs.viewModel)
    api(Libs.viewModelSaveState)

    // Kotlin-Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    // Retrofit
    api(Libs.retrofit)
    implementation(Libs.okhttp)
    implementation(Libs.retrofitCoroutineAdapter)
    implementation(Libs.retrofitExperimentalAdapter)
    api(Libs.moshi)
    api(Libs.converterMoshi)

    // navigation
    api(Libs.navigationFragmentKtx)
    api(Libs.navigationUiKtx)
    api(Libs.navigationDynamicFeature)

    // Hilt-library
    api(Libs.hilt)
    api(Libs.hiltNavigation) // working with Navigation
    kapt(Kapt.hilt)
    kapt(Kapt.hiltX) // working with WorkManager

    // Dagger
    api(Libs.dagger)
    api(Libs.daggerAndroid)
    api(Libs.daggerSupport)
    kapt(Kapt.daggerCompiler)
    kapt(Kapt.daggerProcessor)

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