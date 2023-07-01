plugins {
    id(Plugins.dynamicFeature)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
}
android {
    namespace = "com.ashkan.userprofile.features.login.login_feature"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
    testImplementation(TestLibs.coroutines)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.mockitoKotlin)
    testImplementation(TestLibs.mockitoInline)

    debugImplementation(DebugLibs.fragmentTesting)
    debugImplementation(DebugLibs.fragmentKtx)

    androidTestImplementation(AndroidTestLibs.extJunit)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.testRunner)
    androidTestImplementation(AndroidTestLibs.fragmentTesting)
}