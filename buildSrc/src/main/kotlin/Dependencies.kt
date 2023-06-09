object Plugins{
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val javaLibrary = "java-library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val android = "android"
    const val kotlinKapt = "kotlin-kapt"
    const val hilt = "com.google.dagger.hilt.android"
    const val navigation = "androidx.navigation.safeargs"
    const val navigationKotlin = "androidx.navigation.safeargs.kotlin"
}

object Libs{
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResource}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val javaInject = "javax.inject:javax.inject:1"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationDynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.converterMoshi}"
}

object TestLibs{
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object AndroidTestLibs{
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val extJunitKtx = "androidx.test.ext:junit-ktx:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val barista = "com.adevinta.android:barista:${Versions.barista}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
}

object Kapt{
    const val hilt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val dataBinding = "androidx.databinding:databinding-compiler:${Versions.dataBinding}"
}

object Features{
    const val profileFeature = ":features:profile:profile_feature"
    const val loginFeature = ":features:login:login_feature"
}