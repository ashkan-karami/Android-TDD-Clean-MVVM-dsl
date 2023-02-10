import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

//repositories {
//    mavenCentral()
//}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    google()
    mavenCentral()
    maven ( "https://jitpack.io" )
    gradlePluginPortal()
}