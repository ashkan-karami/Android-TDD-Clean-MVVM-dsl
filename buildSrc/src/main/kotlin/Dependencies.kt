object Plugins{
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val hilt = "com.google.dagger.hilt.android"
}

object Libs{
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResource}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
}

object TestLibs{
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
}

object AndroidTestLibs{
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val extJunitKtx = "androidx.test.ext:junit-ktx:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val barista = "com.adevinta.android:barista:${Versions.barista}"
}

object Kapt{
    const val hilt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}