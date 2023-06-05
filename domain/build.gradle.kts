plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
// base_domain contains domain classes and Coroutines
    implementation(project(":common:base_domain"))
    testImplementation(TestLibs.junit)
}