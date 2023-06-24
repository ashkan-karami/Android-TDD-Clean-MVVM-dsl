plugins {
    id(Plugins.dynamicFeature)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
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

    kapt(Kapt.daggerCompiler)
    kapt(Kapt.daggerProcessor)
    kapt(Kapt.room)

    testImplementation(TestLibs.junit)

    debugImplementation(DebugLibs.fragmentTesting)

    androidTestImplementation(AndroidTestLibs.extJunit)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.testRunner)
}