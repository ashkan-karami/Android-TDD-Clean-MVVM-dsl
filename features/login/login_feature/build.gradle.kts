plugins {
    id(Plugins.dynamicFeature)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}
android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}

dependencies {
    implementation(project(":app"))
    implementation(project(":common:ui"))
    implementation(project(":features:login:data"))
    implementation(project(":features:login:domain"))
    implementation(Libs.legacy)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.viewModel)

    // Kotlin-Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    implementation(Libs.hilt)
    kapt(Kapt.hilt)

    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)

    testImplementation(TestLibs.junit)

    androidTestImplementation(AndroidTestLibs.extJunit)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.annotation)
}