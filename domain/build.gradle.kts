plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
// base_domain contains domain classes and Coroutines
    api(project(":common:base_domain"))
    testImplementation(TestLibs.junit)
}