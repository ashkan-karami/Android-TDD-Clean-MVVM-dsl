plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    api(Libs.coroutinesCore)
}